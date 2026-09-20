package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DiscussbijixinxiEntity;
import com.cl.entity.view.DiscussbijixinxiView;

import com.cl.service.DiscussbijixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 笔记信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-21 22:42:46
 */
@RestController
@RequestMapping("/discussbijixinxi")
public class DiscussbijixinxiController {
    @Autowired
    private DiscussbijixinxiService discussbijixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussbijixinxiEntity discussbijixinxi,
		HttpServletRequest request){
        EntityWrapper<DiscussbijixinxiEntity> ew = new EntityWrapper<DiscussbijixinxiEntity>();

		PageUtils page = discussbijixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussbijixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussbijixinxiEntity discussbijixinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussbijixinxiEntity> ew = new EntityWrapper<DiscussbijixinxiEntity>();

		PageUtils page = discussbijixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussbijixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussbijixinxiEntity discussbijixinxi){
       	EntityWrapper<DiscussbijixinxiEntity> ew = new EntityWrapper<DiscussbijixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussbijixinxi, "discussbijixinxi")); 
        return R.ok().put("data", discussbijixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussbijixinxiEntity discussbijixinxi){
        EntityWrapper< DiscussbijixinxiEntity> ew = new EntityWrapper< DiscussbijixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussbijixinxi, "discussbijixinxi")); 
		DiscussbijixinxiView discussbijixinxiView =  discussbijixinxiService.selectView(ew);
		return R.ok("查询笔记信息评论表成功").put("data", discussbijixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussbijixinxiEntity discussbijixinxi = discussbijixinxiService.selectById(id);
		discussbijixinxi = discussbijixinxiService.selectView(new EntityWrapper<DiscussbijixinxiEntity>().eq("id", id));
        return R.ok().put("data", discussbijixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussbijixinxiEntity discussbijixinxi = discussbijixinxiService.selectById(id);
		discussbijixinxi = discussbijixinxiService.selectView(new EntityWrapper<DiscussbijixinxiEntity>().eq("id", id));
        return R.ok().put("data", discussbijixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussbijixinxiEntity discussbijixinxi, HttpServletRequest request){
    	discussbijixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussbijixinxi);
        discussbijixinxiService.insert(discussbijixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussbijixinxiEntity discussbijixinxi, HttpServletRequest request){
    	discussbijixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussbijixinxi);
        discussbijixinxiService.insert(discussbijixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussbijixinxiEntity discussbijixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussbijixinxi);
        discussbijixinxiService.updateById(discussbijixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussbijixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussbijixinxiEntity discussbijixinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussbijixinxiEntity> ew = new EntityWrapper<DiscussbijixinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussbijixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussbijixinxi), params), params));
        return R.ok().put("data", page);
    }








}

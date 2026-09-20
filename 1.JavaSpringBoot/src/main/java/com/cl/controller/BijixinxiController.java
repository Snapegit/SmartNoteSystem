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

import com.cl.entity.BijixinxiEntity;
import com.cl.entity.view.BijixinxiView;

import com.cl.service.BijixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 笔记信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-21 22:42:46
 */
@RestController
@RequestMapping("/bijixinxi")
public class BijixinxiController {
    @Autowired
    private BijixinxiService bijixinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BijixinxiEntity bijixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			bijixinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BijixinxiEntity> ew = new EntityWrapper<BijixinxiEntity>();

		PageUtils page = bijixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bijixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BijixinxiEntity bijixinxi, 
		HttpServletRequest request){
        EntityWrapper<BijixinxiEntity> ew = new EntityWrapper<BijixinxiEntity>();

		PageUtils page = bijixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bijixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BijixinxiEntity bijixinxi){
       	EntityWrapper<BijixinxiEntity> ew = new EntityWrapper<BijixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bijixinxi, "bijixinxi")); 
        return R.ok().put("data", bijixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BijixinxiEntity bijixinxi){
        EntityWrapper< BijixinxiEntity> ew = new EntityWrapper< BijixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bijixinxi, "bijixinxi")); 
		BijixinxiView bijixinxiView =  bijixinxiService.selectView(ew);
		return R.ok("查询笔记信息成功").put("data", bijixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BijixinxiEntity bijixinxi = bijixinxiService.selectById(id);
		bijixinxi.setClicknum(bijixinxi.getClicknum()+1);
		bijixinxi.setClicktime(new Date());
		bijixinxiService.updateById(bijixinxi);
		bijixinxi = bijixinxiService.selectView(new EntityWrapper<BijixinxiEntity>().eq("id", id));
        return R.ok().put("data", bijixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BijixinxiEntity bijixinxi = bijixinxiService.selectById(id);
		bijixinxi.setClicknum(bijixinxi.getClicknum()+1);
		bijixinxi.setClicktime(new Date());
		bijixinxiService.updateById(bijixinxi);
		bijixinxi = bijixinxiService.selectView(new EntityWrapper<BijixinxiEntity>().eq("id", id));
        return R.ok().put("data", bijixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BijixinxiEntity bijixinxi, HttpServletRequest request){
    	bijixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bijixinxi);
        bijixinxiService.insert(bijixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BijixinxiEntity bijixinxi, HttpServletRequest request){
    	bijixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bijixinxi);
        bijixinxiService.insert(bijixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BijixinxiEntity bijixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bijixinxi);
        bijixinxiService.updateById(bijixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bijixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,BijixinxiEntity bijixinxi, HttpServletRequest request,String pre){
        EntityWrapper<BijixinxiEntity> ew = new EntityWrapper<BijixinxiEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = bijixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bijixinxi), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,BijixinxiEntity bijixinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "bijifenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "bijixinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<BijixinxiEntity> bijixinxiList = new ArrayList<BijixinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                bijixinxiList.addAll(bijixinxiService.selectList(new EntityWrapper<BijixinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<BijixinxiEntity> ew = new EntityWrapper<BijixinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = bijixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bijixinxi), params), params));
        List<BijixinxiEntity> pageList = (List<BijixinxiEntity>)page.getList();
        if(bijixinxiList.size()<limit) {
            int toAddNum = (limit-bijixinxiList.size())<=pageList.size()?(limit-bijixinxiList.size()):pageList.size();
            for(BijixinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(BijixinxiEntity o2 : bijixinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    bijixinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(bijixinxiList.size()>limit) {
            bijixinxiList = bijixinxiList.subList(0, limit);
        }
        page.setList(bijixinxiList);
        return R.ok().put("data", page);
    }







}

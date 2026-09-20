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

import com.cl.entity.BijifenleiEntity;
import com.cl.entity.view.BijifenleiView;

import com.cl.service.BijifenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 笔记分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-21 22:42:45
 */
@RestController
@RequestMapping("/bijifenlei")
public class BijifenleiController {
    @Autowired
    private BijifenleiService bijifenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BijifenleiEntity bijifenlei,
		HttpServletRequest request){
        EntityWrapper<BijifenleiEntity> ew = new EntityWrapper<BijifenleiEntity>();

		PageUtils page = bijifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bijifenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BijifenleiEntity bijifenlei, 
		HttpServletRequest request){
        EntityWrapper<BijifenleiEntity> ew = new EntityWrapper<BijifenleiEntity>();

		PageUtils page = bijifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bijifenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BijifenleiEntity bijifenlei){
       	EntityWrapper<BijifenleiEntity> ew = new EntityWrapper<BijifenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bijifenlei, "bijifenlei")); 
        return R.ok().put("data", bijifenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BijifenleiEntity bijifenlei){
        EntityWrapper< BijifenleiEntity> ew = new EntityWrapper< BijifenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bijifenlei, "bijifenlei")); 
		BijifenleiView bijifenleiView =  bijifenleiService.selectView(ew);
		return R.ok("查询笔记分类成功").put("data", bijifenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BijifenleiEntity bijifenlei = bijifenleiService.selectById(id);
		bijifenlei = bijifenleiService.selectView(new EntityWrapper<BijifenleiEntity>().eq("id", id));
        return R.ok().put("data", bijifenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BijifenleiEntity bijifenlei = bijifenleiService.selectById(id);
		bijifenlei = bijifenleiService.selectView(new EntityWrapper<BijifenleiEntity>().eq("id", id));
        return R.ok().put("data", bijifenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BijifenleiEntity bijifenlei, HttpServletRequest request){
    	bijifenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bijifenlei);
        bijifenleiService.insert(bijifenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BijifenleiEntity bijifenlei, HttpServletRequest request){
    	bijifenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bijifenlei);
        bijifenleiService.insert(bijifenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BijifenleiEntity bijifenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bijifenlei);
        bijifenleiService.updateById(bijifenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bijifenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

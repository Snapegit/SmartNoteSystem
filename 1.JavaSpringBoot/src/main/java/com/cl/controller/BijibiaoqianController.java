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

import com.cl.entity.BijibiaoqianEntity;
import com.cl.entity.view.BijibiaoqianView;

import com.cl.service.BijibiaoqianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 笔记标签
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-21 22:42:46
 */
@RestController
@RequestMapping("/bijibiaoqian")
public class BijibiaoqianController {
    @Autowired
    private BijibiaoqianService bijibiaoqianService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BijibiaoqianEntity bijibiaoqian,
		HttpServletRequest request){
        EntityWrapper<BijibiaoqianEntity> ew = new EntityWrapper<BijibiaoqianEntity>();

		PageUtils page = bijibiaoqianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bijibiaoqian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BijibiaoqianEntity bijibiaoqian, 
		HttpServletRequest request){
        EntityWrapper<BijibiaoqianEntity> ew = new EntityWrapper<BijibiaoqianEntity>();

		PageUtils page = bijibiaoqianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bijibiaoqian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BijibiaoqianEntity bijibiaoqian){
       	EntityWrapper<BijibiaoqianEntity> ew = new EntityWrapper<BijibiaoqianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bijibiaoqian, "bijibiaoqian")); 
        return R.ok().put("data", bijibiaoqianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BijibiaoqianEntity bijibiaoqian){
        EntityWrapper< BijibiaoqianEntity> ew = new EntityWrapper< BijibiaoqianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bijibiaoqian, "bijibiaoqian")); 
		BijibiaoqianView bijibiaoqianView =  bijibiaoqianService.selectView(ew);
		return R.ok("查询笔记标签成功").put("data", bijibiaoqianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BijibiaoqianEntity bijibiaoqian = bijibiaoqianService.selectById(id);
		bijibiaoqian = bijibiaoqianService.selectView(new EntityWrapper<BijibiaoqianEntity>().eq("id", id));
        return R.ok().put("data", bijibiaoqian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BijibiaoqianEntity bijibiaoqian = bijibiaoqianService.selectById(id);
		bijibiaoqian = bijibiaoqianService.selectView(new EntityWrapper<BijibiaoqianEntity>().eq("id", id));
        return R.ok().put("data", bijibiaoqian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BijibiaoqianEntity bijibiaoqian, HttpServletRequest request){
    	bijibiaoqian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bijibiaoqian);
        bijibiaoqianService.insert(bijibiaoqian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BijibiaoqianEntity bijibiaoqian, HttpServletRequest request){
    	bijibiaoqian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bijibiaoqian);
        bijibiaoqianService.insert(bijibiaoqian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BijibiaoqianEntity bijibiaoqian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bijibiaoqian);
        bijibiaoqianService.updateById(bijibiaoqian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bijibiaoqianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.BijibiaoqianDao;
import com.cl.entity.BijibiaoqianEntity;
import com.cl.service.BijibiaoqianService;
import com.cl.entity.view.BijibiaoqianView;

@Service("bijibiaoqianService")
public class BijibiaoqianServiceImpl extends ServiceImpl<BijibiaoqianDao, BijibiaoqianEntity> implements BijibiaoqianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BijibiaoqianEntity> page = this.selectPage(
                new Query<BijibiaoqianEntity>(params).getPage(),
                new EntityWrapper<BijibiaoqianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BijibiaoqianEntity> wrapper) {
		  Page<BijibiaoqianView> page =new Query<BijibiaoqianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BijibiaoqianView> selectListView(Wrapper<BijibiaoqianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BijibiaoqianView selectView(Wrapper<BijibiaoqianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

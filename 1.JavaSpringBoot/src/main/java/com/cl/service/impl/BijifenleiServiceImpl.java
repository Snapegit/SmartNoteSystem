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


import com.cl.dao.BijifenleiDao;
import com.cl.entity.BijifenleiEntity;
import com.cl.service.BijifenleiService;
import com.cl.entity.view.BijifenleiView;

@Service("bijifenleiService")
public class BijifenleiServiceImpl extends ServiceImpl<BijifenleiDao, BijifenleiEntity> implements BijifenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BijifenleiEntity> page = this.selectPage(
                new Query<BijifenleiEntity>(params).getPage(),
                new EntityWrapper<BijifenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BijifenleiEntity> wrapper) {
		  Page<BijifenleiView> page =new Query<BijifenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BijifenleiView> selectListView(Wrapper<BijifenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BijifenleiView selectView(Wrapper<BijifenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

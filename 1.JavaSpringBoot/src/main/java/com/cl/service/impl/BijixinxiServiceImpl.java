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


import com.cl.dao.BijixinxiDao;
import com.cl.entity.BijixinxiEntity;
import com.cl.service.BijixinxiService;
import com.cl.entity.view.BijixinxiView;

@Service("bijixinxiService")
public class BijixinxiServiceImpl extends ServiceImpl<BijixinxiDao, BijixinxiEntity> implements BijixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BijixinxiEntity> page = this.selectPage(
                new Query<BijixinxiEntity>(params).getPage(),
                new EntityWrapper<BijixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BijixinxiEntity> wrapper) {
		  Page<BijixinxiView> page =new Query<BijixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BijixinxiView> selectListView(Wrapper<BijixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BijixinxiView selectView(Wrapper<BijixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

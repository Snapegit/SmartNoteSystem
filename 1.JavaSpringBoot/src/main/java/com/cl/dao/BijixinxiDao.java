package com.cl.dao;

import com.cl.entity.BijixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BijixinxiView;


/**
 * 笔记信息
 * 
 * @author 
 * @email 
 * @date 2024-01-21 22:42:46
 */
public interface BijixinxiDao extends BaseMapper<BijixinxiEntity> {
	
	List<BijixinxiView> selectListView(@Param("ew") Wrapper<BijixinxiEntity> wrapper);

	List<BijixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<BijixinxiEntity> wrapper);
	
	BijixinxiView selectView(@Param("ew") Wrapper<BijixinxiEntity> wrapper);
	

}

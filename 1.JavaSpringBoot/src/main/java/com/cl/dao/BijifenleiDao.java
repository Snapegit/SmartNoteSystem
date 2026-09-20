package com.cl.dao;

import com.cl.entity.BijifenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BijifenleiView;


/**
 * 笔记分类
 * 
 * @author 
 * @email 
 * @date 2024-01-21 22:42:45
 */
public interface BijifenleiDao extends BaseMapper<BijifenleiEntity> {
	
	List<BijifenleiView> selectListView(@Param("ew") Wrapper<BijifenleiEntity> wrapper);

	List<BijifenleiView> selectListView(Pagination page,@Param("ew") Wrapper<BijifenleiEntity> wrapper);
	
	BijifenleiView selectView(@Param("ew") Wrapper<BijifenleiEntity> wrapper);
	

}

package com.cl.dao;

import com.cl.entity.BijibiaoqianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BijibiaoqianView;


/**
 * 笔记标签
 * 
 * @author 
 * @email 
 * @date 2024-01-21 22:42:46
 */
public interface BijibiaoqianDao extends BaseMapper<BijibiaoqianEntity> {
	
	List<BijibiaoqianView> selectListView(@Param("ew") Wrapper<BijibiaoqianEntity> wrapper);

	List<BijibiaoqianView> selectListView(Pagination page,@Param("ew") Wrapper<BijibiaoqianEntity> wrapper);
	
	BijibiaoqianView selectView(@Param("ew") Wrapper<BijibiaoqianEntity> wrapper);
	

}

package com.cl.dao;

import com.cl.entity.DiscussbijixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussbijixinxiView;


/**
 * 笔记信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-01-21 22:42:46
 */
public interface DiscussbijixinxiDao extends BaseMapper<DiscussbijixinxiEntity> {
	
	List<DiscussbijixinxiView> selectListView(@Param("ew") Wrapper<DiscussbijixinxiEntity> wrapper);

	List<DiscussbijixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussbijixinxiEntity> wrapper);
	
	DiscussbijixinxiView selectView(@Param("ew") Wrapper<DiscussbijixinxiEntity> wrapper);
	

}

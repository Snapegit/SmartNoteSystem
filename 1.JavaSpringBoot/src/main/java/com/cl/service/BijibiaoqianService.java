package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BijibiaoqianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BijibiaoqianView;


/**
 * 笔记标签
 *
 * @author 
 * @email 
 * @date 2024-01-21 22:42:46
 */
public interface BijibiaoqianService extends IService<BijibiaoqianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BijibiaoqianView> selectListView(Wrapper<BijibiaoqianEntity> wrapper);
   	
   	BijibiaoqianView selectView(@Param("ew") Wrapper<BijibiaoqianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BijibiaoqianEntity> wrapper);
   	

}


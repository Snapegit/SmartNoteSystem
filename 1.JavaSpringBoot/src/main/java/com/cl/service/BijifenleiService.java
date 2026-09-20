package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BijifenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BijifenleiView;


/**
 * 笔记分类
 *
 * @author 
 * @email 
 * @date 2024-01-21 22:42:45
 */
public interface BijifenleiService extends IService<BijifenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BijifenleiView> selectListView(Wrapper<BijifenleiEntity> wrapper);
   	
   	BijifenleiView selectView(@Param("ew") Wrapper<BijifenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BijifenleiEntity> wrapper);
   	

}


package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BijixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BijixinxiView;


/**
 * 笔记信息
 *
 * @author 
 * @email 
 * @date 2024-01-21 22:42:46
 */
public interface BijixinxiService extends IService<BijixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BijixinxiView> selectListView(Wrapper<BijixinxiEntity> wrapper);
   	
   	BijixinxiView selectView(@Param("ew") Wrapper<BijixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BijixinxiEntity> wrapper);
   	

}


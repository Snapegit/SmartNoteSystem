package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussbijixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussbijixinxiView;


/**
 * 笔记信息评论表
 *
 * @author 
 * @email 
 * @date 2024-01-21 22:42:46
 */
public interface DiscussbijixinxiService extends IService<DiscussbijixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussbijixinxiView> selectListView(Wrapper<DiscussbijixinxiEntity> wrapper);
   	
   	DiscussbijixinxiView selectView(@Param("ew") Wrapper<DiscussbijixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussbijixinxiEntity> wrapper);
   	

}


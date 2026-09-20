package com.cl.entity.view;

import com.cl.entity.DiscussbijixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 笔记信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-21 22:42:46
 */
@TableName("discussbijixinxi")
public class DiscussbijixinxiView  extends DiscussbijixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussbijixinxiView(){
	}
 
 	public DiscussbijixinxiView(DiscussbijixinxiEntity discussbijixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussbijixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

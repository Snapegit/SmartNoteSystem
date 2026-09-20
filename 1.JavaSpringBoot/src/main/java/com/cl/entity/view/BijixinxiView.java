package com.cl.entity.view;

import com.cl.entity.BijixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 笔记信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-21 22:42:46
 */
@TableName("bijixinxi")
public class BijixinxiView  extends BijixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BijixinxiView(){
	}
 
 	public BijixinxiView(BijixinxiEntity bijixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, bijixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

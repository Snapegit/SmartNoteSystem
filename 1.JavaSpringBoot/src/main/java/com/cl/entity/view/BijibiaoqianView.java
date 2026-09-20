package com.cl.entity.view;

import com.cl.entity.BijibiaoqianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 笔记标签
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-21 22:42:46
 */
@TableName("bijibiaoqian")
public class BijibiaoqianView  extends BijibiaoqianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BijibiaoqianView(){
	}
 
 	public BijibiaoqianView(BijibiaoqianEntity bijibiaoqianEntity){
 	try {
			BeanUtils.copyProperties(this, bijibiaoqianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

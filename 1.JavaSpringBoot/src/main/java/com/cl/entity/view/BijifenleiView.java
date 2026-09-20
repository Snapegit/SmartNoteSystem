package com.cl.entity.view;

import com.cl.entity.BijifenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 笔记分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-21 22:42:45
 */
@TableName("bijifenlei")
public class BijifenleiView  extends BijifenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BijifenleiView(){
	}
 
 	public BijifenleiView(BijifenleiEntity bijifenleiEntity){
 	try {
			BeanUtils.copyProperties(this, bijifenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

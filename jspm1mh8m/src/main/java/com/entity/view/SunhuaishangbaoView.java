package com.entity.view;

import com.entity.SunhuaishangbaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 损坏上报
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-29 17:28:30
 */
@TableName("sunhuaishangbao")
public class SunhuaishangbaoView  extends SunhuaishangbaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SunhuaishangbaoView(){
	}
 
 	public SunhuaishangbaoView(SunhuaishangbaoEntity sunhuaishangbaoEntity){
 	try {
			BeanUtils.copyProperties(this, sunhuaishangbaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

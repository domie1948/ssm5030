package com.dao;

import com.entity.SunhuaishangbaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SunhuaishangbaoVO;
import com.entity.view.SunhuaishangbaoView;


/**
 * 损坏上报
 * 
 * @author 
 * @email 
 * @date 2021-01-29 17:28:30
 */
public interface SunhuaishangbaoDao extends BaseMapper<SunhuaishangbaoEntity> {
	
	List<SunhuaishangbaoVO> selectListVO(@Param("ew") Wrapper<SunhuaishangbaoEntity> wrapper);
	
	SunhuaishangbaoVO selectVO(@Param("ew") Wrapper<SunhuaishangbaoEntity> wrapper);
	
	List<SunhuaishangbaoView> selectListView(@Param("ew") Wrapper<SunhuaishangbaoEntity> wrapper);

	List<SunhuaishangbaoView> selectListView(Pagination page,@Param("ew") Wrapper<SunhuaishangbaoEntity> wrapper);
	
	SunhuaishangbaoView selectView(@Param("ew") Wrapper<SunhuaishangbaoEntity> wrapper);
	
}

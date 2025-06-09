package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SunhuaishangbaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SunhuaishangbaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SunhuaishangbaoView;


/**
 * 损坏上报
 *
 * @author 
 * @email 
 * @date 2021-01-29 17:28:30
 */
public interface SunhuaishangbaoService extends IService<SunhuaishangbaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SunhuaishangbaoVO> selectListVO(Wrapper<SunhuaishangbaoEntity> wrapper);
   	
   	SunhuaishangbaoVO selectVO(@Param("ew") Wrapper<SunhuaishangbaoEntity> wrapper);
   	
   	List<SunhuaishangbaoView> selectListView(Wrapper<SunhuaishangbaoEntity> wrapper);
   	
   	SunhuaishangbaoView selectView(@Param("ew") Wrapper<SunhuaishangbaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SunhuaishangbaoEntity> wrapper);
   	
}


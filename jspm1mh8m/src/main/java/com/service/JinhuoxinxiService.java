package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JinhuoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JinhuoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JinhuoxinxiView;


/**
 * 进货信息
 *
 * @author 
 * @email 
 * @date 2021-01-29 17:28:30
 */
public interface JinhuoxinxiService extends IService<JinhuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JinhuoxinxiVO> selectListVO(Wrapper<JinhuoxinxiEntity> wrapper);
   	
   	JinhuoxinxiVO selectVO(@Param("ew") Wrapper<JinhuoxinxiEntity> wrapper);
   	
   	List<JinhuoxinxiView> selectListView(Wrapper<JinhuoxinxiEntity> wrapper);
   	
   	JinhuoxinxiView selectView(@Param("ew") Wrapper<JinhuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JinhuoxinxiEntity> wrapper);
   	
}


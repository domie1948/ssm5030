package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChuhuoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChuhuoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuhuoxinxiView;


/**
 * 出货信息
 *
 * @author 
 * @email 
 * @date 2021-01-29 17:28:30
 */
public interface ChuhuoxinxiService extends IService<ChuhuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuhuoxinxiVO> selectListVO(Wrapper<ChuhuoxinxiEntity> wrapper);
   	
   	ChuhuoxinxiVO selectVO(@Param("ew") Wrapper<ChuhuoxinxiEntity> wrapper);
   	
   	List<ChuhuoxinxiView> selectListView(Wrapper<ChuhuoxinxiEntity> wrapper);
   	
   	ChuhuoxinxiView selectView(@Param("ew") Wrapper<ChuhuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuhuoxinxiEntity> wrapper);
   	
}


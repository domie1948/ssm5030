package com.dao;

import com.entity.ChuhuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChuhuoxinxiVO;
import com.entity.view.ChuhuoxinxiView;


/**
 * 出货信息
 * 
 * @author 
 * @email 
 * @date 2021-01-29 17:28:30
 */
public interface ChuhuoxinxiDao extends BaseMapper<ChuhuoxinxiEntity> {
	
	List<ChuhuoxinxiVO> selectListVO(@Param("ew") Wrapper<ChuhuoxinxiEntity> wrapper);
	
	ChuhuoxinxiVO selectVO(@Param("ew") Wrapper<ChuhuoxinxiEntity> wrapper);
	
	List<ChuhuoxinxiView> selectListView(@Param("ew") Wrapper<ChuhuoxinxiEntity> wrapper);

	List<ChuhuoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChuhuoxinxiEntity> wrapper);
	
	ChuhuoxinxiView selectView(@Param("ew") Wrapper<ChuhuoxinxiEntity> wrapper);
	
}

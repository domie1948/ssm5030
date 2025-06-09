package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.SunhuaishangbaoDao;
import com.entity.SunhuaishangbaoEntity;
import com.service.SunhuaishangbaoService;
import com.entity.vo.SunhuaishangbaoVO;
import com.entity.view.SunhuaishangbaoView;

@Service("sunhuaishangbaoService")
public class SunhuaishangbaoServiceImpl extends ServiceImpl<SunhuaishangbaoDao, SunhuaishangbaoEntity> implements SunhuaishangbaoService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SunhuaishangbaoEntity> page = this.selectPage(
                new Query<SunhuaishangbaoEntity>(params).getPage(),
                new EntityWrapper<SunhuaishangbaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SunhuaishangbaoEntity> wrapper) {
		  Page<SunhuaishangbaoView> page =new Query<SunhuaishangbaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<SunhuaishangbaoVO> selectListVO(Wrapper<SunhuaishangbaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SunhuaishangbaoVO selectVO(Wrapper<SunhuaishangbaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SunhuaishangbaoView> selectListView(Wrapper<SunhuaishangbaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SunhuaishangbaoView selectView(Wrapper<SunhuaishangbaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

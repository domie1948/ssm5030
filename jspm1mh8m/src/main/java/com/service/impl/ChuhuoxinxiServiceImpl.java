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


import com.dao.ChuhuoxinxiDao;
import com.entity.ChuhuoxinxiEntity;
import com.service.ChuhuoxinxiService;
import com.entity.vo.ChuhuoxinxiVO;
import com.entity.view.ChuhuoxinxiView;

@Service("chuhuoxinxiService")
public class ChuhuoxinxiServiceImpl extends ServiceImpl<ChuhuoxinxiDao, ChuhuoxinxiEntity> implements ChuhuoxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuhuoxinxiEntity> page = this.selectPage(
                new Query<ChuhuoxinxiEntity>(params).getPage(),
                new EntityWrapper<ChuhuoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuhuoxinxiEntity> wrapper) {
		  Page<ChuhuoxinxiView> page =new Query<ChuhuoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChuhuoxinxiVO> selectListVO(Wrapper<ChuhuoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChuhuoxinxiVO selectVO(Wrapper<ChuhuoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChuhuoxinxiView> selectListView(Wrapper<ChuhuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuhuoxinxiView selectView(Wrapper<ChuhuoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

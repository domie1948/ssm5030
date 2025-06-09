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


import com.dao.JinhuoxinxiDao;
import com.entity.JinhuoxinxiEntity;
import com.service.JinhuoxinxiService;
import com.entity.vo.JinhuoxinxiVO;
import com.entity.view.JinhuoxinxiView;

@Service("jinhuoxinxiService")
public class JinhuoxinxiServiceImpl extends ServiceImpl<JinhuoxinxiDao, JinhuoxinxiEntity> implements JinhuoxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JinhuoxinxiEntity> page = this.selectPage(
                new Query<JinhuoxinxiEntity>(params).getPage(),
                new EntityWrapper<JinhuoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JinhuoxinxiEntity> wrapper) {
		  Page<JinhuoxinxiView> page =new Query<JinhuoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JinhuoxinxiVO> selectListVO(Wrapper<JinhuoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JinhuoxinxiVO selectVO(Wrapper<JinhuoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JinhuoxinxiView> selectListView(Wrapper<JinhuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JinhuoxinxiView selectView(Wrapper<JinhuoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

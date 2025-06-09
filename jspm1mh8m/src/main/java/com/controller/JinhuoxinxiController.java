package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JinhuoxinxiEntity;
import com.entity.view.JinhuoxinxiView;

import com.service.JinhuoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 进货信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-29 17:28:30
 */
@RestController
@RequestMapping("/jinhuoxinxi")
public class JinhuoxinxiController {
    @Autowired
    private JinhuoxinxiService jinhuoxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JinhuoxinxiEntity jinhuoxinxi, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			jinhuoxinxi.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JinhuoxinxiEntity> ew = new EntityWrapper<JinhuoxinxiEntity>();
    	PageUtils page = jinhuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinhuoxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JinhuoxinxiEntity jinhuoxinxi, HttpServletRequest request){
        EntityWrapper<JinhuoxinxiEntity> ew = new EntityWrapper<JinhuoxinxiEntity>();
    	PageUtils page = jinhuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinhuoxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JinhuoxinxiEntity jinhuoxinxi){
       	EntityWrapper<JinhuoxinxiEntity> ew = new EntityWrapper<JinhuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jinhuoxinxi, "jinhuoxinxi")); 
        return R.ok().put("data", jinhuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JinhuoxinxiEntity jinhuoxinxi){
        EntityWrapper< JinhuoxinxiEntity> ew = new EntityWrapper< JinhuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jinhuoxinxi, "jinhuoxinxi")); 
		JinhuoxinxiView jinhuoxinxiView =  jinhuoxinxiService.selectView(ew);
		return R.ok("查询进货信息成功").put("data", jinhuoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JinhuoxinxiEntity jinhuoxinxi = jinhuoxinxiService.selectById(id);
        return R.ok().put("data", jinhuoxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JinhuoxinxiEntity jinhuoxinxi = jinhuoxinxiService.selectById(id);
        return R.ok().put("data", jinhuoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JinhuoxinxiEntity jinhuoxinxi, HttpServletRequest request){
    	jinhuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jinhuoxinxi);

        jinhuoxinxiService.insert(jinhuoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JinhuoxinxiEntity jinhuoxinxi, HttpServletRequest request){
    	jinhuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jinhuoxinxi);

        jinhuoxinxiService.insert(jinhuoxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JinhuoxinxiEntity jinhuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jinhuoxinxi);
        jinhuoxinxiService.updateById(jinhuoxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jinhuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JinhuoxinxiEntity> wrapper = new EntityWrapper<JinhuoxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			wrapper.eq("yuangonggonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = jinhuoxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}

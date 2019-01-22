package com.bootdo.wechat.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.wechat.domain.SpaceDO;
import com.bootdo.wechat.service.SpaceService;

/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-07-09 05:57:41
 */
 
@Controller
@RequestMapping("/wechat/space")
public class SpaceController {
	@Autowired
	private SpaceService spaceService;
	
	@GetMapping()
	@RequiresPermissions("wechat:space:space")
	String Space(){
	    return "wechat/space/space";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wechat:space:space")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SpaceDO> spaceList = spaceService.list(query);
		int total = spaceService.count(query);
		PageUtils pageUtils = new PageUtils(spaceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wechat:space:add")
	String add(){
	    return "wechat/space/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("wechat:space:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SpaceDO space = spaceService.get(id);
		model.addAttribute("space", space);
	    return "wechat/space/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wechat:space:add")
	public R save( SpaceDO space){
		if(spaceService.save(space)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wechat:space:edit")
	public R update( SpaceDO space){
		spaceService.update(space);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wechat:space:remove")
	public R remove( Integer id){
		if(spaceService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("wechat:space:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		spaceService.batchRemove(ids);
		return R.ok();
	}
	
}

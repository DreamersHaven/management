package com.bootdo.wechat.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.wechat.domain.DesignUserDO;
import com.bootdo.wechat.service.DesignUserService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-12-26 18:35:54
 */
 
@Controller
@RequestMapping("/wechat/designUser")
public class DesignUserController {
	@Autowired
	private DesignUserService designUserService;
	
	@GetMapping()
	@RequiresPermissions("wechat:designUser:designUser")
	String DesignUser(){
	    return "wechat/designUser/designUser";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wechat:designUser:designUser")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DesignUserDO> designUserList = designUserService.list(query);
		int total = designUserService.count(query);
		PageUtils pageUtils = new PageUtils(designUserList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wechat:designUser:add")
	String add(){
	    return "wechat/designUser/add";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("wechat:designUser:edit")
	String edit(@PathVariable("userId") Long userId,Model model){
		DesignUserDO designUser = designUserService.get(userId);
		model.addAttribute("designUser", designUser);
	    return "wechat/designUser/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wechat:designUser:add")
	public R save( DesignUserDO designUser){
		if(designUserService.save(designUser)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wechat:designUser:edit")
	public R update( DesignUserDO designUser){
		designUserService.update(designUser);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wechat:designUser:remove")
	public R remove( Long userId){
		if(designUserService.remove(userId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("wechat:designUser:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] userIds){
		designUserService.batchRemove(userIds);
		return R.ok();
	}
	
}

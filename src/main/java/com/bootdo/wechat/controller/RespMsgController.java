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

import com.bootdo.wechat.domain.RespMsgDO;
import com.bootdo.wechat.service.RespMsgService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-08-05 10:32:36
 */
 
@Controller
@RequestMapping("/wechat/respMsg")
public class RespMsgController {
	@Autowired
	private RespMsgService respMsgService;
	
	@GetMapping()
	@RequiresPermissions("wechat:respMsg:respMsg")
	String RespMsg(){
	    return "wechat/respMsg/respMsg";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wechat:respMsg:respMsg")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<RespMsgDO> respMsgList = respMsgService.list(query);
		int total = respMsgService.count(query);
		PageUtils pageUtils = new PageUtils(respMsgList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wechat:respMsg:add")
	String add(){
	    return "wechat/respMsg/add";
	}

	@GetMapping("/edit/{msgId}")
	@RequiresPermissions("wechat:respMsg:edit")
	String edit(@PathVariable("msgId") Integer msgId,Model model){
		RespMsgDO respMsg = respMsgService.get(msgId);
		model.addAttribute("respMsg", respMsg);
	    return "wechat/respMsg/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wechat:respMsg:add")
	public R save( RespMsgDO respMsg){
		if(respMsgService.save(respMsg)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wechat:respMsg:edit")
	public R update( RespMsgDO respMsg){
		respMsgService.update(respMsg);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wechat:respMsg:remove")
	public R remove( Integer msgId){
		if(respMsgService.remove(msgId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("wechat:respMsg:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] msgIds){
		respMsgService.batchRemove(msgIds);
		return R.ok();
	}
	
}

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

import com.bootdo.wechat.domain.StudentsDO;
import com.bootdo.wechat.service.StudentsService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-10-20 16:25:48
 */
 
@Controller
@RequestMapping("/wechat/students")
public class StudentsController {
	@Autowired
	private StudentsService studentsService;
	
	@GetMapping()
	@RequiresPermissions("wechat:students:students")
	String Students(){
	    return "wechat/students/students";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wechat:students:students")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<StudentsDO> studentsList = studentsService.list(query);
		int total = studentsService.count(query);
		PageUtils pageUtils = new PageUtils(studentsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wechat:students:add")
	String add(){
	    return "wechat/students/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("wechat:students:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		StudentsDO students = studentsService.get(id);
		model.addAttribute("students", students);
	    return "wechat/students/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wechat:students:add")
	public R save( StudentsDO students){
		if(studentsService.save(students)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wechat:students:edit")
	public R update( StudentsDO students){
		studentsService.update(students);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wechat:students:remove")
	public R remove( Integer id){
		if(studentsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("wechat:students:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		studentsService.batchRemove(ids);
		return R.ok();
	}
	
}

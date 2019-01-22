package com.bootdo.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.wechat.dao.StudentsDao;
import com.bootdo.wechat.domain.StudentsDO;
import com.bootdo.wechat.service.StudentsService;



@Service
public class StudentsServiceImpl implements StudentsService {
	@Autowired
	private StudentsDao studentsDao;
	
	@Override
	public StudentsDO get(Integer id){
		return studentsDao.get(id);
	}
	
	@Override
	public List<StudentsDO> list(Map<String, Object> map){
		return studentsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return studentsDao.count(map);
	}
	
	@Override
	public int save(StudentsDO students){
		return studentsDao.save(students);
	}
	
	@Override
	public int update(StudentsDO students){
		return studentsDao.update(students);
	}
	
	@Override
	public int remove(Integer id){
		return studentsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return studentsDao.batchRemove(ids);
	}
	
}

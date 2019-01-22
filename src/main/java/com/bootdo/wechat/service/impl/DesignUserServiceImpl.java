package com.bootdo.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.wechat.dao.DesignUserDao;
import com.bootdo.wechat.domain.DesignUserDO;
import com.bootdo.wechat.service.DesignUserService;



@Service
public class DesignUserServiceImpl implements DesignUserService {
	@Autowired
	private DesignUserDao designUserDao;
	
	@Override
	public DesignUserDO get(Long userId){
		return designUserDao.get(userId);
	}
	
	@Override
	public List<DesignUserDO> list(Map<String, Object> map){
		return designUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return designUserDao.count(map);
	}
	
	@Override
	public int save(DesignUserDO designUser){
		return designUserDao.save(designUser);
	}
	
	@Override
	public int update(DesignUserDO designUser){
		return designUserDao.update(designUser);
	}
	
	@Override
	public int remove(Long userId){
		return designUserDao.remove(userId);
	}
	
	@Override
	public int batchRemove(Long[] userIds){
		return designUserDao.batchRemove(userIds);
	}
	
}

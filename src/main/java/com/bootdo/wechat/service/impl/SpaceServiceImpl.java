package com.bootdo.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.wechat.dao.SpaceDao;
import com.bootdo.wechat.domain.SpaceDO;
import com.bootdo.wechat.service.SpaceService;



@Service
public class SpaceServiceImpl implements SpaceService {
	@Autowired
	private SpaceDao spaceDao;
	
	@Override
	public SpaceDO get(Integer id){
		return spaceDao.get(id);
	}
	
	@Override
	public List<SpaceDO> list(Map<String, Object> map){
		return spaceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return spaceDao.count(map);
	}
	
	@Override
	public int save(SpaceDO space){
		return spaceDao.save(space);
	}
	
	@Override
	public int update(SpaceDO space){
		return spaceDao.update(space);
	}
	
	@Override
	public int remove(Integer id){
		return spaceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return spaceDao.batchRemove(ids);
	}
	
}

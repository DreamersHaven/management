package com.bootdo.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.wechat.dao.RespMsgDao;
import com.bootdo.wechat.domain.RespMsgDO;
import com.bootdo.wechat.service.RespMsgService;



@Service
public class RespMsgServiceImpl implements RespMsgService {
	@Autowired
	private RespMsgDao respMsgDao;
	
	@Override
	public RespMsgDO get(Integer msgId){
		return respMsgDao.get(msgId);
	}
	
	@Override
	public List<RespMsgDO> list(Map<String, Object> map){
		return respMsgDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return respMsgDao.count(map);
	}
	
	@Override
	public int save(RespMsgDO respMsg){
		return respMsgDao.save(respMsg);
	}
	
	@Override
	public int update(RespMsgDO respMsg){
		return respMsgDao.update(respMsg);
	}
	
	@Override
	public int remove(Integer msgId){
		return respMsgDao.remove(msgId);
	}
	
	@Override
	public int batchRemove(Integer[] msgIds){
		return respMsgDao.batchRemove(msgIds);
	}
	
}

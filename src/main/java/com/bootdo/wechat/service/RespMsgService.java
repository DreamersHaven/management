package com.bootdo.wechat.service;

import com.bootdo.wechat.domain.RespMsgDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-08-05 10:32:36
 */
public interface RespMsgService {
	
	RespMsgDO get(Integer msgId);
	
	List<RespMsgDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RespMsgDO respMsg);
	
	int update(RespMsgDO respMsg);
	
	int remove(Integer msgId);
	
	int batchRemove(Integer[] msgIds);
}

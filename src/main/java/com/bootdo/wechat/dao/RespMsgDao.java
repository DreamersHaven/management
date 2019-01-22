package com.bootdo.wechat.dao;

import com.bootdo.wechat.domain.RespMsgDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-08-05 10:32:36
 */
@Mapper
public interface RespMsgDao {

	RespMsgDO get(Integer msgId);
	
	List<RespMsgDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(RespMsgDO respMsg);
	
	int update(RespMsgDO respMsg);
	
	int remove(Integer msg_id);
	
	int batchRemove(Integer[] msgIds);
}

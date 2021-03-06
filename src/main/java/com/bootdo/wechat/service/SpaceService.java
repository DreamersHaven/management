package com.bootdo.wechat.service;

import com.bootdo.wechat.domain.SpaceDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-07-09 05:57:41
 */
public interface SpaceService {
	
	SpaceDO get(Integer id);
	
	List<SpaceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SpaceDO space);
	
	int update(SpaceDO space);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

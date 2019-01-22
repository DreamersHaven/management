package com.bootdo.wechat.service;

import com.bootdo.wechat.domain.DesignUserDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-12-26 18:35:54
 */
public interface DesignUserService {
	
	DesignUserDO get(Long userId);
	
	List<DesignUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DesignUserDO designUser);
	
	int update(DesignUserDO designUser);
	
	int remove(Long userId);
	
	int batchRemove(Long[] userIds);
}

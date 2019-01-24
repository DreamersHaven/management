package com.bootdo.wechat.dao;

import com.bootdo.wechat.domain.SpaceDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 空间管理DAO
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-07-09 05:57:41
 */
@Mapper
public interface SpaceDao {

	SpaceDO get(Integer id);
	
	List<SpaceDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SpaceDO space);
	
	int update(SpaceDO space);
	
	int remove(Integer ID);
	
	int batchRemove(Integer[] ids);
}

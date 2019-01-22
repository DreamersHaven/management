package com.bootdo.wechat.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.wechat.domain.WechatMenuDO;

/**
 * 菜单管理
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 09:45:09
 */
@Mapper
public interface WechatMenuDao {

	WechatMenuDO get(Long menuId);
	
	List<WechatMenuDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(WechatMenuDO menu);
	
	int update(WechatMenuDO menu);
	
	int remove(Long menuId);
	
	int batchRemove(Long[] menuIds);
	
	List<WechatMenuDO> listMenuByUserId(Long id);
	
	List<String> listUserPerms(Long id);
}

package com.bootdo.wechat.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.bootdo.common.domain.Tree;
import com.bootdo.wechat.domain.WechatMenuDO;

@Service
public interface WechatMenuService {
	Tree<WechatMenuDO> getSysMenuTree(Long id);

	List<Tree<WechatMenuDO>> listMenuTree(Long id);

	Tree<WechatMenuDO> getTree();

	Tree<WechatMenuDO> getTree(Long id);

	List<WechatMenuDO> list(Map<String, Object> params);

	int remove(Long id);

	int save(WechatMenuDO menu);

	int update(WechatMenuDO menu);

	WechatMenuDO get(Long id);

	Set<String> listPerms(Long userId);
}

package com.bootdo.wechat.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootdo.common.domain.Tree;
import com.bootdo.common.utils.BuildTree;
import com.bootdo.system.dao.RoleMenuDao;
import com.bootdo.wechat.dao.WechatMenuDao;
import com.bootdo.wechat.domain.WechatMenuDO;
import com.bootdo.wechat.service.WechatMenuService;

@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class WechatMenuServiceImpl implements WechatMenuService {
	@Autowired
	WechatMenuDao menuMapper;
	@Autowired
	RoleMenuDao roleMenuMapper;

	/**
	 * @param
	 * @return 树形菜单
	 */
	@Cacheable
	@Override
	public Tree<WechatMenuDO> getSysMenuTree(Long id) {
		List<Tree<WechatMenuDO>> trees = new ArrayList<Tree<WechatMenuDO>>();
		List<WechatMenuDO> menuDOs = menuMapper.listMenuByUserId(id);
		for (WechatMenuDO sysMenuDO : menuDOs) {
			Tree<WechatMenuDO> tree = new Tree<WechatMenuDO>();
			tree.setId(sysMenuDO.getMenuId().toString());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			Map<String, Object> attributes = new HashMap<>(16);
			attributes.put("url", sysMenuDO.getUrl());
			attributes.put("icon", sysMenuDO.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<WechatMenuDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public List<WechatMenuDO> list(Map<String, Object> params) {
		List<WechatMenuDO> menus = menuMapper.list(params);
		return menus;
	}

	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int remove(Long id) {
		int result = menuMapper.remove(id);
		return result;
	}
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int save(WechatMenuDO menu) {
		int r = menuMapper.save(menu);
		return r;
	}

	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int update(WechatMenuDO menu) {
		int r = menuMapper.update(menu);
		return r;
	}

	@Override
	public WechatMenuDO get(Long id) {
		WechatMenuDO menuDO = menuMapper.get(id);
		return menuDO;
	}

	@Override
	public Tree<WechatMenuDO> getTree() {
		List<Tree<WechatMenuDO>> trees = new ArrayList<Tree<WechatMenuDO>>();
		List<WechatMenuDO> menuDOs = menuMapper.list(new HashMap<>(16));
		for (WechatMenuDO sysMenuDO : menuDOs) {
			Tree<WechatMenuDO> tree = new Tree<WechatMenuDO>();
			tree.setId(sysMenuDO.getMenuId().toString());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<WechatMenuDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<WechatMenuDO> getTree(Long id) {
		// 根据roleId查询权限
		List<WechatMenuDO> menus = menuMapper.list(new HashMap<String, Object>(16));
		List<Long> menuIds = roleMenuMapper.listMenuIdByRoleId(id);
		List<Long> temp = menuIds;
		for (WechatMenuDO menu : menus) {
			if (temp.contains(menu.getParentId())) {
				menuIds.remove(menu.getParentId());
			}
		}
		List<Tree<WechatMenuDO>> trees = new ArrayList<Tree<WechatMenuDO>>();
		List<WechatMenuDO> menuDOs = menuMapper.list(new HashMap<String, Object>(16));
		for (WechatMenuDO sysMenuDO : menuDOs) {
			Tree<WechatMenuDO> tree = new Tree<WechatMenuDO>();
			tree.setId(sysMenuDO.getMenuId().toString());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			Map<String, Object> state = new HashMap<>(16);
			Long menuId = sysMenuDO.getMenuId();
			if (menuIds.contains(menuId)) {
				state.put("selected", true);
			} else {
				state.put("selected", false);
			}
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<WechatMenuDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Set<String> listPerms(Long userId) {
		List<String> perms = menuMapper.listUserPerms(userId);
		Set<String> permsSet = new HashSet<>();
		for (String perm : perms) {
			if (StringUtils.isNotBlank(perm)) {
				permsSet.addAll(Arrays.asList(perm.trim().split(",")));
			}
		}
		return permsSet;
	}

	@Override
	public List<Tree<WechatMenuDO>> listMenuTree(Long id) {
		List<Tree<WechatMenuDO>> trees = new ArrayList<Tree<WechatMenuDO>>();
		List<WechatMenuDO> menuDOs = menuMapper.listMenuByUserId(id);
		for (WechatMenuDO sysMenuDO : menuDOs) {
			Tree<WechatMenuDO> tree = new Tree<WechatMenuDO>();
			tree.setId(sysMenuDO.getMenuId().toString());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			Map<String, Object> attributes = new HashMap<>(16);
			attributes.put("url", sysMenuDO.getUrl());
			attributes.put("icon", sysMenuDO.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		List<Tree<WechatMenuDO>> list = BuildTree.buildList(trees, "0");
		return list;
	}

}

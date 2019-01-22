package com.bootdo.wechat.domain;

import java.io.Serializable;



/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-07-09 05:57:41
 */
public class SpaceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键，自动递增
	private Integer id;
	//空间名称
	private String name;
	//空间地址
	private String address;
	//
	private String mapurl;
	//
	private String phone;
	//
	private String remarks;

	/**
	 * 设置：主键，自动递增
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键，自动递增
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：空间名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：空间名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：空间地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：空间地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：
	 */
	public void setMapurl(String mapurl) {
		this.mapurl = mapurl;
	}
	/**
	 * 获取：
	 */
	public String getMapurl() {
//		StringBuffer suf=new StringBuffer();
//		suf.append("<a href=\"");
//		suf.append(mapurl);
//		suf.append("\">");
//		suf.append("查看图片");
//		suf.append("</a>");
//		return suf.toString();
		return mapurl;
	}
	/**
	 * 设置：
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：
	 */
	public String getRemarks() {
		return remarks;
	}
}

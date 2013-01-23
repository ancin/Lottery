package com.alipay.prize.services;

import java.util.List;

import com.alipay.prize.model.Alipayer;

@SuppressWarnings("rawtypes")
public interface AlipayerService {
	List getAll();// 获得所有记录

	List getAlipayers(int pageSize, int startRow);// 获得所有记录

	int getRows();// 获得总行数

	int getRows(String fieldname, String value);// 获得总行数

	List queryAlipayers(String fieldname, String value);// 根据条件查询

	List getAlipayers(String fieldname, String value, int pageSize, int startRow);// 根据条件查询

	Alipayer getAlipayer(String id);// 根据ID获得记录

	void addAlipayer(Alipayer alipayer);// 添加记录

	void updateAlipayer(Alipayer alipayer);// 修改记录

	void deleteAlipayer(Alipayer alipayer);// 删除记录

}

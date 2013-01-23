package com.alipay.prize.dao;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface BaseDao {
		List getAll();// 获得所有人员

		List getObjs(int pageSize, int startRow);// 获得所有记录

		int getRows();// 获得总行数

		int getRows(String fieldname, String value);// 获得总行数

		List queryObjs(String fieldname, String value);// 根据条件查询

		List getObjs(String fieldname, String value, int pageSize, int startRow);// 根据条件查询

		Object getObj(String classType, String id);// 根据ID获得记录

		void addObj(Object obj);// 添加记录

		void updateObj(Object obj);// 修改记录

		void deleteObj(Object obj);// 删除记录
}

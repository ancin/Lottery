package com.alipay.prize.services;

import java.util.List;

import com.alipay.prize.model.Prize;

@SuppressWarnings("rawtypes")
public interface PrizeService {

	List getAll();// 获得所有记录

	List getPrizes(int pageSize, int startRow);// 获得所有记录

	int getRows();// 获得总行数

	int getRows(String fieldname, String value);// 获得总行数

	List queryPrizes(String fieldname, String value);// 根据条件查询

	List getPrizes(String fieldname, String value, int pageSize, int startRow);// 根据条件查询

	Prize getPrize(String prizeId);// 根据ID获得记录

	void addPrize(Prize prize);// 添加记录

	void updatePrize(Prize prize);// 修改记录

	void deletePrize(Prize prize);// 删除记录
	void deletePrize(String id);// 删除记录
	void logicDelete(Prize prize);
}

package com.alipay.prize.services;

import java.util.List;
import com.alipay.prize.model.LotteryResult;

;
@SuppressWarnings("rawtypes")
public interface LotteryResultService {

	List getAll();// 获得所有记录

	List getResults(int pageSize, int startRow);// 获得所有记录

	int getRows();// 获得总行数

	int getRows(String fieldname, String value);// 获得总行数

	List queryResults(String fieldname, String value);// 根据条件查询

	List getResults(String fieldname, String value, int pageSize, int startRow);// 根据条件查询

	LotteryResult getResult(String id);// 根据ID获得记录

	void addResult(LotteryResult result);// 添加记录

	void updateResult(LotteryResult result);// 修改记录

	void deleteResult(LotteryResult result);// 删除记录

	List queryResultsByPrizeLevel(String level, int pageSize, int startRow)
			throws Exception;// 根据条件查询
}

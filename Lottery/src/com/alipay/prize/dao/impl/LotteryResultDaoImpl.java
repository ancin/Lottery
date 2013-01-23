package com.alipay.prize.dao.impl;

import org.apache.log4j.Logger;

import com.alipay.commons.TableName;

public class LotteryResultDaoImpl extends BaseDaoImpl{
	@Override
	public void setTableName() {
		this.tableName = TableName.LotteryResult;
	}

	@Override
	public void setLogger() {
		logger = Logger.getLogger(LotteryResultDaoImpl.class);
	}
}
package com.alipay.prize.services.impl;

import java.util.List;


import com.alipay.prize.dao.BaseDao;
import com.alipay.prize.dao.PrizeDao;
import com.alipay.prize.dao.impl.LotteryResultDaoImpl;
import com.alipay.prize.dao.impl.PrizeDaoImpl;
import com.alipay.prize.model.LotteryResult;
import com.alipay.prize.model.Prize;
import com.alipay.prize.services.LotteryResultService;

@SuppressWarnings("rawtypes")
public class LotteryResultServiceImpl implements LotteryResultService {

	private LotteryResultDaoImpl resultDao;
	private PrizeDao prizeDao;

	public BaseDao getResultDao() {
		return resultDao;
	}

	public void setResultDao(BaseDao resultDao) {
		this.resultDao = (LotteryResultDaoImpl) resultDao;
	}

	public List getAll() {
		return resultDao.getAll();
	}

	public List getResults(int pageSize, int startRow) {
		// TODO Auto-generated method stub
		return resultDao.getObjs(pageSize, startRow);
	}

	public int getRows() {
		// TODO Auto-generated method stub
		return resultDao.getRows();
	}

	public int getRows(String fieldname, String value) {
		// TODO Auto-generated method stub
		return resultDao.getRows(fieldname, value);
	}

	public List queryResults(String fieldname, String value) {
		// TODO Auto-generated method stub
		return resultDao.queryObjs(fieldname, value);
	}

	public List getResults(String fieldname, String value, int pageSize,
			int startRow) {
		// TODO Auto-generated method stub
		return resultDao.getObjs(fieldname, value, pageSize, startRow);
	}

	public LotteryResult getResult(String id) {
		// TODO Auto-generated method stub
		return (LotteryResult) resultDao.getObj(LotteryResult.class.getName(),
				id);
	}

	public void addResult(LotteryResult result) {
		// TODO Auto-generated method stub
		resultDao.addObj(result);
	}

	public void updateResult(LotteryResult result) {
		// TODO Auto-generated method stub
		resultDao.updateObj(result);
	}

	public void deleteResult(LotteryResult result) {
		// TODO Auto-generated method stub
		resultDao.deleteObj(result);
	}

	@SuppressWarnings("unchecked")
	public List queryResultsByPrizeLevel(String level, int pageSize,
			int startRow) throws Exception {
		// TODO Auto-generated method stub
		List level_result = getPrizeDao().getPrizes("prizeLevel", level, pageSize, startRow);
		if (level_result != null && level_result.size() != 0) {
			List total = null;
			for (Object var : level_result) {
				if (total == null) {
					total = resultDao.getObjs("prizeId", ((Prize) var).getId(),
							pageSize, startRow);
				} else {
					total.addAll(resultDao.getObjs("prizeId",
							((Prize) var).getId(), pageSize, startRow));
				}
			}
			return total;
		} else {
			return null;
		}
	}

	public PrizeDao getPrizeDao() {
		return prizeDao;
	}

	public void setPrizeDao(PrizeDao prizeDao) {
		this.prizeDao = prizeDao;
	}
}

package com.alipay.prize.services.impl;

import java.util.List;

import com.alipay.prize.dao.PrizeDao;
import com.alipay.prize.model.Prize;
import com.alipay.prize.services.PrizeService;

@SuppressWarnings("rawtypes")
public class PrizeServiceImpl implements PrizeService {

	private PrizeDao prizeDao;

	public PrizeDao getPrizeDao() {
		return prizeDao;
	}

	public void setPrizeDao(PrizeDao prizeDao) {
		this.prizeDao = prizeDao;
	}

	public List getAll() {

		return prizeDao.getAll();
	}

	public List getPrizes(int pageSize, int startRow) {
		return prizeDao.getPrizes(pageSize, startRow);
	}

	public int getRows() {
		return prizeDao.getRows();
	}

	public int getRows(String fieldname, String value) {

		return prizeDao.getRows();
	}

	public List queryPrizes(String fieldname, String value) {
		return prizeDao.queryPrizes(fieldname, value);
	}

	public List getPrizes(String fieldname, String value, int pageSize,
			int startRow) {
		return prizeDao.getPrizes(fieldname, value, pageSize, startRow);
	}

	public Prize getPrize(String prizeId) {
		return prizeDao.getPrize(prizeId);
	}

	public void addPrize(Prize prize) {
		prizeDao.addPrize(prize);
	}

	public void updatePrize(Prize prize) {
		prizeDao.updatePrize(prize);
	}

	public void deletePrize(Prize prize) {
		prizeDao.deletePrize(prize);
	}

	public void deletePrize(String id) {
		Prize prize = prizeDao.getPrize(id);
		prizeDao.deletePrize(prize);
	}

	public void logicDelete(Prize prize) {
		prizeDao.logicDelete(prize);
	}

	public List getPrizeLevel() {
		return prizeDao.getPrizeLevel();
	}
	
}

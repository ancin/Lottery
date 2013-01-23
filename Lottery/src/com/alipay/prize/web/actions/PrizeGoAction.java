package com.alipay.prize.web.actions;

import java.util.Date;

import org.apache.log4j.Logger;

import com.alipay.commons.AbstractAction;
import com.alipay.commons.PrizeNumberLessException;
import com.alipay.prize.model.Alipayer;
import com.alipay.prize.model.LotteryResult;
import com.alipay.prize.model.Prize;
import com.alipay.prize.services.AlipayerService;
import com.alipay.prize.services.LotteryResultService;
import com.alipay.prize.services.PrizeService;

public class PrizeGoAction extends AbstractAction {

	private static final Logger logger = Logger.getLogger(PrizeGoAction.class);

	protected PrizeService prizeService;
	protected LotteryResultService resultService;
	protected AlipayerService alipayerService;
	protected String id;
	protected String uids;

	public AlipayerService getAlipayerService() {
		return alipayerService;
	}

	public void setAlipayerService(AlipayerService alipayerService) {
		this.alipayerService = alipayerService;
	}

	public LotteryResultService getResultService() {
		return resultService;
	}

	public void setResultService(LotteryResultService resultService) {
		this.resultService = resultService;
	}

	public String getUids() {
		return uids;
	}

	public void setUids(String uids) {
		this.uids = uids;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PrizeService getPrizeService() {
		return prizeService;
	}

	public void setPrizeService(PrizeService prizeService) {
		this.prizeService = prizeService;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String ohMyPrize() {
		logger.info(">>>>>>>>ohMyPrize prize go...");
		logger.info(">>>>>>>>ohMyPrize imnage id=" + id);

		return SUCCESS;
	}

	public String updateResutl() throws Exception{
		logger.info(">>>>>>updateResutl uids== " + uids);
		logger.info(">>>>>>updateResutl image id== " + id);
		String[] alipayIds = null;
		if (uids != null) {
			alipayIds = uids.split(",");
		}
		Prize prize = prizeService.getPrize(id);
		try {

			if (id != null) {
				
				if (prize.getLeftNum() < alipayIds.length) {
					throw new Exception("奖品很少啊，要的人很多，集体不要");
					
				}
				int lf = prize.getLeftNum();
				for (int i = 0; i < alipayIds.length; i++) {
					lf--;
					LotteryResult result = new LotteryResult();
					Alipayer guy = alipayerService.getAlipayer(alipayIds[i]);
					guy.setFlag("F");
					alipayerService.updateAlipayer(guy);
					result.setAlipayerId(alipayIds[i]);
					result.setAlipayerName(guy.getName());
					result.setPrizeId(id);
					result.setPrizeName(prize.getPrizeName());
					result.setGmtCreate(new Date());
					result.setGmtModified(new Date());

					resultService.addResult(result);

				}
				prize.setLeftNum(lf);
				prizeService.updatePrize(prize);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("奖品很少啊，要的人很多，集体不要");
		}
		return SUCCESS;
	}
}

package com.alipay.prize.web.actions;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alipay.commons.AbstractAction;
import com.alipay.commons.Pager;
import com.alipay.commons.PagerService;
import com.alipay.prize.model.LotteryResult;
import com.alipay.prize.model.Prize;
import com.alipay.prize.services.impl.LotteryResultServiceImpl;
import com.alipay.prize.services.impl.PrizeServiceImpl;

public class LotteryResultAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LotteryResultAction.class);
	private PagerService pagerService;

	private Pager pager;

	@SuppressWarnings("rawtypes")
	protected List availableItems;
	protected List prizeLevel;
	protected String ID;
	
	
	protected String currentPage;
	protected String pagerMethod;
	protected String totalRows;

	protected String queryValue;
	protected String queryMap;
	protected LotteryResultServiceImpl lotteryResultService;

	protected PrizeServiceImpl prizeService;
	private LotteryResult lotteryResult;

	/****** setter and get *****/

	public String list() throws Exception {
		prizeLevel = prizeService.getPrizeLevel();
		prizeLevel.add(0, "all");
		int totalRow = 0;
		if (queryValue == null || queryValue.equals("")||queryValue.equals("all")) {
			availableItems = lotteryResultService.getAll();
			totalRow = availableItems.size();
			pager = pagerService.getPager(this.getCurrentPage(),
					this.getPagerMethod(), totalRow);
			
		} else {
			this.setQueryValue(queryValue);
			availableItems = lotteryResultService.queryResultsByPrizeLevel(this.getQueryValue(), -1,-1);
			totalRow = availableItems.size();
			pager = pagerService.getPager(this.getCurrentPage(),
					this.getPagerMethod(), totalRow);	
       
		}	
		
		this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
		this.setTotalRows(String.valueOf(totalRow));		
		this.setQueryValue(this.getQueryValue());

		return SUCCESS;
	}

    public String save() throws Exception {
		logger.info(">>>>>>>>> LotteryResultAction save().");
		return SUCCESS;
	}

	public String delete() throws Exception {
		LotteryResult re = lotteryResultService.getResult(ID);
		if (re != null ){
		      lotteryResultService.deleteResult(re);
		}
		logger.info(">>>>>>>>> LotteryResultAction delete().");
		return SUCCESS;
	}

	public List getAvailableItems() {
		return availableItems;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getPagerMethod() {
		return pagerMethod;
	}

	public void setPagerMethod(String pagerMethod) {
		this.pagerMethod = pagerMethod;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public String getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(String totalRows) {
		this.totalRows = totalRows;
	}

	public String getQueryValue() {
		return queryValue;
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}

	public String getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(String queryMap) {
		this.queryMap = queryMap;
	}

	public PagerService getPagerService() {
		return pagerService;
	}

	public void setPagerService(PagerService pagerService) {
		this.pagerService = pagerService;
	}

	public LotteryResultServiceImpl getLotteryResultService() {
		return lotteryResultService;
	}

	public void setLotteryResultService(
			LotteryResultServiceImpl lotteryResultService) {
		this.lotteryResultService = lotteryResultService;
	}
	
	public LotteryResult getPrize() {
		return lotteryResult;
	}

	public void setPrize(LotteryResult lotteryResult) {
		this.lotteryResult = lotteryResult;
	}
	
	public PrizeServiceImpl getPrizeService() {
		return prizeService;
	}

	public void setPrizeService(PrizeServiceImpl prizeService) {
		this.prizeService = prizeService;
	}
	
	public List getPrizeLevel() {
		return prizeLevel;
	}

	public void setPrizeLevel(List prizeLevel) {
		this.prizeLevel = prizeLevel;
	}
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}


}

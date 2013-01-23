/**
 * 
 */
package com.alipay.prize.web.actions;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.json.annotations.JSON;

import com.alipay.commons.AbstractAction;
import com.alipay.commons.JsonUtil;
import com.alipay.commons.Pager;
import com.alipay.commons.PagerService;
import com.alipay.prize.model.Alipayer;
import com.alipay.prize.services.impl.AlipayerServiceImpl;

/**
 * @author 123
 * 
 */
public class AlipayerAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LotteryAction.class);

	@SuppressWarnings("rawtypes")
	protected Collection availableItems;
	protected String currentPage;
	protected String pagerMethod;
	protected String totalRows;
	protected String id = "";
	protected String uids;

	protected String queryName;
	protected String queryValue;
	protected String searchName;
	protected String searchValue;
	protected String queryMap;
	protected AlipayerServiceImpl alipayerService;
	private Alipayer alipayer;

	public String jsonResult;

	private PagerService pagerService;

	private Pager pager;

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

	public String getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(String totalRows) {
		this.totalRows = totalRows;
	}

	public String getUids() {
		return uids;
	}

	public void setUids(String uids) {
		this.uids = uids;
	}

	public PagerService getPagerService() {
		return pagerService;
	}

	public void setPagerService(PagerService pagerService) {
		this.pagerService = pagerService;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public void setAvailableItems(Collection availableItems) {
		this.availableItems = availableItems;
	}

	@JSON(name = "JSONRESULT")
	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public Alipayer getAlipayer() {
		return alipayer;
	}

	public void setAlipayer(Alipayer alipayer) {
		this.alipayer = alipayer;
	}

	/****** setter and get *****/

	public String saveEmployee() {

		logger.info(">>>>>>>>> AlipayAction saveEmployee().");

		Alipayer ali = alipayerService
				.getAlipayerByNumber(alipayer.getNumber());

		if (ali == null) {
			ali = new Alipayer();
			ali.setNumber(alipayer.getNumber());
			ali.setName(alipayer.getName());
			ali.setNickName(alipayer.getNickName());
			ali.setGmtModified(new Date());
			alipayerService.addAlipayer(ali);
		}

		else {
			ali.setName(alipayer.getName());
			ali.setNickName(alipayer.getNickName());
			ali.setGmtModified(new Date());

			alipayerService.updateAlipayer(ali);
		}

		return SUCCESS;

	}

	public String load() throws Exception {
		logger.info(">>>>>>>>> AlipayAction load().");
		if (!id.isEmpty()) {
			alipayer = (Alipayer) alipayerService.getAlipayer(id);

		} else {
			id = "";
		}
		return SUCCESS;
	}

	public String saveAlipayer() throws Exception {
		logger.info(">>>>>>>>> LotteryAction save().");

		
		String id = this.getAlipayer().getId();
		
		Alipayer ali = alipayerService.getAlipayer(id);

		if (ali == null) {
			ali = new Alipayer();
			ali.setNumber(alipayer.getNumber());
			ali.setName(alipayer.getName());
			ali.setNickName(alipayer.getNickName());
			ali.setGmtModified(new Date());
			ali.setGmtCreate(new Date());
			ali.setTele(alipayer.getTele());
			ali.setDesc(alipayer.getDesc());
			ali.setFlag("T");
			alipayerService.addAlipayer(ali);
		}

		else {
			ali.setName(alipayer.getName());
			ali.setNickName(alipayer.getNickName());
			ali.setGmtModified(new Date());
			ali.setDesc(alipayer.getDesc());
			ali.setTele(alipayer.getTele());

			alipayerService.updateAlipayer(ali);
		}

		return SUCCESS;
	}

	public String deleteAlipayer() throws Exception {
		logger.info(">>>>>>>>> LotteryAction delete().");

		alipayerService.deleteAlipayerById(id);

		return SUCCESS;
	}

	public String getAllJson() {
		List list = alipayerService.getAll();
		Collections.shuffle(list);
		jsonResult = JsonUtil.listToJson(list);
		System.out.println(">>>>>>>>>>>jso result:" + jsonResult);
		return SUCCESS;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public Collection getAvailableItems() {
		return availableItems;
	}

	public String getQueryValue() {
		return queryValue;
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}

	public String list() throws Exception {
		if (queryMap == null || queryMap.equals("")) {

		} else {
			String[] str = queryMap.split("~");
			this.setQueryName(str[0]);
			this.setQueryValue(str[1]);
		}

		int totalRow = alipayerService.getRows(this.getQueryName(),
				this.getQueryValue());
		pager = pagerService.getPager(this.getCurrentPage(),
				this.getPagerMethod(), totalRow);
		this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
		this.setTotalRows(String.valueOf(totalRow));
		availableItems = alipayerService.getAlipayers(this.getQueryName(),
				this.getQueryValue(), pager.getPageSize(), pager.getStartRow());

		this.setQueryName(this.getQueryName());
		this.setQueryValue(this.getQueryValue());

		this.setSearchName(this.getQueryName());
		this.setSearchValue(this.getQueryValue());
		return SUCCESS;
	}

	public String getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(String queryMap) {
		this.queryMap = queryMap;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JSON(serialize = false)
	public AlipayerServiceImpl getAlipayerService() {
		return alipayerService;
	}

	public void setAlipayerService(AlipayerServiceImpl alipayerService) {
		this.alipayerService = alipayerService;
	}

}

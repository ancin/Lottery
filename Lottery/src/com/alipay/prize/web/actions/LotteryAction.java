package com.alipay.prize.web.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;

import com.alipay.commons.AbstractAction;
import com.alipay.commons.Pager;
import com.alipay.commons.PagerService;
import com.alipay.prize.model.Prize;
import com.alipay.prize.services.PrizeService;

@SuppressWarnings("rawtypes")
public class LotteryAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LotteryAction.class);
	private PagerService pagerService;

	private Pager pager;
	private Prize prize;
	private File picture;
	protected File image;

	
	protected Collection availableItems;
	protected Collection prizeLevel0;
	protected Collection prizeLevel4;
	protected Collection prizeLevel5;
	
	protected String uids;
	
	

	public String getUids() {
		return uids;
	}

	public void setUids(String uids) {
		this.uids = uids;
	}

	public Collection getPrizeLevel4() {
		return prizeLevel4;
	}

	public void setPrizeLevel4(Collection prizeLevel4) {
		this.prizeLevel4 = prizeLevel4;
	}
	
	public Collection getPrizeLevel5() {
		return prizeLevel5;
	}

	public void setPrizeLevel5(Collection prizeLevel5) {
		this.prizeLevel4 = prizeLevel5;
	}

	public Collection getPrizeLevel0() {
		return prizeLevel0;
	}

	public void setPrizeLevel0(Collection prizeLevel0) {
		this.prizeLevel0 = prizeLevel0;
	}

	public Collection getPrizeLevel1() {
		return prizeLevel1;
	}

	public void setPrizeLevel1(Collection prizeLevel1) {
		this.prizeLevel1 = prizeLevel1;
	}

	public Collection getPrizeLevel2() {
		return prizeLevel2;
	}

	public void setPrizeLevel2(Collection prizeLevel2) {
		this.prizeLevel2 = prizeLevel2;
	}

	public Collection getPrizeLevel3() {
		return prizeLevel3;
	}

	public void setPrizeLevel3(Collection prizeLevel3) {
		this.prizeLevel3 = prizeLevel3;
	}
	protected Collection prizeLevel1;
	protected Collection prizeLevel2;
	protected Collection prizeLevel3;
	protected String currentPage;
	protected String pagerMethod;
	protected String totalRows;
	protected String id;

	protected String queryName;
	protected String queryValue;
	protected String searchName;
	protected String searchValue;
	protected String queryMap;
	protected PrizeService prizeService;

	protected HttpServletResponse response = ServletActionContext.getResponse();
	protected ServletOutputStream sout;
	private InputStream imageStream;

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}

	/****** setter and get *****/

	public Collection getAvailableItems() {
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

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQueryValue() {
		return queryValue;
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
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

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public ServletOutputStream getSout() {
		return sout;
	}

	public void setSout(ServletOutputStream sout) {
		this.sout = sout;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String list() throws Exception {
		if (queryMap == null || queryMap.equals("")) {

		} else {
			String[] str = queryMap.split("~");
			this.setQueryName(str[0]);
			this.setQueryValue(str[1]);
		}

		int totalRow = prizeService.getRows(this.getQueryName(),
				this.getQueryValue());
		pager = pagerService.getPager(this.getCurrentPage(),
				this.getPagerMethod(), totalRow);
		this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
		this.setTotalRows(String.valueOf(totalRow));
		availableItems = prizeService.getPrizes(this.getQueryName(),
				this.getQueryValue(), pager.getPageSize(), pager.getStartRow());

		this.setQueryName(this.getQueryName());
		this.setQueryValue(this.getQueryValue());

		this.setSearchName(this.getQueryName());
		this.setSearchValue(this.getQueryValue());
		return SUCCESS;
	}

	public String load() throws Exception {
		logger.info(">>>>>>>>> LotteryAction load().");
		if (id != null)
			prize = prizeService.getPrize(id);
		else
			id = "";

		/*
		 * try { InputStream in = photo.getBinaryStream(); sout =
		 * response.getOutputStream(); byte b[] = new byte[1024]; int len =
		 * in.read(b); while (len != -1) { sout.write(b); len = in.read(b); }
		 * sout.flush(); sout.close(); in.close(); } catch (SQLException e) {
		 * e.printStackTrace(); return "error"; } catch (IOException e) {
		 * e.printStackTrace(); return "error"; }
		 */

		return SUCCESS;
	}

	@SuppressWarnings("deprecation")
	public String save() throws Exception {
		logger.info(">>>>>>>>> LotteryAction save().");
		
		
		String id = this.getPrize().getId();
		Prize prize = prizeService.getPrize(id);

		if (this.getPrize() != null) {
			if (image != null) {
				FileInputStream fin = new FileInputStream(image);// File ת
				Blob blob = Hibernate.createBlob(fin);// InputStream ת Blob
				this.prize.setPicture(blob);
				String name = new String(this.getPrize().getPrizeName().getBytes("GBK"));
				String desc = new String(this.getPrize().getDescription().getBytes("GBK"));
				this.prize.setPrizeName(name);
				this.prize.setDescription(desc);
			} else {
				/*
				 * image = new File("D:\\Tulips.jpg"); FileInputStream fin = new
				 * FileInputStream(image);// File ת InputStream Blob blob =
				 * Hibernate.createBlob(fin);// InputStream ת Blob
				 * this.prize.setPicture(blob);
				 */
				logger.info(">>>>>> debug .... nothing to do.");
			}
		}

		try {
			if (prize == null) {
				this.prize.setGmtCreate(new Date());
				this.prize.setGmtModify(new Date());
				prizeService.addPrize(this.getPrize());
			} else {
				prizeService.updatePrize(this.getPrize());
			}

		} catch (Exception e) {
			e.printStackTrace();
			return SUCCESS;
		}

		this.setQueryName(this.getQueryName());
		this.setQueryValue(this.getQueryValue());

		if (this.getQueryName() == null || this.getQueryValue() == null
				|| this.getQueryName().equals("")
				|| this.getQueryValue().equals("")) {

		} else {
			queryMap = this.getQueryName() + "~" + this.getQueryValue();
		}
		logger.info(">>>>>>>>> LotteryAction end save().");
		return SUCCESS;
	}

	public String delete() throws Exception {
		logger.info(">>>>>>>>> LotteryAction delete().");

		prizeService.deletePrize(this.getId());

		if (this.getQueryName() == null || this.getQueryValue() == null
				|| this.getQueryName().equals("")
				|| this.getQueryValue().equals("")) {

		} else {
			queryMap = this.getQueryName() + "~" + this.getQueryValue();
		}
		return SUCCESS;
	}

	public String getImageById(){
		logger.info(">>>>>>>>>> getImageById starting...");
		//InputStream inputStream = null;
		logger.info(">>>>>>>>>> id="+id);
		try {
			imageStream = prizeService.getPrize(id).getPicture().getBinaryStream();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String  getImagesByLevel() {
		logger.info(">>>>>> get image by level.....");
		prizeLevel0 = new ArrayList<Prize>();
		prizeLevel1 = new ArrayList<Prize>();
		prizeLevel2 = new ArrayList<Prize>();
		prizeLevel3 = new ArrayList<Prize>();
		prizeLevel4 = new ArrayList<Prize>();
		prizeLevel5 = new ArrayList<Prize>();
		/*this.setQueryName("prizeLevel");
		this.setQueryValue("1");
		if (queryMap == null || queryMap.equals("")) {

		} else {
			String[] str = queryMap.split("~");
			this.setQueryName(str[0]);
			this.setQueryValue(str[1]);
		}

		int totalRow = prizeService.getRows(this.getQueryName(),
				this.getQueryValue());
		pager = pagerService.getPager(this.getCurrentPage(),
				this.getPagerMethod(), totalRow);
		this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
		this.setTotalRows(String.valueOf(totalRow));*/
		availableItems = prizeService.getAll();
		
		if (availableItems != null && availableItems.size()>0) {
			
			Iterator<Prize> iterator = availableItems.iterator();
			while (iterator.hasNext()) {
				Prize prize = iterator.next();
				if (prize.getPrizeLevel().equals("0")) {
					prizeLevel0.add(prize);
				}else if(prize.getPrizeLevel().equals("1")){
					prizeLevel1.add(prize);
				}else if (prize.getPrizeLevel().equals("2")) {
					prizeLevel2.add(prize);
				}else if (prize.getPrizeLevel().equals("3")) {
					prizeLevel3.add(prize);
				}else if (prize.getPrizeLevel().equals("4")) {
					prizeLevel4.add(prize);
				}else if (prize.getPrizeLevel().equals("5")) {
					prizeLevel5.add(prize);
				}
			} 
		}

		logger.info(">>>>>>> get all Image size:"+availableItems.size());
		logger.info(">>>>> prize level 0 size:"+prizeLevel0.size());
		logger.info(">>>>> prize level 1 size:"+prizeLevel1.size());
		logger.info(">>>>> prize level 2 size:"+prizeLevel2.size());
		logger.info(">>>>> prize level 3 size:"+prizeLevel3.size());
		logger.info(">>>>> prize level 4 size:"+prizeLevel4.size());
		return SUCCESS;
	}
	
	
}

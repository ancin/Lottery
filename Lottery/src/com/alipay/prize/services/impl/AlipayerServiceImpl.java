package com.alipay.prize.services.impl;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.alipay.prize.dao.BaseDao;
import com.alipay.prize.dao.impl.AlipayerDaoImpl;
import com.alipay.prize.model.Alipayer;
import com.alipay.prize.services.AlipayerService;

@SuppressWarnings("rawtypes")
public class AlipayerServiceImpl implements AlipayerService {

	private AlipayerDaoImpl alipayerDao;
	
	@JSON(serialize=false)
	public BaseDao getAlipayerDao() {
		return alipayerDao;
	}

	public void setAlipayerDao(BaseDao alipayerDao) {
		this.alipayerDao = (AlipayerDaoImpl)alipayerDao;
	}
	
	public List getAll() {
		// TODO Auto-generated method stub
		return alipayerDao.getAll();
	}

	public List getAlipayers(int pageSize, int startRow) {
		// TODO Auto-generated method stub
		return alipayerDao.getObjs(pageSize,startRow);
	}

	public int getRows() {
		// TODO Auto-generated method stub
		return alipayerDao.getRows();
	}

	public int getRows(String fieldname, String value) {
		// TODO Auto-generated method stub
		return alipayerDao.getRows(fieldname, value);
	}

	public List queryAlipayers(String fieldname, String value) {
		// TODO Auto-generated method stub
		return alipayerDao.queryObjs(fieldname, value);
	}

	public List getAlipayers(String fieldname, String value, int pageSize,
			int startRow) {
		// TODO Auto-generated method stub
		return alipayerDao.getObjs(fieldname, value, pageSize, startRow);
	}

	public Alipayer getAlipayer(String alipayerId) {
		// TODO Auto-generated method stub
		return (Alipayer)alipayerDao.getObj(Alipayer.class.getName(), alipayerId);
	}

	public void addAlipayer(Alipayer alipayer) {
		alipayerDao.addObj(alipayer);
	}

	public void updateAlipayer(Alipayer alipayer) {
		alipayerDao.updateObj(alipayer);
	}

	public void deleteAlipayer(Alipayer alipayer) {
		alipayerDao.deleteObj(alipayer);

	}
	
	public void deleteAlipayerById(String Id){
		
		Alipayer alipayer = getAlipayer(Id);
		
		deleteAlipayer(alipayer);
		
		
	}
	
	
	public Alipayer getAlipayerByNumber(String number){
		
		
		List alipayerList = alipayerDao.findAlipayerByNumber(number);
		if (alipayerList!=null && alipayerList.size()>0)
			return (Alipayer)alipayerList.get(0);
		return null;
		
	}
	
	
	
	

}

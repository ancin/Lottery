package com.alipay.prize.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.alipay.commons.TableName;
import com.alipay.prize.model.Alipayer;


public class AlipayerDaoImpl extends BaseDaoImpl {
	@Override
	public void setTableName() {
		this.tableName = TableName.Alipayer;
	}

	@Override
	public void setLogger() {
		logger = Logger.getLogger(AlipayerDaoImpl.class);
	}
	
	public List findAlipayerByNumber(String number){
		
	DetachedCriteria dc = DetachedCriteria.forClass(Alipayer.class);
	dc.add(Restrictions.eq("number", number));
	
	return getHibernateTemplate().findByCriteria(dc);

	
	}

}

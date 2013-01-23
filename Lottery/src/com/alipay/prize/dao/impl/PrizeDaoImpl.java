package com.alipay.prize.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.alipay.prize.dao.PrizeDao;
import com.alipay.prize.model.Prize;

@SuppressWarnings("rawtypes")
public class PrizeDaoImpl extends HibernateDaoSupport implements PrizeDao{

	private static final Logger logger = Logger.getLogger(PrizeDaoImpl.class);;
	
	public List getAll() {
		String sql="FROM Prize where leftNum>0 ORDER BY gmtCreate";
		return this.getHibernateTemplate().find(sql);
	}

	public List getPrizes(int pageSize, int startRow) {
		final int pageSize1=pageSize;
		final int startRow1=startRow;
		return this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				
				Query query=session.createQuery("FROM Prize ORDER BY gmtCreate");
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}

	public int getRows() {
		String sql="FROM Prize ORDER BY gmtCreate";
		List list=this.getHibernateTemplate().find(sql);
		return list.size();
	}

	public int getRows(String fieldname, String value) {
		logger.info(">>>>>>fieldname="+fieldname +",value="+value);
		String sql="";
		if(fieldname==null||fieldname.equals("")||fieldname==null||fieldname.equals(""))
			sql="FROM Prize ORDER BY gmtCreate";
		else	
			sql="FROM Prize where "+fieldname+" like '%"+value+"%'"+"ORDER BY gmtCreate";
		List list=this.getHibernateTemplate().find(sql);
		return list.size();
	}

	public List queryPrizes(String fieldname, String value) {
		String sql="FROM Prize where "+fieldname+" like '%"+value+"%'"+"ORDER BY gmtCreate";
		return this.getHibernateTemplate().find(sql);
	}

	public List getPrizes(String fieldname, String value, int pageSize,
			int startRow) {
		final int pageSize1=pageSize;
		final int startRow1=startRow;
		final String queryName=fieldname;
		final String queryValue=value;
		String sql="";
		
		if(queryName==null||queryName.equals("")||queryValue==null||queryValue.equals(""))
			sql="FROM Prize ORDER BY gmtCreate";
		else	
			sql="FROM Prize where "+fieldname+" like '%"+value+"%'"+"ORDER BY gmtCreate";
		
		final String sql1=sql;
		return this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery(sql1);
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}

	public Prize getPrize(String prizeId) {
		return (Prize)this.getHibernateTemplate().get(Prize.class,prizeId);
	}

	public void addPrize(Prize prize) {
		this.getHibernateTemplate().save(prize);
	}

	public void updatePrize(Prize prize) {
		this.getHibernateTemplate().update(prize);
		getHibernateTemplate().getSessionFactory().getCurrentSession().flush();
	}

	public void deletePrize(Prize prize) {
		this.getHibernateTemplate().delete(prize);
	}

	public void logicDelete(Prize prize) {
		if (prize != null) {
			prize.setLeftNum(prize.getLeftNum()-1);
			this.getHibernateTemplate().update(prize);
		}
		getHibernateTemplate().getSessionFactory().getCurrentSession().flush();
	}

	public List getPrizeLevel() {
		Criteria criteria = super.getSession().createCriteria(Prize.class);
		criteria.setProjection(Projections.groupProperty("prizeLevel"));
		return criteria.list();
	}
	

}

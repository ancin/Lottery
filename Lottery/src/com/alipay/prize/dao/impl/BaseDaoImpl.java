package com.alipay.prize.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.alipay.commons.TableName;
import com.alipay.prize.dao.BaseDao;

@SuppressWarnings("rawtypes")
public abstract class BaseDaoImpl extends HibernateDaoSupport implements
		BaseDao {

	private final class HibernateCallbackImplementation implements
			HibernateCallback {
		private final int startRow1;
		private final int pageSize1;
		private final String sql;

		private HibernateCallbackImplementation(int startRow1, int pageSize1,
				String sql) {
			this.startRow1 = startRow1;
			this.pageSize1 = pageSize1;
			this.sql = sql;
		}

		public Object doInHibernate(Session session) throws HibernateException,
				SQLException {

			Query query = session.createQuery(sql);
			if (startRow1 != -1 && pageSize1 != -1) {
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
			}
			return query.list();
		}
	}

	protected static Logger logger;

	protected TableName tableName;

	abstract public void setTableName();

	abstract public void setLogger();

	public BaseDaoImpl() {
		setTableName();
		setLogger();
	}

	public List getAll() {
		String sql = "";

		if (tableName.toString().equalsIgnoreCase("lotteryResult")) {
			sql = "FROM " + tableName.toString() + "  ORDER BY "
					+ "gmtCreate";
		}else {
			sql = "FROM " + tableName.toString() + " where FLAG='T' ORDER BY "
					+ "gmtCreate";
		}
				return this.getHibernateTemplate().find(sql);
	}

	public List getObjs(int pageSize, int startRow) {
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		String sql = "FROM " + tableName.toString() + " ORDER BY "
				+ "gmtCreate";
		return this.getHibernateTemplate().executeFind(
				new HibernateCallbackImplementation(startRow1, pageSize1, sql));
	}

	public int getRows() {
		String sql = "FROM " + tableName.toString() + " ORDER BY "
				+ "gmtCreate";
		List list = this.getHibernateTemplate().find(sql);
		return list.size();
	}

	public int getRows(String fieldname, String value) {
		logger.info(">>>>>>fieldname=" + fieldname + ",value=" + value);
		String sql = "";
		if (fieldname == null || fieldname.equals("") || fieldname == null
				|| fieldname.equals(""))
			sql = "FROM " + tableName.toString() + " ORDER BY " + "gmtCreate";
		else
			sql = "FROM " + tableName.toString() + " where " + fieldname
					+ " like '%" + value + "%'" + " ORDER BY " + "gmtCreate";
		List list = this.getHibernateTemplate().find(sql);
		return list.size();
	}

	public List queryObjs(String fieldname, String value) {
		String sql = "FROM " + tableName.toString() + " where " + fieldname
				+ " like '%" + value + "%'" + " ORDER BY " + "gmtCreate";
		return this.getHibernateTemplate().find(sql);
	}

	public List getObjs(String fieldname, String value, int pageSize,
			int startRow) {
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		final String queryName = fieldname;
		final String queryValue = value;
		String sql = "";

		if (queryName == null || queryName.equals("") || queryValue == null
				|| queryValue.equals(""))
			sql = "FROM " + tableName.toString() + " ORDER BY " + "gmtCreate";
		else
			sql = "FROM " + tableName.toString() + " where " + fieldname
					+ " like '%" + value + "%'" + " ORDER BY " + "gmtCreate";

		final String sql1 = sql;
		return this.getHibernateTemplate()
				.executeFind(
						new HibernateCallbackImplementation(startRow1,
								pageSize1, sql1));
	}

	public Object getObj(String classType, String id) {
		return this.getHibernateTemplate().get(classType, id);
	}

	public void addObj(Object obj) {
		this.getHibernateTemplate().save(obj);
	}

	public void updateObj(Object obj) {
		this.getHibernateTemplate().update(obj);
	}

	public void deleteObj(Object obj) {
		this.getHibernateTemplate().delete(obj);
	}

}

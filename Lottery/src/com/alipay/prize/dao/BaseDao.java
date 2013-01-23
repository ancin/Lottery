package com.alipay.prize.dao;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface BaseDao {
		List getAll();// ���������Ա

		List getObjs(int pageSize, int startRow);// ������м�¼

		int getRows();// ���������

		int getRows(String fieldname, String value);// ���������

		List queryObjs(String fieldname, String value);// ����������ѯ

		List getObjs(String fieldname, String value, int pageSize, int startRow);// ����������ѯ

		Object getObj(String classType, String id);// ����ID��ü�¼

		void addObj(Object obj);// ��Ӽ�¼

		void updateObj(Object obj);// �޸ļ�¼

		void deleteObj(Object obj);// ɾ����¼
}

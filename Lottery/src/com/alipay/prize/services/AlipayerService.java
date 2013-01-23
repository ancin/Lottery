package com.alipay.prize.services;

import java.util.List;

import com.alipay.prize.model.Alipayer;

@SuppressWarnings("rawtypes")
public interface AlipayerService {
	List getAll();// ������м�¼

	List getAlipayers(int pageSize, int startRow);// ������м�¼

	int getRows();// ���������

	int getRows(String fieldname, String value);// ���������

	List queryAlipayers(String fieldname, String value);// ����������ѯ

	List getAlipayers(String fieldname, String value, int pageSize, int startRow);// ����������ѯ

	Alipayer getAlipayer(String id);// ����ID��ü�¼

	void addAlipayer(Alipayer alipayer);// ��Ӽ�¼

	void updateAlipayer(Alipayer alipayer);// �޸ļ�¼

	void deleteAlipayer(Alipayer alipayer);// ɾ����¼

}

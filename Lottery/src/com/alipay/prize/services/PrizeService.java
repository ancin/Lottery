package com.alipay.prize.services;

import java.util.List;

import com.alipay.prize.model.Prize;

@SuppressWarnings("rawtypes")
public interface PrizeService {

	List getAll();// ������м�¼

	List getPrizes(int pageSize, int startRow);// ������м�¼

	int getRows();// ���������

	int getRows(String fieldname, String value);// ���������

	List queryPrizes(String fieldname, String value);// ����������ѯ

	List getPrizes(String fieldname, String value, int pageSize, int startRow);// ����������ѯ

	Prize getPrize(String prizeId);// ����ID��ü�¼

	void addPrize(Prize prize);// ��Ӽ�¼

	void updatePrize(Prize prize);// �޸ļ�¼

	void deletePrize(Prize prize);// ɾ����¼
	void deletePrize(String id);// ɾ����¼
	void logicDelete(Prize prize);
}

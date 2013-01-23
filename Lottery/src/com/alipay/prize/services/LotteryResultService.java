package com.alipay.prize.services;

import java.util.List;
import com.alipay.prize.model.LotteryResult;

;
@SuppressWarnings("rawtypes")
public interface LotteryResultService {

	List getAll();// ������м�¼

	List getResults(int pageSize, int startRow);// ������м�¼

	int getRows();// ���������

	int getRows(String fieldname, String value);// ���������

	List queryResults(String fieldname, String value);// ����������ѯ

	List getResults(String fieldname, String value, int pageSize, int startRow);// ����������ѯ

	LotteryResult getResult(String id);// ����ID��ü�¼

	void addResult(LotteryResult result);// ��Ӽ�¼

	void updateResult(LotteryResult result);// �޸ļ�¼

	void deleteResult(LotteryResult result);// ɾ����¼

	List queryResultsByPrizeLevel(String level, int pageSize, int startRow)
			throws Exception;// ����������ѯ
}

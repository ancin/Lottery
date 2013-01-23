package com.alipay.commons;

public class PagerService {
	public Pager getPager(String currentPage,String pagerMethod,int totalRows) {
		//	����pager�������ڴ���ҳ��
		Pager pager = new Pager(totalRows);
		//	�����ǰҳ��Ϊ�գ���ʾΪ�״β�ѯ��ҳ
		//	�����Ϊ�գ���ˢ��pager�������뵱ǰҳ�ŵ���Ϣ
		if (currentPage != null) {
			pager.refresh(Integer.parseInt(currentPage));
		}
		//	��ȡ��ǰִ�еķ�������ҳ��ǰһҳ����һҳ��βҳ��
		if (pagerMethod != null) {
			if (pagerMethod.equals("first")) {
				pager.first();
			} else if (pagerMethod.equals("previous")) {
				pager.previous();
			} else if (pagerMethod.equals("next")) {
				pager.next();
			} else if (pagerMethod.equals("last")) {
				pager.last();
			}
		}
		return pager;
	}
}

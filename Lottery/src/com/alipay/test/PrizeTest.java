package com.alipay.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.alipay.prize.model.Prize;


public class PrizeTest {

    public static void main(String[] args) {

        try {
            SessionFactory sf =
                new Configuration().configure().buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();
            Prize prize = new Prize();
            prize.setDescription("this desc");
            prize.setLeftNum(2);
            prize.setTotalNum(20);
            prize.setPrizeLevel("2");
            prize.setPrizeName("prizeName test");
            
            session.save(prize);
            	
            tx.commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}

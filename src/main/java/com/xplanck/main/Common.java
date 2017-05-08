package com.xplanck.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.xplanck.DBDao.CreateSessionFactory;
import com.xplank.entities.Campaign;

public class Common {

	public static ArrayList<Integer> getClientFromCampaigns()
	{
		ArrayList<Integer> clientList = new ArrayList<Integer>();
		
		Session session = CreateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Campaign.class);
		
		criteria.add(Restrictions.eq("type", "1"));
		criteria.add(Restrictions.eq("isCatalogCreated", "0"));
			
		List<Campaign> getCampaign = (List<Campaign>) criteria.list();
		
		session.getTransaction().commit();
		session.close();

		for(Campaign campaign : getCampaign)
		{
			clientList.add(campaign.getClientId());
		}
		
		return clientList;
	}
	
	public static ArrayList<Integer> getClientFromCampaignCatalogCre()
	{
		ArrayList<Integer> clientList = new ArrayList<Integer>();
		
		Session session = CreateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Campaign.class);
		
		criteria.add(Restrictions.eq("type", "1"));
		criteria.add(Restrictions.eqOrIsNull("isCatalogCreated", "2"));
		
		List<Campaign> getCampaign = (List<Campaign>) criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(Campaign campaign : getCampaign)
		{
			clientList.add(campaign.getClientId());
		}
		
		return clientList;
	}
	
}

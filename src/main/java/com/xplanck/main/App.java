package com.xplanck.main;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.xplanck.DBDao.CreateSessionFactory;
import com.xplank.entities.Campaign;
import com.xplank.entities.Client;
import com.xplanck.main.Common;

public class App {

	public static void main(String arg[])
	{
		Common common = new Common();
		
		List<Integer> newClient = common.getClientFromCampaigns();
			
		for(int clientId : newClient)
		{
			Session session = CreateSessionFactory.getSessionFactory().openSession();
			session.beginTransaction();
			Client getClient = (Client) session.get(Client.class, clientId);
			
			session.getTransaction().commit();
			session.close();
			
			String website = getClient.getWebsite();
			
			String hostname = null;
			
			if(website.substring(0, 7).equals("http://"))
			{
				try{
					URL url = new URL(website);
					hostname = url.getHost();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else if(website.substring(0, 8).equals("https://"))
			{
				try{
					URL url = new URL(website);
					hostname = url.getHost();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else if(website.substring(0,3).equals("www"))
			{
				try{
					URL url = new URL("http://" + website);
					hostname = url.getHost();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else
			{
				try{
					URL url = new URL("http://" + website);
					hostname = url.getHost();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			
			System.out.println("Hostname is : " + hostname);
			
			if(hostname != null)
			{
				try {
					
					int result;
					
					if(hostname.substring(0, 4).equals("www.")){
						result = CSVCreator.newCatalogCreate(hostname.substring(4));
					}
					else{
						result = CSVCreator.newCatalogCreate(hostname);
					}
					
					Session sessionSave = CreateSessionFactory.getSessionFactory().openSession();
					sessionSave.beginTransaction();
					
					Criteria criteria = sessionSave.createCriteria(Campaign.class);
					
					criteria.add(Restrictions.eq("clientId", clientId));
					criteria.add(Restrictions.eq("type", "1"));
					
					List<Campaign> getCampaign = (List<Campaign>) criteria.list();
					
					System.out.println("The getCampaign with type 1 and client id : "+ clientId +"is : "+ getCampaign.size());
					
					for(Campaign campaign : getCampaign)
					{
						campaign.setIsCatalogCreated("1");
						sessionSave.saveOrUpdate(campaign);
					}
					
					sessionSave.getTransaction().commit();
					sessionSave.close();
					
					System.out.println("Create File Successfully..");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		List<Integer> updateClient = common.getClientFromCampaignCatalogCre();
	
		for(int clientId : updateClient)
		{
			System.out.println("client id is : "+clientId);
			
			Session session = CreateSessionFactory.getSessionFactory().openSession();
			session.beginTransaction();
			
			Client getClient = (Client) session.get(Client.class, clientId);
			session.getTransaction().commit();
			session.close();
			
			String website = getClient.getWebsite();
			
			System.out.println("hostname is : "+website);
			
			String hostname = null;
			
			if(website.substring(0, 7).equals("http://"))
			{
				try{
					URL url = new URL(website);
					System.out.println("Url in website.substring(0, 7).equals('http://') : "+url);
					hostname = url.getHost();
					System.out.println("Hostname in website.substring(0, 7).equals('http://') : "+hostname);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else if(website.substring(0, 8).equals("https://"))
			{
				try{
					URL url = new URL(website);
					System.out.println("Url in website.substring(0, 8).equals('https://') : "+url);
					hostname = url.getHost();
					System.out.println("Hostname in website.substring(0, 8).equals('https://') : "+hostname);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else if(website.substring(0,3).equals("www"))
			{
				try{
					URL url = new URL("http://" + website);
					System.out.println("Url in website.substring(0,3).equals('www') : "+url);
					hostname = url.getHost();
					System.out.println("Hostname in website.substring(0,3).equals('www') : "+hostname);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else
			{
				try{
					URL url = new URL("http://www." + website);
					System.out.println("URL in else : "+url);
					hostname = url.getHost();
					System.out.println("Hostname in else : "+hostname);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			
			if(hostname != null)
			{
				try {
					int result;
					
					if(hostname.substring(0, 4).equals("www.")){
						result = CSVCreator.newCatalogCreate(hostname.substring(4));
					}
					else{
						result = CSVCreator.newCatalogCreate(hostname);
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		CreateSessionFactory.getSessionFactory().close();
		System.exit(0);
		
	}
	
}
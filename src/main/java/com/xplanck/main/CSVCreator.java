package com.xplanck.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.xplanck.DBDao.CreateSessionFactory;
import com.xplank.entities.ProductCatalog;

public class CSVCreator {

	public static int newCatalogCreate(String hostname) throws IOException
	{
		System.out.println("Hostname in newCatalogCreate : "+hostname);
		
		String HEADER_STRING = "id,brand,title,description,availability,gender,price,condition,link,image_link,product_type";
		
		String NEW_LINE_SEPERATOR = "\n";
		
		String COMMA_DELIMITER = ",";
		
		String QUOTES_SEPERATOR = "\"";
		
		Session session = CreateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(ProductCatalog.class);
		criteria.add(Restrictions.like("hostname", "%"+hostname+"%"));
		//criteria.add(Restrictions.eq("hostname", "www." + hostname));
		
		List<ProductCatalog> products = (List<ProductCatalog>) criteria.list();
		
		session.getTransaction().commit();
		session.close();
	
	//	System.out.println("C:\\Users\\bhuvnesh\\Desktop\\Catalog\\"+ hostname.trim()+".csv");
		
	// WINDOWS :  FileWriter writer = new FileWriter("C:\\Users\\bhuvnesh\\Desktop\\Catalog\\"+ hostname.trim()+".csv");
		
		System.out.println("/var/www/html/customer-data/product-catalog/"+ hostname.trim()+".csv");
		
		FileWriter writer = new FileWriter("/var/www/html/customer-data/product-catalog/"+ hostname.trim()+".csv");
		
		writer.append(HEADER_STRING);
		
		for(int i = 0; i < products.size(); i++)	
		{
			ProductCatalog product = products.get(i);
			if(product.getProduct_id() != null || !(product.getProduct_id().equals("null")) || product.getProduct_name() != null || !(product.getProduct_name().equals("null")) || product.getProduct_url() != null || (!product.getProduct_url().equals("null")) || product.getFullImageUrl() != null || (!product.getFullImageUrl().equals("null"))){
				writer.append(NEW_LINE_SEPERATOR);
				writer.append(QUOTES_SEPERATOR);
				writer.append(product.getProduct_id());
				writer.append(QUOTES_SEPERATOR);
				writer.append(COMMA_DELIMITER);
				writer.append(QUOTES_SEPERATOR);
				writer.append(hostname.substring(0, hostname.length() - 4));
				writer.append(QUOTES_SEPERATOR);
				writer.append(COMMA_DELIMITER);
				writer.append(QUOTES_SEPERATOR);
				writer.append(product.getProduct_name());
				writer.append(QUOTES_SEPERATOR);
				writer.append(COMMA_DELIMITER);
				writer.append(QUOTES_SEPERATOR);
				writer.append("Check out the latest product @ "+hostname);
				writer.append(QUOTES_SEPERATOR);
				writer.append(COMMA_DELIMITER);
				writer.append(QUOTES_SEPERATOR);
				writer.append("in stock");
				writer.append(QUOTES_SEPERATOR);
				writer.append(COMMA_DELIMITER);
				writer.append(QUOTES_SEPERATOR);
				if(product.getGender().equalsIgnoreCase("M"))
				{
					writer.append("male");
				}
				else if(product.getGender().equalsIgnoreCase("F"))
				{
					writer.append("female");
				}
				else if(null == product.getGender() || product.getGender().equalsIgnoreCase("A") || product.getGender().equalsIgnoreCase("U"))
				{
					writer.append("unisex");
				}
				writer.append(QUOTES_SEPERATOR);
				writer.append(COMMA_DELIMITER);
				writer.append(QUOTES_SEPERATOR);
				writer.append("1000");
				writer.append(QUOTES_SEPERATOR);
				writer.append(COMMA_DELIMITER);
				writer.append(QUOTES_SEPERATOR);
				writer.append("new");
				writer.append(QUOTES_SEPERATOR);
				writer.append(COMMA_DELIMITER);
				writer.append(QUOTES_SEPERATOR);
				if(product.getProduct_url().substring(0, 2).equals("//"))
				{
					writer.append("http:" + product.getProduct_url());
				}
				else if(product.getProduct_url().substring(0, 4).equals("www."))
				{
					writer.append("http://" + product.getProduct_url());
				}
				else if(product.getProduct_url().substring(0, 5).equals("https"))
				{
					writer.append(product.getProduct_url());
				}
				else if(product.getProduct_url().substring(0, 4).equals("http"))
				{
					writer.append(product.getProduct_url());
				}
				else{
					writer.append("http://"+product.getProduct_url());
				}
				writer.append(QUOTES_SEPERATOR);
				writer.append(COMMA_DELIMITER);
				writer.append(QUOTES_SEPERATOR);
				if(null == product.getProcessed_image() || product.getProcessed_image().equals("") || product.getProcessed_image().isEmpty())
				{
					if(product.getFullImageUrl().substring(0, 2).equals("//"))
					{
						writer.append("http:" + product.getFullImageUrl());
					}
					else if(product.getFullImageUrl().substring(0, 4).equals("www."))
					{
						writer.append("http://" + product.getFullImageUrl());
					}
					else if(product.getFullImageUrl().substring(0, 5).equals("https"))
					{
						writer.append(product.getFullImageUrl());
					}
					else if(product.getFullImageUrl().substring(0, 4).equals("http"))
					{
						writer.append(product.getFullImageUrl());
					}
					else{
						writer.append("http://"+product.getFullImageUrl());
					}
				}
				else
				{
					if(product.getProcessed_image().substring(0, 2).equals("//"))
					{
						writer.append("http:" + product.getProcessed_image());
					}
					else if(product.getProcessed_image().substring(0, 4).equals("www."))
					{
						writer.append("http://" + product.getProcessed_image());
					}
					else if(product.getProcessed_image().substring(0, 5).equals("https"))
					{
						writer.append(product.getProcessed_image());
					}
					else if(product.getProcessed_image().substring(0, 4).equals("http"))
					{
						writer.append(product.getProcessed_image());
					}
					else{
						writer.append("http://"+product.getProcessed_image());
					}
				}
				writer.append(QUOTES_SEPERATOR);
				if(product.getExcluded() == 0){
					writer.append(COMMA_DELIMITER);
					writer.append(QUOTES_SEPERATOR);
					writer.append(product.getProduct_category());
					writer.append(QUOTES_SEPERATOR);
				}
				else if(product.getExcluded() == 1 || product.getGender().equalsIgnoreCase("U")){
					writer.append(COMMA_DELIMITER);
					writer.append(QUOTES_SEPERATOR);
					writer.append("Excluded");
					writer.append(QUOTES_SEPERATOR);
				}
			}
			else{
				continue;
			}
		}
		
		writer.flush();
		writer.close();
		
		System.out.println("CSV Created..");
		
		return 1;
	
	}
	
	public static void oldCatalogUpdate(String hostname)
	{
		
	}
	
}
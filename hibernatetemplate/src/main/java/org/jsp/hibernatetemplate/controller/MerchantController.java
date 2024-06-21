package org.jsp.hibernatetemplate.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.hibernatetemplate.dao.MerchantDao;
import org.jsp.hibernatetemplate.dto.Merchant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class MerchantController
{
	public static void main(String[] args)
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("app.xml");
		MerchantDao dao =ac.getBean(MerchantDao.class);
		System.out.println("1.save merchant");
		System.out.println("2.update merchant");
		System.out.println("3.find by id");
		System.out.println("4.delete merchant");
		System.out.println("5.dispaly all details");
		System.out.println("6.exit");
		Scanner s=new Scanner(System.in);
		switch(s.nextInt())
		{
		case 1:
		{
			System.out.println("Enter name,phone,email,password,gst");
			Merchant m=new Merchant();
			m.setName(s.next());
			m.setPhone(s.nextLong());
			m.setEmail(s.next());
			m.setPassword(s.next());
			m.setGst_number(s.next());
			m=dao.saveMerchant(m);
		    System.out.println("Merchant details are saved with :"+m.getId());
			break;
		}
		case 2:
		{
			System.out.println("Enter id,name,phone,email,password and gst");
			Merchant m=new Merchant();
			m.setId(s.nextInt());
			m.setName(s.next());
			m.setPhone(s.nextLong());
			m.setEmail(s.next());
			m.setPassword(s.next());
			m.setGst_number(s.next());
			m=dao.updateMerchant(m);
			System.out.println("Merchant details are updated");
			break;
			
		}
		case 3:
		{
			System.out.println("Enter id to fetch Merchant Details");
			int id=s.nextInt();
			Merchant m=new Merchant();
			m=dao.findById(id);
			System.out.println(m);
			break;
		}
		case 4:
		{
			System.out.println("enter id to delete the merchant");
			boolean b=dao.delete(s.nextInt());
			if(b)
				System.out.println("merchant deleted");
			else
				System.out.println("invalid merchant id");
			
			break;
		}
		case 5:
		{
		   System.out.println("all details");
		   List<Merchant> m=dao.findAll();
		   for (Merchant merchant : m) 
		   {
			System.out.println(merchant);
		   }
			break;
		}
		
		case 6:
		{
			System.out.println("Thank you");
			System.exit(0);
		}
		default:
			System.out.println("invalid option");
			
		}
	
		
	}

}

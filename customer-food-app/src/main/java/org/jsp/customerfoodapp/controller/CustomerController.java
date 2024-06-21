package org.jsp.customerfoodapp.controller;

import javax.persistence.EntityManager;
import java.util.*;
import org.jsp.customerfoodapp.CustomerConfig;
import org.jsp.customerfoodapp.dao.CustomerDao;
import org.jsp.customerfoodapp.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerController {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(CustomerConfig.class);
		CustomerDao dao=context.getBean(CustomerDao.class);
		System.out.println("1.save customer");
		System.out.println("2.Update Customer");
		System.out.println("3.find by id");
		System.out.println("4.verify customer by phone and password");
		System.out.println("5.verify customer by email and password");
		System.out.println("6.exit");
		Scanner s=new Scanner(System.in);
		switch (s.nextInt()) 
		{
		case 1:
		{
			System.out.println("Enter name,phone,email,age,gender and password");
			Customer cus=new Customer();
			cus.setName(s.next());
			cus.setPhone(s.nextLong());
			cus.setEmail(s.next());
			cus.setAge(s.nextInt());
			cus.setGender(s.next());
			cus.setPassword(s.next());
			cus=dao.saveCustomer(cus);
			if(cus!=null)
			{
				System.out.println("Customer details are saved with:"+cus.getId());
			}
			else
			{
				System.out.println("something worng ");
			}
			break;
		}
		case 2:
		{
			System.out.println("Enter id,name,phone,email,age,gender and password");
			Customer cus=new Customer();
			cus.setId(s.nextInt());
			cus.setName(s.next());
			cus.setPhone(s.nextLong());
			cus.setEmail(s.next());
			cus.setAge(s.nextInt());
			cus.setGender(s.next());
			cus.setPassword(s.next());
			cus=dao.updateCustomer(cus);
			if(cus!=null)
			{
				System.out.println("Customer details are updated with:"+cus.getId());
			}
			else
			{
				System.out.println("something worng ");
			}
			
			break;
		}
		case 3:
		{
			System.out.println("enter customer id:");
			int id=s.nextInt();
			Customer cus=new Customer();
			cus=dao.findById(id);
			if(cus!=null)
			{
				System.out.println(cus);
			}
			else
			{
				System.out.println("something worng ");
			}
			break;
		}
		case 4:
		{
			System.out.println("enter phone and password");
			long phone=s.nextLong();
			String password=s.next();
			Customer cus=dao.verify(phone, password);
			if(cus!=null)
			{
				System.out.println(cus);
			}
			else
			{
				System.out.println("something worng ");
			}
			break;
		}
		case 5:
		{
			System.out.println("enter emial and password");
			String email=s.next();
			String password=s.next();
			Customer cus=dao.verify(email, password);
			if(cus!=null)
			{
				System.out.println(cus);
			}
			else
			{
				System.out.println("something worng ");
			}
			
			break;
		}
		case 6:
		{
			System.out.println("Thank you");
			System.exit(0);
		}
		default:
		   System.out.println("Invalid option");
		}
	}
	
	
	

}

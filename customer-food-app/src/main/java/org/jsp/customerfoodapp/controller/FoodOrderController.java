package org.jsp.customerfoodapp.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;

import org.jsp.customerfoodapp.CustomerConfig;
import org.jsp.customerfoodapp.dao.FoodOrderDao;
import org.jsp.customerfoodapp.dto.Customer;
import org.jsp.customerfoodapp.dto.FoodOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class FoodOrderController {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(CustomerConfig.class);
		FoodOrderDao dao=context.getBean(FoodOrderDao.class);
		System.out.println("1.save food");
		System.out.println("2.update food");
		System.out.println("3.find foodBy  id");
		System.out.println("4.Find FoodByCustomerId");
		System.out.println("5.Find FoodByCustomerPhoneandPasswordS");
		System.out.println("6.exit");
		Scanner s=new Scanner(System.in);
		switch (s.nextInt()) {
		case 1:
		{
			System.out.println("enter customerid,fooditem,address,cost details");
			FoodOrder f=new FoodOrder();
			Customer c=new Customer();
			int id=s.nextInt();
			f.setFood_item(s.next());
			f.setAddress(s.next());
			f.setCost(s.nextDouble());
		    f=dao.saveFood(f,id);
		    if(f!=null)
		    {
		    	System.out.println("foodorder saved with:"+f.getId());
		    }
		    else
		    {
		    	System.out.println("something wrong");
		    }
			break;
		}
		case 2:
		{
			System.out.println("enter foodid,fooditem,address,cost details");
			FoodOrder f=new FoodOrder();
			f.setId(s.nextInt());
			f.setFood_item(s.next());
			f.setAddress(s.next());
			f.setCost(s.nextDouble());
			f=dao.updateOrder(f);
		    if(f!=null)
		    {
		    	System.out.println("foodorder updated with:"+f.getId());
		    }
		    else
		    {
		    	System.out.println("something wrong");
		    }
			break;
		}
		case 3:
		{
			System.out.println("enter food id");
			int id=s.nextInt();
			FoodOrder f=dao.findById(id);
			if(f!=null)
		    {
				System.out.println(f);
		    }
		    else
		    {
		    	System.out.println("something wrong");
		    }
			break;
		}
		case 4:
		{
			System.out.println("enter customer id");
			List<FoodOrder> order=dao.findByCustomerId(s.nextInt());
			if(order.isEmpty())
			{
				System.out.println("id not found");
			}
			else
			{
				for (FoodOrder foodOrder : order) {
					System.out.println(foodOrder);
					
				}
			}
			break;
		}
		case 5:
		{
			System.out.println("enter customer phone and password");
			long phone=s.nextLong();
			String password=s.next();
			List<FoodOrder> order=dao.findByCustomer(phone, password);
			if(order.isEmpty())
			{
				System.out.println("invalid phone and password");
			}
			else
			{
				for (FoodOrder foodOrder : order) {
					System.out.println(foodOrder);
				}
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

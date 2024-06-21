package org.jsp.employeedepartmentapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.employeedepartmentapp.Config;
import org.jsp.employeedepartmentapp.dao.EmployeeDao;
import org.jsp.employeedepartmentapp.dto.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeController {
	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
		EmployeeDao dao=ac.getBean(EmployeeDao.class);
		System.out.println("1.save employee");
		System.out.println("2.update employee");
		System.out.println("3.find by id");
		System.out.println("4.find by dept id");
		System.out.println("5.find by dept name");
		System.out.println("6.exit");
		Scanner s=new Scanner(System.in);
		switch (s.nextInt()) {
		case 1:
		{
			System.out.println("enter emp dept id,name and desig details");
			Employee emp=new Employee();
			int id=s.nextInt();
			emp.setName(s.next());
			emp.setDesig(s.next());
			emp=dao.saveEmployee(emp, id);
			if(emp!=null)
			{
				System.out.println("with:"+emp.getId());
			}
			else
			{
				System.out.println("wrong");
			}
			break;
			
		}
		case 2:
		{
			System.out.println("enter emp id,name,desig to updatde");
			Employee emp=new Employee();
			emp.setId(s.nextInt());
			emp.setName(s.next());
			emp.setDesig(s.next());
			emp=dao.updateEmployee(emp);
			if(emp!=null)
			{
				System.out.println("with:"+emp.getId());
			}
			else
			{
				System.out.println("wrong");
			}
			break;

		}
		case 3:
		{
			System.out.println("enter id to fetch");
			int id=s.nextInt();
			Employee e=dao.findById(id);
			if(e!=null)
			{
				System.out.println(e);
			}
			else
			{
				System.out.println("wrong");
			}
			break;
		}
		case 4:
		{
			System.out.println("enter dept id to find");
			int id=s.nextInt();
		    List<Employee> e=dao.findByDeptId(id);
		    if(e.isEmpty())
		    {
		    	System.out.println("something wrong");
		    }
		    else
		    {
		    	for (Employee employee : e) {
					System.out.println(employee);
				}
		    }
		    break;
		}
		case 5:
		{
			System.out.println("enter name");
			String name=s.next();
			List<Employee> e=dao.findByName(name);
			if(e.isEmpty())
			{
				System.out.println("wrong");
			}
			else
			{
				for (Employee employee : e) {
					System.out.println(employee);
				}
			}
			break;
		}
		case 6:
		{
			System.out.println("thank you");
			System.exit(0);
		}
		default:
			System.out.println("invalid option");
			break;
		}
	}

}

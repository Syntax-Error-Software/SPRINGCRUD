package org.jsp.employeedepartmentapp.controller;

import java.util.Scanner;

import org.jsp.employeedepartmentapp.Config;
import org.jsp.employeedepartmentapp.dao.DepartmentDao;
import org.jsp.employeedepartmentapp.dto.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentController {
	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
		DepartmentDao dao=ac.getBean(DepartmentDao.class);
		System.out.println("1save department");
		System.out.println("2.update department");
		System.out.println("3find by dept id");
		System.out.println("4.exit");
		Scanner s=new Scanner(System.in);
		switch (s.nextInt()) {
		case 1:
		{
			System.out.println("enter dname and dloc");
			Department d=new Department();
			d.setDname(s.next());
			d.setDloc(s.next());
			d=dao.saveDepartment(d);
			if(d!=null)
			{
				System.out.println("dept details are saved with:"+d.getId());
			}
			else
			{
				System.out.println("wrong");
			}
			break;
		}
			
		case 2:
		{
			System.out.println("enter id ,name and loc");
			Department d=new Department();
			d.setId(s.nextInt());
			d.setDname(s.next());
			d.setDloc(s.next());
			d=dao.updateDepartment(d);
			if(d!=null)
			{
				System.out.println("dept details are updated with:"+d.getId());
			}
			else
			{
				System.out.println("wrong");
			}
			break;
		}
		case 3:
		{
			System.out.println("enter id");
			int id=s.nextInt();
			Department d=dao.findById(id);
			if(d!=null)
			{
				System.out.println(d);
			}
			else
			{
				System.out.println("wrong");
			}
		}
		case 4:
		{
			System.out.println("Thank you");
			System.exit(0);
		}

		default:
			System.out.println("invalid option");
			break;
		}
		
	}

}

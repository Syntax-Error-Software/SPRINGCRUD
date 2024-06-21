package org.jsp.employee.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.employee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	private EntityManager entityManager;
	
	public Employee saveEmployee(Employee employee)
	{
		EntityTransaction t=entityManager.getTransaction();
		entityManager.persist(employee);
		t.begin();
		t.commit();
		return employee;
	}
	
	public Employee updateEmployee(Employee employee)
	{
		Employee d=entityManager.find(Employee.class, employee.getId());
		EntityTransaction t=entityManager.getTransaction();
		if(d!=null)
		{
			d.setName(employee.getName());
			d.setDesig(employee.getDesig());
			d.setEmail(employee.getEmail());
			d.setGender(employee.getGender());
			d.setPassword(employee.getPassword());
			d.setPhone(employee.getPhone());
			d.setSalary(employee.getSalary());
			t.begin();
			t.commit();
			return d;
		}
		return null;
	}
	
	public Employee findById(int id)
	{
		return entityManager.find(Employee.class, id);
	}
	
	public Employee verify(long phone,String password)
	{
		Query q=entityManager.createQuery("select e from Employee e where e.phone=?1 and e.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		
		try {
			return (Employee) q.getSingleResult();
		}
		catch(NoResultException e)
		{
			return null;
		}
	}
	
	public Employee verify(String email,String password)
	{
		Query q=entityManager.createQuery("select e from Employee e where e.email=?1 and e.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		
		try {
			return (Employee) q.getSingleResult();
		}
		catch(NoResultException e)
		{
			return null;
		}
	}
	
	public Employee verify(int id,String password)
	{
		Query q=entityManager.createQuery("select e from Employee e where e.id=?1 and e.password=?2");
		q.setParameter(1, id);
		q.setParameter(2, password);
		
		try {
			return (Employee) q.getSingleResult();
		}
		catch(NoResultException e)
		{
			return null;
		}
	}
	
	public boolean deleteById(int id)
	{
		EntityTransaction t=entityManager.getTransaction();
		Employee emp=findById(id);
		if(emp!=null)
		{
			entityManager.remove(emp);
			t.begin();
			t.commit();
			return true;
		}
		return false;
	}

}

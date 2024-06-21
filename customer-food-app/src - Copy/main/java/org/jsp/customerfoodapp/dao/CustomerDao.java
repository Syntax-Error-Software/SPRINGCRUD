package org.jsp.customerfoodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.customerfoodapp.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	@Autowired
	private EntityManager entityManager;
	
	public Customer saveCustomer(Customer customer)
	{
		EntityTransaction transaction=entityManager.getTransaction();
		entityManager.persist(customer);
		transaction.begin();
		transaction.commit();
		return customer;
	}
	
	public Customer updateCustomer(Customer customer)
	{
		EntityTransaction transaction=entityManager.getTransaction();
		Customer dbCustomer=entityManager.find(Customer.class, customer.getId());
		if(dbCustomer!=null)
		{
			dbCustomer.setName(customer.getName());
			dbCustomer.setAge(customer.getAge());
			dbCustomer.setEmail(customer.getEmail());
			dbCustomer.setGender(customer.getGender());
			dbCustomer.setPassword(customer.getPassword());
			dbCustomer.setPhone(customer.getPhone());
			transaction.begin();
			transaction.commit();
			return dbCustomer;
		}
		return null;	
	}
	
	public Customer findById(int id)
	{
		return entityManager.find(Customer.class,id);
	}
	
	public Customer verify(long phone,String password)
	{
		Query q=entityManager.createQuery("select c from Customer c where c.phone=?1 and c.password=?2");
	    q.setParameter(1, phone);
	    q.setParameter(2, password);
	    try {
	         return (Customer) q.getSingleResult();
	    }
	    catch(NestedRuntimeException e)
	    {
	    	return null;
	    }
	}
	public Customer verify(String email,String password)
	{
		Query q=entityManager.createQuery("select c from Customer c where c.email=?1 and c.password=?2");
	    q.setParameter(1, email);
	    q.setParameter(2, password);
	    try {
	         return (Customer) q.getSingleResult();
	    }
	    catch(NestedRuntimeException e)
	    {
	    	return null;
	    }
	}
	

}

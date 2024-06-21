package org.jsp.customerfoodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.jsp.customerfoodapp.dto.Customer;
import org.jsp.customerfoodapp.dto.FoodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Repository;
@Repository
public class FoodOrderDao {
	@Autowired
	private EntityManager entityManager;
	
	public FoodOrder saveFood(FoodOrder order,int cus_id)
	{
		EntityTransaction t=entityManager.getTransaction();
		Customer cus=entityManager.find(Customer.class, cus_id);
		if(cus!=null)
		{
			cus.getFoodOrder().add(order);
			order.setCustomer(cus);
			entityManager.persist(order);
			t.begin();
			t.commit();
			return order;
		}
		return null;
	}

	public FoodOrder updateOrder(FoodOrder order) {
		EntityTransaction transaction = entityManager.getTransaction();
		FoodOrder dbOrder = entityManager.find(FoodOrder.class, order.getId());
		if (dbOrder != null) {
			dbOrder.setAddress(order.getAddress());
			dbOrder.setCost(order.getCost());
			dbOrder.setFood_item(order.getFood_item());
			transaction.begin();
			transaction.commit();
			return dbOrder;
		}
		return null;
	}
	
	public FoodOrder findById(int id)
	{
		return entityManager.find(FoodOrder.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<FoodOrder> findByCustomerId(int id)
	{
		Query q=entityManager.createQuery("select c.foodOrder from Customer c where c.id=?1");
		q.setParameter(1,id);
        return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<FoodOrder> findByCustomer(long phone,String password)
	{
		Query q=entityManager.createQuery("select c.foodOrder from Customer c where c.phone=?1 and c.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		return q.getResultList();
	}

}

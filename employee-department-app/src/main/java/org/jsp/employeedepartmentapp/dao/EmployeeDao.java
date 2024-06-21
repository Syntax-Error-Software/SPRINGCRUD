package org.jsp.employeedepartmentapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.employeedepartmentapp.dto.Department;
import org.jsp.employeedepartmentapp.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	private EntityManager em;
	
	public Employee saveEmployee(Employee employee,int dept)
	{
		EntityTransaction t=em.getTransaction();
		Department d=em.find(Department.class, dept);
		if(d!=null)
		{
			d.getEmployees().add(employee);
			employee.setDept(d);
			em.persist(employee);
			t.begin();
			t.commit();
			return employee;
		}
		return null;
	}
	public Employee updateEmployee(Employee employee)
	{
		EntityTransaction t=em.getTransaction();
		Employee emp=em.find(Employee.class, employee.getId());
		if(emp!=null)
		{
			emp.setName(employee.getName());
			emp.setDesig(employee.getDesig());
			t.begin();
			t.commit();
			return emp;
		}
		return null;
		
	}
	public Employee findById(int id)
	{
		return em.find(Employee.class, id);
	}
	
	public List<Employee> findByDeptId(int id)
	{
		Query q=em.createQuery("select e.employees from Department e where e.id=?1");
		q.setParameter(1, id);
		return q.getResultList();
	}
	public List<Employee> findByName(String name)
	{
		Query q=em.createQuery("select e from Employee e where e.name=?1");
		q.setParameter(1, name);
		return q.getResultList();
	}

	

}

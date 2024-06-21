package org.jsp.employeedepartmentapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jsp.employeedepartmentapp.dto.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {
	@Autowired
	private EntityManager entityManager;
	
	public Department saveDepartment(Department dept)
	{
		EntityTransaction t=entityManager.getTransaction();
		entityManager.persist(dept);
		t.begin();
		t.commit();
		return dept;
	}
	
	public Department updateDepartment(Department dept)
	{
		EntityTransaction t=entityManager.getTransaction();
		Department dbDepartment=entityManager.find(Department.class, dept.getId());
		if(dbDepartment!=null)
		{
			dbDepartment.setDname(dept.getDname());
			dbDepartment.setDloc(dept.getDloc());
			t.begin();
			t.commit();
			return dbDepartment;
		}
		return null;
	}
	public Department findById(int id)
	{
		return entityManager.find(Department.class, id);
	}

}

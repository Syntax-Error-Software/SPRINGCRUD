package org.jsp.hibernatetemplate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.jsp.hibernatetemplate.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private HibernateTemplate hibernatetemplate;
	@Transactional
	public Merchant saveMerchant(Merchant merchant)
	{
		hibernatetemplate.save(merchant);
		return merchant;
	}
	
	public Merchant findById(int id)
	{
		return hibernatetemplate.get(Merchant.class, id);
	}
	
	@Transactional
	public Merchant updateMerchant(Merchant merchant)
	{
		Merchant dbMerchant=findById(merchant.getId());
		if(dbMerchant!=null)
		{
			dbMerchant.setName(merchant.getName());
			dbMerchant.setEmail(merchant.getEmail());
			dbMerchant.setGst_number(merchant.getGst_number());
			dbMerchant.setPassword(merchant.getPassword());
			dbMerchant.setPhone(merchant.getPhone());
			return dbMerchant;
		}
		return null;
	}
	
	@Transactional
	public boolean delete(int id)
	{
		Merchant m=findById(id);
		if(m!=null)
		{
			hibernatetemplate.delete(m);
			return true;
		}
		return false;
	}
	public List<Merchant> findAll()
	{
		return hibernatetemplate.loadAll(Merchant.class);
		
	}

}

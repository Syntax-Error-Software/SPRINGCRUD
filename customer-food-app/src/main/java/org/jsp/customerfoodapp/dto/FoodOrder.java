package org.jsp.customerfoodapp.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String food_item;
	@Column(nullable = false)
	private double cost;
	@Column(nullable = false,unique = true)
	private String address;
	@CreationTimestamp
	private LocalDateTime orderedTime;
	@UpdateTimestamp
	private LocalDateTime deliveryTime;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFood_item() {
		return food_item;
	}
	public void setFood_item(String food_item) {
		this.food_item = food_item;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDateTime getOrderedTime() {
		return orderedTime;
	}
	public void setOrderedTime(LocalDateTime orderedTime) {
		this.orderedTime = orderedTime;
	}
	public LocalDateTime getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(LocalDateTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "FoodOrder [id=" + id + ", food_item=" + food_item + ", cost=" + cost + ", address=" + address
				+ ", orderedTime=" + orderedTime + ", deliveryTime=" + deliveryTime + "]";
	}
	
	

}

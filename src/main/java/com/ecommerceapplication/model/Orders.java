package com.ecommerceapplication.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId")
	private int orderId;
	@Column(name = "orderingDate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date orderingDate;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> products;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	@JsonIgnore
	private User user;
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderingdate() {
		return orderingDate;
	}

	public void setOrderingdate(Date orderingdate) {
		this.orderingDate = orderingdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Orders(Date orderingdate, User user) {
		super();
		this.orderingDate = orderingdate;
		this.user = user;
	
	}

	public Orders() {
		super();
	}

}

package com.siddhrans.boutique.service.impl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.siddhrans.boutique.dao.OrderDetailsDao;
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.OrderDetails;
import com.siddhrans.boutique.service.OrderDetailsService;
@Service("orderService")
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Autowired
	OrderDetailsDao orderDetailsdao;

	@Override
	public OrderDetails findById(int id) {
		return orderDetailsdao.findById(id);
	}

	@Override
	public void saveOrder(OrderDetails orderDetails) {
		orderDetailsdao.saveOrder(orderDetails);
	}

	@Override
	public List<OrderDetails> findAllOrders() {
		return orderDetailsdao.findAllOrders();
	}

	@Override
	public List<OrderDetails> findByStatus(String status) {
		return orderDetailsdao.findByStatus(status);
	}

	@Override
	public void saveOrUpdateOrderDetails(OrderDetails orderDetails) {
	 orderDetailsdao.saveOrder(orderDetails);		
	}

	@Override
	public List<OrderDetails> findByCustomer(OrderDetails orderDetails) {
		return orderDetailsdao.findByCustomer(orderDetails) ;
	}

}

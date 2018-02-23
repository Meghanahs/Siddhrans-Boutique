package com.siddhrans.boutique.service;
import java.util.List;

import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.OrderDetails;

public interface OrderDetailsService {

	 public OrderDetails findById(int id);	 
	 public void saveOrder(OrderDetails order);
	 public List<OrderDetails> findAllOrders();
	 public List<OrderDetails> findByStatus(String status);
	 public void saveOrUpdateOrderDetails(OrderDetails orderDetails);
	 public List<OrderDetails> findByCustomer(OrderDetails orderDetails);
	 
}

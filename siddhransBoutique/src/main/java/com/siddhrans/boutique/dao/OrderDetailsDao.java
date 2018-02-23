package com.siddhrans.boutique.dao;
import java.util.List;
import com.siddhrans.boutique.model.OrderDetails;

public interface OrderDetailsDao {

	 public OrderDetails findById(int id);	 
	 public void saveOrder(OrderDetails order);
	 public List<OrderDetails> findAllOrders();
	 public List<OrderDetails> findByStatus(String status);
	 public void saveOrUpdateOrderDetails(OrderDetails orderDetails);
	 public List<OrderDetails> findByCustomer(OrderDetails orderDetails);
}

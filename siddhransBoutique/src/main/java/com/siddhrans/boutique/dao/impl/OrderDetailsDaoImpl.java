package com.siddhrans.boutique.dao.impl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.OrderDetailsDao;
import com.siddhrans.boutique.model.Designation;
import com.siddhrans.boutique.model.MeasurementDetails;
import com.siddhrans.boutique.model.OrderDetails;

@Repository("orderDao")
@Transactional
public class OrderDetailsDaoImpl extends AbstractDao<Integer, OrderDetails> implements OrderDetailsDao  {

	@Override
	public OrderDetails findById(int id) {
		OrderDetails orders= getByKey(id);
		return orders;
	}

	@Override
	public void saveOrder(OrderDetails order) {
		persist(order);
		}

	@Override
	public List<OrderDetails> findAllOrders() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<OrderDetails> orders = (List<OrderDetails>) criteria.list();
		return orders;
	}

	@Override
	public List<OrderDetails> findByStatus(String status) {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		criteria.add(Restrictions.eq("status", status));
		List<OrderDetails> orders = (List<OrderDetails>) criteria.list();
		return orders;
	}

	@Override
	public void saveOrUpdateOrderDetails(OrderDetails orderDetails) {
		 saveOrUpdate(orderDetails);		
	}

	@Override
	public List<OrderDetails> findByCustomer(OrderDetails orderDetails) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("orderDetails", orderDetails));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<OrderDetails> orderDetails1 = (List<OrderDetails>) criteria.list();
	/*	for(MeasurementDetails measurementDetails : measurementDetailsList){
				Hibernate.initialize(measurementDetails.getCustomerDetails());
				Hibernate.initialize(measurementDetails.getDressType());
        }*/
		return orderDetails1;
	}
	
}

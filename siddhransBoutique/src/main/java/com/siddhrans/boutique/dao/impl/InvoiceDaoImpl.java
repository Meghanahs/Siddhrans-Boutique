package com.siddhrans.boutique.dao.impl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.InvoiceDao;
import com.siddhrans.boutique.model.OrderDetails;
import com.siddhrans.boutique.model.Invoice;

@Repository("invoiceDao")
@Transactional
public class InvoiceDaoImpl extends AbstractDao<Integer, Invoice> implements InvoiceDao  {

	@Override
	public Invoice findById(int id) {
		Invoice orders= getByKey(id);
		return orders;
	}

	@Override
	public void saveInvoice(Invoice invoice) {
		persist(invoice);
		}

	@Override
	public List<Invoice> findAllInvoice() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Invoice> orders = (List<Invoice>) criteria.list();
		return orders;
	}

/*	@Override
	public List<Invoice> findByCustomer(Invoice Invoice) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("Invoice", Invoice));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Invoice> Invoice1 = (List<Invoice>) criteria.list();
		for(MeasurementDetails measurementDetails : measurementDetailsList){
				Hibernate.initialize(measurementDetails.getOrderDetails());
				Hibernate.initialize(measurementDetails.getDressType());
        }
		return Invoice1;
	}*/

	@Override
	public List<Invoice> findByOrder(OrderDetails orderDetails) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("order", orderDetails));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Invoice> invoice1 = (List<Invoice>) criteria.list();
		return invoice1;
	}

	@Override
	public void saveOrUpdateInvoice(Invoice invoice) {
		saveOrUpdate(invoice);
		
	}

	
}

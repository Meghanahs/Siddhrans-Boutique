package com.siddhrans.boutique.convertor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.service.CustomerDetailsService;


@Component
public class StringToCustomerDetails implements Converter<Object, CustomerDetails>{
 
    static final Logger logger = LoggerFactory.getLogger(StringToCustomerDetails.class);
     
    @Autowired
    CustomerDetailsService customerDetailsService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public CustomerDetails convert(Object element) {
    	if(element instanceof String){
    		Integer id = Integer.parseInt((String)element);
            logger.info("MeasurementDetail ID is: {}",id);
            CustomerDetails customerDetails= customerDetailsService.findByID(id);
            logger.info("CustomerDetails : {}",customerDetails);
            return customerDetails;
    	} else {
    		return (CustomerDetails)element;
    	}
    }    
}

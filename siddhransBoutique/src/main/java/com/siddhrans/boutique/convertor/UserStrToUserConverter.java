package com.siddhrans.boutique.convertor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.siddhrans.boutique.model.Employee;
import com.siddhrans.boutique.service.RegistrationService;


 
/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class UserStrToUserConverter implements Converter<Object, Employee>{
 
    static final Logger logger = LoggerFactory.getLogger(UserStrToUserConverter.class);
     
    @Autowired
    RegistrationService registrationService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Employee convert(Object element) {
    	if(element instanceof String){
    		Integer id = Integer.parseInt((String)element);
            logger.info("User ID is: {}",id);
            Employee employee= registrationService.findById(id);
            logger.info("User Name is : {}",employee.getUserName());
            return employee;
    	} else {
    		return (Employee)element;
    	}
    }    
}
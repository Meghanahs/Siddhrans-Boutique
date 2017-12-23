package com.siddhrans.boutique.convertor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.siddhrans.boutique.model.Designation;
import com.siddhrans.boutique.service.DesignationService;

@Component
public class DesgStrToDesgConverter implements Converter<Object, Designation>{
 
    static final Logger logger = LoggerFactory.getLogger(DesgStrToDesgConverter.class);
     
    @Autowired
    DesignationService designationService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Designation convert(Object element) {
    	if(element instanceof String){
    		Integer id = Integer.parseInt((String)element);
            logger.info("Designation ID is: {}",id);
            Designation designation= designationService.findByID(id);
            logger.info("Designation : {}",designation);
            return designation;
    	} else {
    		return (Designation)element;
    	}
    }    
}

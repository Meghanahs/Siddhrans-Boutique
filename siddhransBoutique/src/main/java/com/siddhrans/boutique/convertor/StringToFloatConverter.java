package com.siddhrans.boutique.convertor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToFloatConverter implements Converter<Object, Float>{
 
    static final Logger logger = LoggerFactory.getLogger(StringToFloatConverter.class);
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Float convert(Object element) {
    	if(element instanceof String){
    		Float amount = Float.parseFloat(element.toString());
    		return amount;
    		
    	} else {
    		return (Float)element;
    	}
    }    
}

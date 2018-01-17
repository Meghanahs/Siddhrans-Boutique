package com.siddhrans.boutique.convertor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.service.DressTypeService;



@Component
public class DressTypeStrToDressTypeConverter implements Converter<Object, DressType>{

	static final Logger logger = LoggerFactory.getLogger(DressTypeStrToDressTypeConverter.class);

	@Autowired
	DressTypeService dressTypeService;

	/**
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public DressType convert(Object element) {
		if(element instanceof String){
			Integer id = Integer.parseInt((String)element);
			logger.info("MeasurementDetail ID is: {}",id);
			DressType dressType= dressTypeService.findById(id);
			logger.info("MeasurementDetail : {}",dressType);
			return dressType;
		} else {
			return (DressType)element;
		}
	}    
}

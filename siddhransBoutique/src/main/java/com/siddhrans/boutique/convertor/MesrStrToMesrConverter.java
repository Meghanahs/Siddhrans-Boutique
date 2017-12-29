package com.siddhrans.boutique.convertor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.siddhrans.boutique.model.MeasurementDetails;
import com.siddhrans.boutique.service.MeasurementDetailsService;


@Component
public class MesrStrToMesrConverter implements Converter<Object, MeasurementDetails>{
 
    static final Logger logger = LoggerFactory.getLogger(MesrStrToMesrConverter.class);
     
    @Autowired
    MeasurementDetailsService measurementDetailsService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public MeasurementDetails convert(Object element) {
    	if(element instanceof String){
    		Integer id = Integer.parseInt((String)element);
            logger.info("MeasurementDetail ID is: {}",id);
            MeasurementDetails measurementDetails= measurementDetailsService.findByID(id);
            logger.info("MeasurementDetail : {}",measurementDetails);
            return measurementDetails;
    	} else {
    		return (MeasurementDetails)element;
    	}
    }    
}

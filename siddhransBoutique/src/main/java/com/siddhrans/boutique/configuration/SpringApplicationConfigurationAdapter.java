package com.siddhrans.boutique.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import com.siddhrans.boutique.convertor.DeptStrToDeptConverter;
import com.siddhrans.boutique.convertor.DesgStrToDesgConverter;
import com.siddhrans.boutique.convertor.DressTypeStrToDressTypeConverter;
import com.siddhrans.boutique.convertor.RoleToUserProfileConverter;
import com.siddhrans.boutique.convertor.StringToCustomerDetails;
import com.siddhrans.boutique.convertor.StringToFloatConverter;
import com.siddhrans.boutique.convertor.UserStrToUserConverter;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.siddhrans.boutique")
public class SpringApplicationConfigurationAdapter extends WebMvcConfigurerAdapter{
	
	@Autowired
	DeptStrToDeptConverter deptStrToDeptConverter;
	
	@Autowired
	DesgStrToDesgConverter desgStrToDesgConverter;
	
	@Autowired
	StringToCustomerDetails stringToCustomerDetails;
	
	@Autowired
	DressTypeStrToDressTypeConverter dressTypeStrToDressTypeConverter;
	
	@Autowired
	StringToFloatConverter stringToFloatConverter;
	
	@Autowired
	UserStrToUserConverter userStrToUserConverter;
	
	@Autowired
	RoleToUserProfileConverter roleToUserProfileConverter;
	
	
	/**
	 * Configure Converter to be used.
	 * In our example, we need a converter to convert string values[Roles] to UserProfiles in newUser.jsp
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(deptStrToDeptConverter);
		registry.addConverter(desgStrToDesgConverter);
		registry.addConverter(stringToCustomerDetails);
		registry.addConverter(dressTypeStrToDressTypeConverter);
		registry.addConverter(stringToFloatConverter);
		registry.addConverter(userStrToUserConverter);
		registry.addConverter(roleToUserProfileConverter);
		
	}
	
	@Bean(name="multipartResolver")
	public StandardServletMultipartResolver resolver(){
		return new StandardServletMultipartResolver();
	}
	/**
	 * Configure ViewResolvers to deliver preferred views.
	 */
	public void configureViewResolvers(ViewResolverRegistry registry) {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}
	
	/**
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	/**
	 * Configure MessageSource to lookup any validation/error message in internationalized property files
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
	/**Optional. It's only required when handling '.' in @PathVariables which otherwise ignore everything after last '.' in @PathVaidables argument.
	 * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present in Spring 4.1.7.
	 * This is a workaround for this issue.
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer matcher) {
		matcher.setUseRegisteredSuffixPatternMatch(true);
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
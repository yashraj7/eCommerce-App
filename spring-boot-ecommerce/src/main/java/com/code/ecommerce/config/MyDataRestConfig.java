package com.code.ecommerce.config;

import org.springframework.context.annotation.Configuration; 
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.code.ecommerce.entity.Product;
import com.code.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT,HttpMethod.DELETE,HttpMethod.POST};
		
		//Disable the HTTP methods for product : PUT,POST,DELETE
		
		config.getExposureConfiguration()
			  .forDomainType(Product.class)
			  .withItemExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedActions))
			  .withCollectionExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedActions));
		
		//Disable the HTTP methods for productCategory : PUT,POST,DELETE
		
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedActions));
		
		}
	}
	

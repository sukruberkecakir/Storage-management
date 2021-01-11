package com.deneme.demo.Service

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class MVCConfig implements WebMvcConfigurer{

	@Override
	void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/403").setViewName("403")
	}
	
	
}

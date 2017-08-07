package com.huajin.monitor;

import javax.management.MalformedObjectNameException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.access.MBeanProxyFactoryBean;

@Configuration
public class JMXBeanConfig {
	

	@Bean
	public MBeanProxyFactoryBean jmxBeanProxy() throws MalformedObjectNameException{
		MBeanProxyFactoryBean beanFactory = new MBeanProxyFactoryBean();
		beanFactory.setObjectName("Tomcat:type=ThreadPool,name=\"http-nio-8334\"");
		beanFactory.setProxyInterface(TomcatThreadPool.class);
		return beanFactory;
	}
}

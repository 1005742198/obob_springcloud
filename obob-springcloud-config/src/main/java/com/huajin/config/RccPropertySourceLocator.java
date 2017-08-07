package com.huajin.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;


/**
 * 支持从 classpath:/rcc/下装载 rcc 配置文件。
 * <p>支持 rcc.properties 和 rcc.yml 两种形式的配置文件。
 * <p>rcc配置文件是指部署平台在每次部署时不会替换的文件。
 * 
 * @author bo.yang
 */
@Configuration
public class RccPropertySourceLocator implements PropertySourceLocator {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public PropertySource<?> locate(Environment environment) {
		String sourceName = "RCC Property Source";
		try {
			ClassPathResource propertyResource = new ClassPathResource("/rcc/rcc.properties");
			ClassPathResource yamlResource = new ClassPathResource("/rcc/rcc.yml");
			if (yamlResource.exists()) {
				log.info("Load RCC properties from YAML file {}", yamlResource.getURL());
				YamlPropertySourceLoader sourceLoader = new YamlPropertySourceLoader();
				String profile = null;	// 我们不需要根据 profile 装载配置
				return sourceLoader.load(sourceName, yamlResource, profile);
			}
			if (propertyResource.exists()) {
				EncodedResource encodedResource = new EncodedResource(propertyResource, "UTF-8");
				log.info("Load RCC properties from {}", propertyResource.getURL());
				return new ResourcePropertySource(sourceName, encodedResource);
			}
			return null;
		} catch (IOException e) {
			log.error("Can not load RCC properties!");
			return null;
		}
	}

}

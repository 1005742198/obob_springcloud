# 支持 rcc/ 部署目录的 springcloud 扩展

# 使用方法

1. 添加依赖

	compile ('com.huajin.springcloud:huajin-springcloud-config:0.0.1-RELEASE')

2. 在 rcc/ 目录下添加配置文件 'rcc.yml' 或者 'rcc.properties'，系统会优先选择 yml 文件，如果找不到才会去找 properties文件。

完成

# 实现方法说明

参考spring cloud文档[定制 bootstrap property source](http://cloud.spring.io/spring-cloud-static/Dalston.RELEASE/#customizing-bootstrap-property-sources)

a. 添加 /META-INF/spring.factories

Use a separate package name for boot configuration classes that is not already covered by your @ComponentScan or @SpringBootApplication annotated configuration classes.

内容是：

	org.springframework.cloud.bootstrap.BootstrapConfiguration=com.huajin.config.RccPropertySourceLocator


b. 提供一个 class，adding beans of type PropertySourceLocator

     public class RccPropertySourceLocator implements PropertySourceLocator

# 发布项目的RELEASE版本

1. 修改 build.gradle 中的 version 变量，如下：

	version = '0.0.1-RELEASE'
	
2. 执行 gradle 命令

确保 nexus.cfaoe.com 指向正式环境的 nexus 服务器 172.16.17.18，然后执行命令：

	gradle upload -P uploadRelease
	
3. 完毕

# 发布项目的 SNAPSHOT 版本

1. 修改 build.gradle 中的 version 变量，如下：

	version = '0.0.1-SNAPSHOT'
	
2. 执行 gradle 命令

	gradle upload
	
3. 完毕


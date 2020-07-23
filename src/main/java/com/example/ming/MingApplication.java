package com.example.ming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * https://blog.csdn.net/maple_fix/article/details/79884320
 * https://www.cnblogs.com/xibei666/p/8970549.html
 * https://www.cnblogs.com/lichmama/p/8728262.html
 * 
 * <artifactId>spring-boot-starter-parent</artifactId><version>2.0.6.RELEASE</version>
 * <artifactId>cxf-spring-boot-starter-jaxws</artifactId><version>3.2.6</version>
 * parent版本是2.0.4，同时jaxws版本是3.2.6时；
 * parent版本是2.0.5，同时jaxws版本是3.2.6时；
 * parent版本是2.0.6，同时jaxws版本是3.2.6时；
 * parent版本是2.1.0，同时jaxws版本是3.2.6时；
 * parent版本是2.0.6，同时jaxws版本是3.1.11时；
 * 会出现以下错误：
 * 
 * Description:
 * Parameter 1 of constructor in org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration required a bean of type 'org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath' that could not be found.
 * The following candidates were found but could not be injected:
 *   - Bean method 'dispatcherServletRegistration' in 'DispatcherServletAutoConfiguration.DispatcherServletRegistrationConfiguration' not loaded because DispatcherServlet Registration found non dispatcher servlet dispatcherServlet
 *  Action:
 *  Consider revisiting the entries above or defining a bean of type 'org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath' in your configuration.
 *  当parent版本是1.4.5，同时jaxws版本是3.1.7时；
 *  parent版本是1.4.5，同时jaxws版本是3.1.11时；
 *  parent版本是1.5.6，同时jaxws版本是3.1.11时；
 *  parent版本是1.5.8，同时jaxws版本是3.1.12时；
 *  parent版本是1.5.9，同时jaxws版本是3.1.11时；
 *  parent版本是1.5.9，同时jaxws版本是3.1.12时；
 *  parent版本是2.0.3，同时jaxws版本是3.2.6时；
 *  parent版本是2.1.2，同时jaxws版本是3.2.6时；
 *  则运行正常。
 */
@SpringBootApplication
public class MingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MingApplication.class, args);
	}

}

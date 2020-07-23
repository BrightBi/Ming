package com.example.ming.config;

import com.example.ming.i.BookService;
import com.example.ming.i.UserService;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * 127.0.0.1或者localhost不能访问时，请使用 ipconfig 查看本机 ip 来访问。
 * 
 * http://127.0.0.1:8080/services/ 可以查看详情
 * http://127.0.0.1:8080/bi/ 也可以查看详情
 * 
 * http://127.0.0.1:8080/bi/user?wsdl
 * http://127.0.0.1:8080/bi/book?wsdl
 * 
 * 默认端口 8080。默认路径是 /services 。
 * 也可以通过在 application.yml 中配置端口和路径
 * server:
 *   port: 8090
 * cxf:
 *   path: /bi
 */
@Configuration
public class SoapV1Config {
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;

	/*
	 * 设置 name = Bus.DEFAULT_BUS_ID 以后访问 http://127.0.0.1:8080/services/
	 * 就可以看到 soap 提供的 wsdl 链接，以及提供的方法。 如果不设置，就看不到 soap 对外提供的相关服务信息。
	 * SoapV1Config SoapV2Config 都设置，就都显示。
	 * 但对于有的 spring boot 版本都设置的话由于 bean id 是一样的，会报错。
	 * 所以最好还是在 ServletRegistrationBean 中设置路径，然后通过 ServletRegistrationBean 设置的路径来看 soap 提供的 wsdl 链接，以及提供的方法。
	 */
	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBusV1() {
		SpringBus bus = new SpringBus();
		bus.setId("v1");
		return bus;
	}

	// 方法名以及 setName 不要用 dispatcherServlet 否则会把默认映射覆盖掉。以至于控制类方法无法访问。
	@Bean
	public ServletRegistrationBean<CXFServlet> v1Servlet() {
		CXFServlet cxfServlet = new CXFServlet();
		cxfServlet.setBus(springBusV1());
		/*
		 * map 可设置也可以不设置，设置后的路径：http://127.0.0.1:8080/bi 不设置的路径：http://127.0.0.1:8080/
		 * 也可以通过在 application.yml 中配置 
		 * cxf:
		 *   path: /bi
		 * 注意观察启动时候控制台输出：
		 * Servlet v1Servlet mapped to [/bi/*]
		 * Servlet v2Servlet mapped to [/ming/*]
		 * Servlet dispatcherServlet mapped to [/]
		 * Servlet CXFServlet mapped to [/services/*]
		 * ...
		 * 直接访问 http://127.0.0.1:8080/bi/ 就可以看到 soap 提供的 wsdl 链接，以及提供的方法。
		 */
		ServletRegistrationBean<CXFServlet> servletBean = new ServletRegistrationBean<>(cxfServlet, "/bi/*");
		servletBean.setName("v1Servlet");
		return servletBean;
	}

	@Bean
	public Endpoint userServiceEndpoint() {

		EndpointImpl endpoint = new EndpointImpl(springBusV1(), userService);
		/*
		 * publish 可设置也可以不设置， 设置后的路径：http://127.0.0.1:8080/bi/user
		 * 不设置的路径：http://127.0.0.1:8080/bi/
		 */
		endpoint.publish("/user");
		return endpoint;
	}

	@Bean
	public Endpoint bookServiceEndpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBusV1(), bookService);
		/*
		 * publish 可设置也可以不设置， 设置后的路径：http://127.0.0.1:8080/bi/book
		 * 不设置的路径：http://127.0.0.1:8080/bi/
		 */
		endpoint.publish("/book");
		return endpoint;
	}
}

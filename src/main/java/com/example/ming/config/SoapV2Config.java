package com.example.ming.config;

import com.example.ming.i.StudentService;

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
 * http://127.0.0.1:8080/ming/ 可以查看详情
 * http://127.0.0.1:8080/ming/student?wsdl
 */
@Configuration
public class SoapV2Config {
	@Autowired
	StudentService studentService;

	@Bean
	public SpringBus springBusV2() {
		SpringBus bus = new SpringBus();
		bus.setId("v2");
		return bus;
	}

	@Bean
	public ServletRegistrationBean<CXFServlet> v2Servlet() {
		CXFServlet cxfServlet = new CXFServlet();
		cxfServlet.setBus(springBusV2());

		ServletRegistrationBean<CXFServlet> servletBean = new ServletRegistrationBean<>(cxfServlet, "/ming/*");
		servletBean.setName("v2Servlet");
		return servletBean;
	}

	@Bean
	public Endpoint studentServiceEndpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBusV2(), studentService);
		endpoint.publish("/student");
		return endpoint;
	}

}

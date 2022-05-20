package com.tanja.controller;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.core.ApplicationContext;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.tanja.web_customer_tracker.model.customer.Customer;
import com.tanja.web_customer_tracker.model.customer.CustomerDetails;
import com.tanja.web_customer_tracker.model.customer.GenderEnum;
import com.tanja.web_customer_tracker.service.customer.CustomerService;


@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@Transactional
public class CustomerControllerTest {

	@Mock
	private CustomerService customerServiceMock;
	
	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;
	
	@BeforeEach
	public void setup() {
		customerServiceMock = Mockito.mock(CustomerService.class);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void getAllCustomersHttpRequest() throws Exception {
		CustomerDetails cd = new CustomerDetails("bla street", new Date(System.currentTimeMillis()), GenderEnum.MALE, null);
		Customer customer = new Customer("Bla", "Blabic", "bla@gmail.com", cd);
		Customer customer2 = new Customer("BlBlaBla", "Blabovic", "lblblb@gmail.com", cd);
		
		List<Customer> customers = new ArrayList<>(Arrays.asList(customer, customer2));
		
		when(customerServiceMock.getAllCustomers()).thenReturn(customers);
		
		assertIterableEquals(customers, customerServiceMock.getAllCustomers());
		
		MvcResult mvcRes =  mockMvc
			.perform(get("/customer/list"))
			.andExpect(status().isOk())
			.andReturn();
		
		ModelAndView mav = mvcRes.getModelAndView();
		
		ModelAndViewAssert.assertViewName(mav, "customer-list");
	}
	
	@Test
	public void getCustomerByIdHttpRequest() throws Exception {
		
		CustomerDetails cd = new CustomerDetails("bla street", new Date(System.currentTimeMillis()), GenderEnum.MALE, null);
		Customer customer = new Customer("Bla", "Blabic", "bla@gmail.com", cd);
		customer.setId(1);
		
		when(customerServiceMock.getCustomerById(1)).thenReturn(customer);
		
		assertNotNull(customerServiceMock.getCustomerById(1));
		
		MvcResult mvcRes = mockMvc
				.perform(get("/customer/details").param("customerId", "1"))
				.andExpect(status().isOk())
				.andReturn();
		
		ModelAndView mav = mvcRes.getModelAndView();
		
		ModelAndViewAssert.assertViewName(mav, "customer-details");
		
	}
	
	@Test
	public void getCustomerByIdErrorHttpRequest() throws Exception {

		assertNull(customerServiceMock.getCustomerById(0));
		
	}
	
//	@Test
//	public void addNewCustomerHttpRequest() throws Exception {
//		CustomerDetails cd = new CustomerDetails("bla street", new Date(System.currentTimeMillis()), GenderEnum.MALE, null);
//		Customer customer = new Customer("Bla", "Blabic", "bla@gmail.com", cd);
//		
//        ClassLoader classLoader = this.getClass().getClassLoader();
//        FileInputStream file = new FileInputStream(classLoader.getResource("test.jpg").getFile());
//		MockMultipartFile mockFile = new MockMultipartFile("test.jpg", file);
//		
//		MvcResult mvcRes = mockMvc
//				.perform(multipart("/customer/addCustomer")
//						.file(mockFile)
//						.flashAttr("customer", customer))
//				.andExpect(status().isOk())
//				.andReturn();
//		
//		ModelAndView mav = mvcRes.getModelAndView();
//		
//		ModelAndViewAssert.assertViewName(mav, "customer-list");
//	}
}

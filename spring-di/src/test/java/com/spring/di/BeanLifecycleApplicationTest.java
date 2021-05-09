package com.spring.di;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.lifecycle.TestSpringBean;

public class BeanLifecycleApplicationTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	  @Autowired
	  public TestSpringBean testSpringBean;

	  @Test
	  public void testMySpringBeanLifecycle() {
	    String message = "Hello World";
	    testSpringBean.sendMessage(message);
	    assertThat(testSpringBean.getMessage()).isEqualTo(message);
	  }

}

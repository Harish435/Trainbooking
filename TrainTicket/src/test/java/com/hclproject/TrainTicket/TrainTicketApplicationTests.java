package com.hclproject.TrainTicket;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hclproject.TrainTicket.Controller.HomeController;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


//@RunWith(SpringRunner.class)
@SpringBootTest
class TrainTicketApplicationTests {

Cal c=new Cal();


	@Test
	public void itshouldgetres() {
		//assertThat(controller).isNotNull();
		int nu1=10;
		int nu2=20;

		int res = c.add(nu1, nu2);

		int expected = 30;
		assertThat(res).isEqualTo(expected);

	}

	class Cal{
		int add(int a,int b){
			return a+b;
		}
	}


}

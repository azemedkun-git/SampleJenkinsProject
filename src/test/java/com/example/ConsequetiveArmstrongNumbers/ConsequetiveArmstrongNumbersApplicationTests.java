package com.example.ConsequetiveArmstrongNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ConsequetiveArmstrongNumbersApplicationTests {
	@Autowired
	private ArmstrongController controller;
	@Test
	void return_false_if_list_is_empty() {
		ResponseEntity<?> response = controller.consequetiveArmstrongNumber(new ArrayList<>());
		Assertions.assertEquals(400, response.getStatusCodeValue());
	}
	@Test
	void returns_true_and_armstrongNumbers(){
		List<Integer> listOfNumbers = Arrays.asList(2, 1, 371, 153, 4, 370);
		ResponseEntity<?> response = controller.consequetiveArmstrongNumber(listOfNumbers);
		Assertions.assertEquals(200, response.getStatusCodeValue());
	}
}

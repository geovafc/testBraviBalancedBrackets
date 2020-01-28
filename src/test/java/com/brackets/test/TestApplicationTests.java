package com.brackets.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TestApplicationTests {

	CheckBrackets application;


	@Test
	void contextLoads() {
	}

	@Test
	void testCheckIfbracketsIsValid1() {
		String bracketValid = "{{[({[()]})]}}";

		application = new CheckBrackets();
		assertEquals(bracketValid+" is valid", application.checkIfbracketsIsValid(bracketValid));

	}

	@Test
	void testCheckIfbracketsIsValid2() {
		String bracketValid = "(){}[]";

		application = new CheckBrackets();
		assertEquals(bracketValid+" is valid", application.checkIfbracketsIsValid(bracketValid));

	}

	@Test
	void testCheckIfbracketsIsValid3() {
		String bracketValid = "[{()}](){}";

		application = new CheckBrackets();
		assertEquals(bracketValid+" is valid", application.checkIfbracketsIsValid(bracketValid));

	}

	@Test
	void testCheckIfbracketsIsNotValid1() {
		String bracketInvalid = "{)";

		application = new CheckBrackets();
		assertEquals(bracketInvalid+" is not valid", application.checkIfbracketsIsValid(bracketInvalid));

	}

	@Test
	void testCheckIfbracketsIsNotValid2() {
		String bracketInvalid = "[]{()";

		application = new CheckBrackets();
		assertEquals(bracketInvalid+" is not valid", application.checkIfbracketsIsValid(bracketInvalid));

	}

	@Test
	void testCheckIfbracketsIsNotValid3() {
		String bracketInvalid = "[{)]";

		application = new CheckBrackets();
		assertEquals(bracketInvalid+" is not valid", application.checkIfbracketsIsValid(bracketInvalid));

	}

	@Test
	void testCheckIfbracketsIsWithDigitNotValid1() {
		String bracketWithDigitInvalid = "[{a}]";

		application = new CheckBrackets();
		assertEquals(bracketWithDigitInvalid+" is not valid", application.checkIfbracketsIsValid(bracketWithDigitInvalid));

	}

	@Test
	void testCheckIfbracketsIsIncompleted() {
		String bracketIncompleted = "[{";

		application = new CheckBrackets();
		assertEquals(bracketIncompleted+" is not valid", application.checkIfbracketsIsValid(bracketIncompleted));

	}

	@Test
	void testCheckIfDigitIsEmpty() {
		String bracketIncompleted = "";

		application = new CheckBrackets();
		assertEquals(bracketIncompleted+" is not valid", application.checkIfbracketsIsValid(bracketIncompleted));

	}

}

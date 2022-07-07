package com.okta.developer.matrixapi;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MatrixapiApplicationTests {

	@Test
	void contextLoads() {

		ArrayList mock 	= Mockito.mock(ArrayList.class);
		ArrayList spy =	 Mockito.spy(ArrayList.class);
		ArrayList spy1 = Mockito.spy(new ArrayList<>());

		mock.add("one");
		spy.add("one");
		spy1.add("one");

		Mockito.verify(mock).add("one");
		Mockito.verify(spy).add("one");
		Mockito.verify(spy1).add("one");

		assertEquals(mock.size(),0); //Adding an element in a mocked list doesn't actually add anything.It just calls method with no side effects.
		assertEquals(spy.size(),1);//Calls real implementation and hence actually adds.
		assertEquals(spy.size(),1);


	}

}

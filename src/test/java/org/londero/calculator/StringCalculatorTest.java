package org.londero.calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator calc = new StringCalculator();

	@Test
	public void returns0ForEmptyString() {
		assertThat(calc.add(""), is(equalTo(0)));
	}
	
	@Test
	public void returnsTheSingleNumberProvided() {
		assertThat(calc.add("4"), is(equalTo(4)));
	}
	
	@Test
	public void returnsTheSumOfAnyNumbersProvided() {
		assertThat(calc.add("2,3,98"), is(equalTo(103)));
	}
	
	@Test
	public void handleNewLinesBetweenNumbers() {
		assertThat(calc.add("5\n2,8"), is(equalTo(15)));
	}
}

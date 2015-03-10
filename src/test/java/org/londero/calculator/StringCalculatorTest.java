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
}

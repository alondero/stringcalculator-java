package org.londero.calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void returns0ForEmptyString() {
		StringCalculator calc = new StringCalculator();
		assertThat(calc.add(""), is(equalTo(0)));
	}
	
}

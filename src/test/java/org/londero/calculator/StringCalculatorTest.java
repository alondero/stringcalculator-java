package org.londero.calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

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
	
	@Test
	public void supportsExplicitDelimiters() {
		assertThat(calc.add("//b\n5b6"), is(equalTo(11)));
	}
	
	@Test(expected=NegativeNumberException.class)
	public void throwsExceptionWithNegativeNumbers() {
		calc.add("-1");
	}
	
	@Test // Strictly speaking, this is not a unit test
	public void negativeExceptionContainsAllNegativeNumbers() {
		try {
			calc.add("-3,-6,1");
			fail("Negative Number Exception should have been thrown");
		} catch (NegativeNumberException e) {
			assertThat(e.getMessage(), both(containsString("-3")).and(containsString("-6")));
		}
	}
	
	@Test
	public void ignoresNumbersGreaterThan1000() {
		assertThat(calc.add("42,1337"), is(equalTo(42)));
	}
	
	@Test
	public void handlesAnyLengthExplicitDelimiter() {
		assertThat(calc.add("//[potato]\n1potato2potato3potato4"), is(equalTo(10)));
	}
	
	@Test
	public void handlesMultipleExplicitDelimiters() {
		assertThat(calc.add("//[blue][red]\n1blue2red6"), is(equalTo(9)));
	}
}

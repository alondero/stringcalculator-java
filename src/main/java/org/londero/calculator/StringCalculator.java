package org.londero.calculator;


public class StringCalculator {

	public Integer add(String input) {
		if (input.equals("")) {
			return 0;
		}
		
		return Integer.valueOf(input);
	}

}

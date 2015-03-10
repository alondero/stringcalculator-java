package org.londero.calculator;

import static java.util.Arrays.stream;


public class StringCalculator {

	public Integer add(String input) {
		if (input.equals("")) {
			return 0;
		}
		
		return stream(input.split("\n|,"))
			.mapToInt(Integer::parseInt)
			.sum();
	}

}

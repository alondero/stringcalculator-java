package org.londero.calculator;

import static java.util.Arrays.stream;


public class StringCalculator {

	private static final String EXPLICIT_DELIMITER_FLAG = "//";
	private static final String DEFAULT_DELIMITERS = "\n|,";

	public Integer add(String input) {
		if (input.equals("")) {
			return 0;
		}

		String delimiter = DEFAULT_DELIMITERS;
		
		if (input.startsWith(EXPLICIT_DELIMITER_FLAG)) {
			delimiter = input.substring(EXPLICIT_DELIMITER_FLAG.length(), input.indexOf("\n"));
			input = input.substring(input.indexOf("\n")+1);
		}
		
		return stream(input.split(delimiter))
			.mapToInt(Integer::parseInt)
			.peek(this::checkNegative)
			.sum();
	}

	private void checkNegative(int test) {
		if (test < 0) {
			throw new NegativeNumberException();
		}
	}
}

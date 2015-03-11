package org.londero.calculator;

import static java.util.stream.Collectors.joining;

import java.util.List;

public class NegativeNumberException extends RuntimeException {

	private static final String NUMBER_DELIMITER = ", ";
	private static final String EXCEPTION_MESSAGE_PREFIX = "Negative numbers found: ";

	public NegativeNumberException(List<Integer> negatives) {
		super(negatives.stream()
			.map(String::valueOf)
			.collect(joining(NUMBER_DELIMITER, EXCEPTION_MESSAGE_PREFIX, "."))
			.toString());
	}

}

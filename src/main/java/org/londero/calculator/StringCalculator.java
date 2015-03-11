package org.londero.calculator;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.partitioningBy;
import static org.apache.commons.lang3.StringUtils.split;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class StringCalculator {

	private static final boolean POSITIVE = true;
	private static final boolean NEGATIVE = false;
	private static final String EXPLICIT_DELIMITER_FLAG = "//";
	private static final String DEFAULT_DELIMITERS = "\n|,";

	public Integer add(String input) {
		Map<Boolean, List<Integer>> valuesByPositivity = findTokens(input)
			.map(Integer::valueOf)
			.collect(partitioningBy(x -> x >= 0));
		
		if (!valuesByPositivity.get(NEGATIVE).isEmpty()) {
			throw new NegativeNumberException(valuesByPositivity.get(false));
		}
		
		return valuesByPositivity.get(POSITIVE).stream()
			.mapToInt(Integer::intValue)
			.filter(x -> x <= 1000)
			.sum();
	}

	private Stream<String> findTokens(String input) {
		String delimiter = DEFAULT_DELIMITERS;

		if (input.startsWith(EXPLICIT_DELIMITER_FLAG)) {
			delimiter = input.substring(EXPLICIT_DELIMITER_FLAG.length(), input.indexOf("\n"));
			input = input.substring(input.indexOf("\n")+1);
		}
		
		return stream(split(input, delimiter));
	}
}

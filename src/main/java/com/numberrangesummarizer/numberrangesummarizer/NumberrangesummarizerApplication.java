package com.numberrangesummarizer.numberrangesummarizer;

import com.numberrangesummarizer.numberrangesummarizer.solution.NumberRangeSummarizer;
import com.numberrangesummarizer.numberrangesummarizer.solution.NumberRangeSummarizerImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;

@SpringBootApplication
public class NumberrangesummarizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumberrangesummarizerApplication.class, args);
		System.out.println("Running");

		NumberRangeSummarizer test = new NumberRangeSummarizerImplementation();

		String input = "-1, 0, 1,3,6,7,8,12,13,14,15,21,22,23,24,31";
		Collection<Integer> sortedNumbers = test.collect(input);
		String result = test.summarizeCollection(sortedNumbers);
		System.out.println(result);
	}

}

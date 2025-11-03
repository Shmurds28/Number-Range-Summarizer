package com.numberrangesummarizer.numberrangesummarizer.solution;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImplementation implements NumberRangeSummarizer{
    @Override
    public Collection<Integer> collect(String input) {
        if (input == null || input.trim().isEmpty()) {
            return List.of();
        }

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(this::isNumeric)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean isNumeric(String s) {
        if (s == null || s.isEmpty()) return false;
        int start = s.charAt(0) == '-' ? 1 : 0;
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        input = input.stream().sorted().distinct().collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        Iterator<Integer> iterator = input.iterator();

        int start = iterator.next();
        int prev = start;

        while (iterator.hasNext()) {
            int current = iterator.next();
            if (current == prev + 1) {
                // Still sequential
                prev = current;
            } else {
                // Sequence ended
                appendRange(result, start, prev);
                start = prev = current;
            }
        }

        // Append last sequence
        appendRange(result, start, prev);

        return result.toString();
    }

    private void appendRange(StringBuilder sb, int start, int end) {
        if (!sb.isEmpty()) {
            sb.append(", ");
        }
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start).append("-").append(end);
        }
    }
}

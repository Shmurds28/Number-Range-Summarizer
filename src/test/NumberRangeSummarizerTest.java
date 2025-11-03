package test;

import com.numberrangesummarizer.numberrangesummarizer.solution.NumberRangeSummarizer;
import com.numberrangesummarizer.numberrangesummarizer.solution.NumberRangeSummarizerImplementation;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NumberRangeSummarizerTest {
    NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImplementation();

    @Test
    public void collect_EmptyStringTest() {
        var input = "";
        var actual = numberRangeSummarizer.collect(input);
        Collection<Integer> expected = List.of();


        assertEquals("empty string should return empty collection", actual, expected);
    }

    @Test
    public void collect_NullInputTest() {
        var actual = numberRangeSummarizer.collect(null);
        Collection<Integer> expected = List.of();

        assertEquals("null should return empty collection", actual, expected);
    }

    @Test
    public void collect_SingleNumberTest() {
        Collection<Integer> actual = numberRangeSummarizer.collect("42");
        Collection<Integer> expected = List.of(42);
        assertEquals("Single number input should return collection with one item", expected, actual);
    }

    @Test
    public void collect_MultipleNumbersTest() {
        Collection<Integer> actual = numberRangeSummarizer.collect("1, 2,3 ,4");
        Collection<Integer> expected = List.of(1, 2, 3, 4);
        assertEquals("Multiple numbers should be returned correctly", expected, actual);
    }

    @Test
    public void collect_WithSpacesAndInvalidTest() {
        Collection<Integer> actual = numberRangeSummarizer.collect(" 1 , abc , 2 , -5 , xyz , 3 ");
        Collection<Integer> expected = List.of(1, 2, -5, 3);
        assertEquals("Input with spaces and non numeric values should ignore invalid entries", expected, actual);
    }

    @Test
    public void collect_AllInvalidTest() {
        Collection<Integer> actual = numberRangeSummarizer.collect("a,b,c,!,#");
        Collection<Integer> expected = List.of();
        assertEquals("Input with only invalid entries should return empty collection", expected, actual);
    }

    @Test
    public void collect_NegativeNumbersTest() {
        Collection<Integer> actual = numberRangeSummarizer.collect("-1, -2, 3");
        Collection<Integer> expected = List.of(-1, -2, 3);
        assertEquals("Negative numbers should be parsed correctly", expected, actual);
    }

    /// summarizeCollection TESTS
    @Test
    public void summarizeCollection_EmptyCollectionTest() {
        Collection<Integer> input = List.of();
        String actual = numberRangeSummarizer.summarizeCollection(input);
        String expected = "";
        assertEquals("Empty collection should return empty string", expected, actual);
    }

    @Test
    public void summarizeCollection_NullCollectionTest() {
        String actual = numberRangeSummarizer.summarizeCollection(null);
        String expected = "";
        assertEquals("Null collection should return empty string", expected, actual);
    }

    @Test
    public void summarizeCollection_SingleNumberTest() {
        Collection<Integer> input = List.of(5);
        String actual = numberRangeSummarizer.summarizeCollection(input);
        String expected = "5";
        assertEquals("Single number should return itself", expected, actual);
    }

    @Test
    public void summarizeCollection_NoSequentialNumbersTest() {
        Collection<Integer> input = List.of(1, 3, 5, 7);
        String actual = numberRangeSummarizer.summarizeCollection(input);
        String expected = "1, 3, 5, 7";
        assertEquals("Non sequential numbers should be separated by commas", expected, actual);
    }

    @Test
    public void summarizeCollection_AllSequentialNumbersTest() {
        Collection<Integer> input = List.of(1, 2, 3, 4, 5);
        String actual = numberRangeSummarizer.summarizeCollection(input);
        String expected = "1-5";
        assertEquals("All sequential numbers should be grouped", expected, actual);
    }

    @Test
    public void summarizeCollection_ExampleInputTest() {
        Collection<Integer> input = List.of(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String actual = numberRangeSummarizer.summarizeCollection(input);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        assertEquals("Mixed sequences and single numbers should be summarized correctly", expected, actual);
    }

    @Test
    public void summarizeCollection_NegativeNumbersTest() {
        Collection<Integer> input = Arrays.asList(-3, -2, -1, 0, 2, 3);
        String actual = numberRangeSummarizer.summarizeCollection(input);
        String expected = "-3-0, 2-3";
        assertEquals("Negative and positive sequences should be summarized correctly", expected, actual);
    }

    @Test
    public void summarizeCollection_SingleGapsTest() {
        Collection<Integer> input = Arrays.asList(1, 2, 4, 5, 7);
        String actual = numberRangeSummarizer.summarizeCollection(input);
        String expected = "1-2, 4-5, 7";
        assertEquals("Gaps between sequences should be handled correctly", expected, actual);
    }

    @Test
    public void summarizeCollection_NonSortedTest() {
        Collection<Integer> input = Arrays.asList(3, 1, 2, 5, 4, 9, 7);
        String actual = numberRangeSummarizer.summarizeCollection(input);
        String expected = "1-5, 7, 9";
        assertEquals("Non-sorted input should be sorted first then summarized after", expected, actual);
    }

    @Test
    public void summarizeCollection_DuplicateNumbersTest() {
        Collection<Integer> input = List.of(1, 1, 2, 2, 3, 4, 5, 8, 9, 10, 23, 80);
        String actual = numberRangeSummarizer.summarizeCollection(input);
        String expected = "1-5, 8-10, 23, 80";
        assertEquals("Duplicates should be handled correctly ", expected, actual);
    }

}

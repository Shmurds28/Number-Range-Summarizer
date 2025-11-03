# Number Range Summarizer

## **Task**
Implement the NumberRangeSummarizer Interface and override the methods to produce a comma delimited list of numbers, grouping the numbers into a range when they are sequential.

## **Features**
- Parses a comma delimited string of numbers into a collection of integers.
- Ignores invalid entries (non numeric strings).
- Supports negative numbers.
- Summarizes sequential numbers into ranges (e.g., 1,2,3,5 → 1-3, 5).
- Handles unsorted input by sorting numbers before summarization.
- Removes duplicates to ensure clean ranges.
- Unit tests covering edge cases and testing functionality.

## **Requirements**
- Java 8 or higher
- JUnit for unit testing
- Maven


## **Implementation Notes**
- collect(String input):
  Parses the input string into a list of integers, trimming spaces and filtering out invalid entries.

- summarizeCollection(Collection<Integer> input):
    - Sorts the list in ascending order.
    - Removes duplicates.
    - Groups sequential numbers into ranges.

- appendRange(StringBuilder sb, int start, int end):
  Formats individual numbers or ranges for the output string.


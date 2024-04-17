## DateSorter

This class is designed to sort a list of dates and group them based on the presence of the letter 'r' in the month name. Dates with 'r' in the month are sorted in ascending order, while dates without 'r' are sorted in descending order.

### Methods

#### `sortDates(List<LocalDate> unsortedDates)`

Takes an unsorted list of dates as input and returns a sorted list of dates according to the specified order.
#### `containsR(LocalDate date)`

This method checks whether the month name of a given `LocalDate` object contains the letter 'r' (case-insensitive).

## Method Signature

```java
private boolean containsR(LocalDate date)
### Usage

Example of using the `DateSorter` class:

```java
List<LocalDate> unsortedDates = new ArrayList<>();
unsortedDates.add(LocalDate.of(2004, 7, 1));
unsortedDates.add(LocalDate.of(2005, 1, 2));
unsortedDates.add(LocalDate.of(2007, 1, 1));
unsortedDates.add(LocalDate.of(2032, 5, 3));

DateSorter sorter = new DateSorter();
List<LocalDate> sortedDates = sorter.sortDates(unsortedDates);

System.out.println("Sorted dates:");
for (LocalDate date : sortedDates) {
    System.out.println(date);
}
```

### Dependencies
None.

### Author

Author: Stanislav Donetc

---


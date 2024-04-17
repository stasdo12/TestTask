package test.java;

import main.java.com.sorter.DateSorter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DateSorterTest {
    DateSorter sorter = new DateSorter();

    @Test
    void testSortDatesWithNullList() {
        List<LocalDate> sortedDates = sorter.sortDates(null);
        assertEquals(0, sortedDates.size());
    }

    @Test
    void testSortDatesWithEmptyList() {
        List<LocalDate> unsortedDates = new ArrayList<>();
        List<LocalDate> sortedDates = sorter.sortDates(unsortedDates);
        assertEquals(0, sortedDates.size());
    }

    @Test
    void testSortDates() {
        List<LocalDate> unsortedDates = new ArrayList<>();
        unsortedDates.add(LocalDate.of(2004, 7, 1));
        unsortedDates.add(LocalDate.of(2005, 1, 2));
        unsortedDates.add(LocalDate.of(2007, 1, 1));
        unsortedDates.add(LocalDate.of(2032, 5, 3));

        List<LocalDate> expectedSortedDates = new ArrayList<>();
        expectedSortedDates.add(LocalDate.of(2005, 1, 2));
        expectedSortedDates.add(LocalDate.of(2007, 1, 1));
        expectedSortedDates.add(LocalDate.of(2032, 5, 3));
        expectedSortedDates.add(LocalDate.of(2004, 7, 1));

        List<LocalDate> sortedDates = sorter.sortDates(unsortedDates);
        assertEquals(expectedSortedDates, sortedDates);
    }
}

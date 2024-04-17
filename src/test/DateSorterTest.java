package test;

import main.java.com.sorter.DateSorter;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DateSorterTest {

    @Test
    void testSortDatesWithNullList() {
        DateSorter sorter = new DateSorter();
        assertThrows(IllegalArgumentException.class, () -> sorter.sortDates(null));
    }

    @Test
    void testSortDatesWithEmptyList() {
        DateSorter sorter = new DateSorter();
        List<LocalDate> unsortedDates = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> {
            sorter.sortDates(unsortedDates);
        });
    }

    @Test
    void testSortDates() {
        DateSorter sorter = new DateSorter();
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

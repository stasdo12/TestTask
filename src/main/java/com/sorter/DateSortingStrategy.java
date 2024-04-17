package main.java.com.sorter;

import java.time.LocalDate;
import java.util.List;

public interface DateSortingStrategy {
    List<LocalDate> sortDates(List<LocalDate> unsortedDates);
}

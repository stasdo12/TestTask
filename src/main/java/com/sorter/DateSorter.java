package com.sorter;

import java.time.LocalDate;
import java.util.List;

public interface DateSorter {

    /**
     * Sorts the dates and groups them based on the presence of 'r' in the month.
     * Dates with 'r' in the month are sorted in ascending order,
     * while dates without 'r' are sorted in descending order.
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the list of dates now sorted as per the spec
     */
    List<LocalDate> sortDates(List<LocalDate> unsortedDates);
}

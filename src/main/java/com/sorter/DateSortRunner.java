package com.sorter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateSortRunner {
    public static void main(String[] args) {
        List<LocalDate> unsortedDates = new ArrayList<>();
        unsortedDates.add(LocalDate.of(2004, 7, 1));
        unsortedDates.add(LocalDate.of(2005, 1, 2));
        unsortedDates.add(LocalDate.of(2007, 1, 1));
        unsortedDates.add(LocalDate.of(2032, 5, 3));

        DateSorter sorter = new DateSorterImpl();
        List<LocalDate> sortedDates = sorter.sortDates(unsortedDates);

        System.out.println("Sorted dates:");
        for (LocalDate date : sortedDates) {
            System.out.println(date);
        }
    }
}

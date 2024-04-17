package main.java.com.sorter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DateSorter implements DateSortingStrategy{


    /**
     * Sorts the dates and groups them based on the presence of 'r' in the month.
     * Dates with 'r' in the month are sorted in ascending order,
     * while dates without 'r' are sorted in descending order.
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the list of dates now sorted as per the spec
     */
    @Override
    public List<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        if (unsortedDates == null || unsortedDates.isEmpty()) {
            return new ArrayList<>();
        }


        final List<LocalDate> datesWithR = new ArrayList<>();
        final List<LocalDate> datesWithoutR = new ArrayList<>();

        for (final LocalDate date : unsortedDates) {
            if (containsR(date)) {
                datesWithR.add(date);
            } else
                datesWithoutR.add(date);
        }

        datesWithR.sort(Comparator.naturalOrder());
        datesWithoutR.sort(Comparator.reverseOrder());


        final List<LocalDate> sortedDates = new ArrayList<>(datesWithR);
        sortedDates.addAll(datesWithoutR);

        return sortedDates;
    }

    /**
     * Checks if the given date's month contains the letter 'r' (case-insensitive).
     *
     * @param date - the date to check
     * @return true if the month contains 'r', false otherwise
     */

    private boolean containsR(LocalDate date) {
        return date.getMonth().toString().toLowerCase().contains("r");
    }


}

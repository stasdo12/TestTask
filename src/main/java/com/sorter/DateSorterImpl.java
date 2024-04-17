package com.sorter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DateSorterImpl implements DateSorter {

    @Override
    public List<LocalDate> sortDates(final List<LocalDate> unsortedDates) {
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
    private boolean containsR(final LocalDate date) {
        return date.getMonth().toString().toLowerCase().contains("r");
    }
}

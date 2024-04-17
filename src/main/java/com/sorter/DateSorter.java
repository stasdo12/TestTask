package main.java.com.sorter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DateSorter {


    /**
     * Sorts the dates and groups them based on the presence of 'r' in the month.
     * Dates with 'r' in the month are sorted in ascending order,
     * while dates without 'r' are sorted in descending order.
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the list of dates now sorted as per the spec
     */
    public List<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        if (unsortedDates == null || unsortedDates.isEmpty()) {
            throw new IllegalArgumentException("Input list cannot be null or empty");
        }


        List<LocalDate> datesWithR = groupDatesWithR(unsortedDates);
        List<LocalDate> datesWithoutR = groupDatesWithoutR(unsortedDates);


        Comparator<LocalDate> naturalOrderComparator = Comparator.naturalOrder();
        Comparator<LocalDate> reverseOrderComparator = Comparator.reverseOrder();


        datesWithR.sort(naturalOrderComparator);

        datesWithoutR.sort(reverseOrderComparator);


        List<LocalDate> sortedDates = new ArrayList<>(datesWithR);
        sortedDates.addAll(datesWithoutR);

        return sortedDates;
    }

    /**
     * Groups dates with 'r' in the month.
     *
     * @param dates - a list of dates
     * @return the list of dates with 'r' in the month
     */
    private List<LocalDate> groupDatesWithR(List<LocalDate> dates) {
        List<LocalDate> datesWithR = new ArrayList<>();
        for (LocalDate date : dates) {
            if (date.getMonth().toString().toLowerCase().contains("r")) {
                datesWithR.add(date);
            }
        }
        return datesWithR;
    }

    /**
     * Groups dates without 'r' in the month.
     *
     * @param dates - a list of dates
     * @return the list of dates without 'r' in the month
     */
    private List<LocalDate> groupDatesWithoutR(List<LocalDate> dates) {
        List<LocalDate> datesWithoutR = new ArrayList<>();
        for (LocalDate date : dates) {
            if (!date.getMonth().toString().toLowerCase().contains("r")) {
                datesWithoutR.add(date);
            }
        }
        return datesWithoutR;
    }

    public static void main(String[] args) {
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
    }
}

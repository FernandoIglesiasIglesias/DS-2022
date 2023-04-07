package e1;

public class DateUtilities {
    public static boolean isLeap (int year) {
        /*
         * Indicates whether a year is a leap year . A leap year is divisible by 4,
         * unless it is divisible by 100 , in which case it must be divisible by 400
         * in order to be considered a leap year (e.g., 1900 is not a leap year ,
         * but 2000 is) = > See the JUnit seminar for an example .
         * @param year the given year
         * @return True if the given year is a leap year , false otherwise .
         */
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return (year % 400 == 0);
            }
            else return true;
        }
        else return false;
    }
    public static int numberOfDays (int month, int year) {
        /*
         * Indicates the number of days of a given month . As the number of days in
         * the month of February depends on the year , it is also necessary to pass
         * the year as an argument .
         * @param month The given month
         * @param year The given year
         * @return The number of days of that month in that year .
         * @throws IllegalArgumentException if the month is not valid .
         */
        int days;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12: //months with 31 days
                days=31;
                break;
            case 4, 6, 9, 11: //months with 30 days
                days=30;
                break;
            case 2: // February
                if (isLeap(year)) //we check if leap year
                    days=29;
                else
                    days=28;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return days;
    }
    public static String convertToISODate (String dateText) {
        /*
         * The ISO date format is a standard format that displays the dates
         * starting with the year , followed by the month and the day , i.e. ,
         * "YYYY -MM -DD ". For example , in that format the text " July 28 , 2006"
         * would be represented as "2006 -07 -28".
         * The " convertToISO " method converts a date in the " Month DD , AAAA "
         * format to its ISO representation . For simplicity , let us assume that
         * the values are correctly formatted even if the date is invalid
         * (e.g., " February 31 , 2006" is correctly formatted but it is not a valid date )
         *
         * @param dateText Date in textual format ( USA style ).
         * @return A string with the given date in ISO format .
         */
        String aux,day,month,year,final_string;
        aux = dateText.split(", ")[0];
        year = dateText.split(", ")[1];
        month = aux.split(" ")[0];
        day = aux.split(" ")[1];
        month = switch (month) {
            case "January" -> "01";
            case "February" -> "02";
            case "March" -> "03";
            case "April" -> "04";
            case "May" -> "05";
            case "June" -> "06";
            case "July" -> "07";
            case "August" -> "08";
            case "September" -> "09";
            case "October" -> "10";
            case "November" -> "11";
            case "December" -> "12";
            default -> month;
        };
        final_string = (year + "-" + month + "-" + day);
        if (checkISODate(final_string)) { //We check that the dates are valid and that the format is correct
            return final_string;
        } else throw new IllegalArgumentException();
    }
    public static boolean checkISODate (String ISODate) {
        String year,day,month;
        int yearInt, dayInt, monthInt;
        int dayMax;
        if (ISODate.length()==10) {  //ISO date must be 10 characters long
            year = ISODate.split("-")[0];
            //If it is true that year is equal to ISODate it means that the format is not correct:
            if (!year.equals(ISODate)) {
                month = ISODate.split("-")[1];
                day = ISODate.split("-")[2];
                //We obtain the values of year, month and day in type int
                yearInt=Integer.parseInt(year);
                monthInt=Integer.parseInt(month);
                dayInt=Integer.parseInt(day); //we check that both the year and the month and the day are correct:2
                if (yearInt>=1) {
                    if ((monthInt>=1)&&(monthInt<=12)) {
                        dayMax=numberOfDays(monthInt,yearInt);
                        return ((dayInt >= 1) && (dayInt <= dayMax));
                    } else return false;
                } else return false;
            } else return false;
            } else return false;
    }
}

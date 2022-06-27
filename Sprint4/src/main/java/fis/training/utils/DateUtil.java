package fis.training.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static final String DATE_FORMAT= "yyyy-MM-dd HH:mm";

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static LocalDateTime toDate(String date) {
        return LocalDateTime.parse(date, formatter);
    }

    public static String toString(LocalDateTime date){
        return date.format(formatter);
    }

}
package model.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static Pattern pattern;
    private static final String FULL_NAME_REGEX = "^[\\p{L} .'-]+$";
    private static final String PHONE_NUMBER_REGEX = "^(84|0[3|5|7|8|9])+([0-9]{8})$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@])[A-Za-z\\d@]{8,}$";
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String DATE_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)" +
            "(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]" +
            "\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])" +
            "(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    private static final String MONTH_AND_YEAR_REGEX = "^(0?[1-9]|1[0-2])/([0-9]{4})$";
    public static boolean invalidate(String regex, String regexPattern) {
        regexPattern = regexPattern.toUpperCase();
        switch (regexPattern) {
            case "FULL_NAME" -> pattern = Pattern.compile(FULL_NAME_REGEX);
            case "EMAIL" -> pattern = Pattern.compile(EMAIL_REGEX);
            case "PHONE_NUMBER" -> pattern = Pattern.compile(PHONE_NUMBER_REGEX);
            case "DATE" -> pattern = Pattern.compile(DATE_REGEX);
            case "PASSWORD" -> pattern = Pattern.compile(PASSWORD_REGEX);
            case "MONTH" -> pattern = Pattern.compile(MONTH_AND_YEAR_REGEX);
        }
        Matcher matcher = pattern.matcher(regex);
        return !matcher.matches();
    }
    public static boolean isBeyondNow(String dateFormatInput) throws ParseException {
        Date dateInput = new SimpleDateFormat("MM/yyyy").parse(dateFormatInput);
        return dateInput.getMonth() > new Date().getMonth()
                && dateInput.getYear() >= new Date().getYear()
                || dateInput.getYear() > new Date().getYear();
//        Calendar calendar = Calendar.getInstance();
//        int amount = new Date().getDate() - 1;//tính số ngày hiện tại trừ đi 1
//        calendar.add(Calendar.DATE, -amount);//lấy về thời gian hiện tại của đầu tháng(vẫn có giờ phút giây trong này)
//        Date firstDateInThisMonth = Converter.convertToBeginningOfDate(calendar.getTime());
//        return dateInput.getTime() > firstDateInThisMonth.getTime();
    }

    public static boolean isInWorkingTimeOfMovieTheater(Date date) throws ParseException {
        Date datetimeAt8hAm = Converter.convertTo8h20AmOfDate(date);
        return date.after(datetimeAt8hAm);
    }

}

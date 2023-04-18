package utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Converter {
    public static String formatPrice(double price) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        return numberFormat.format(price);
    }
}

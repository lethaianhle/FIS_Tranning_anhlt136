package vn.fis.training.test;

import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String name = "LeThaiAnh";
        System.out.println(name.matches("^[a-z A-Z]{5,50}$"));

        String mobile = " 111   11 1 ";
        System.out.println(removeBlank(mobile));
        System.out.println(mobile.matches("[0-9]{1,10}"));
    }

    // xoa khoang trang thua
    private static String removeBlank(String str) {
        String string = str.trim().toLowerCase();
        string = string.replaceAll("\\s+", "");
        return string;
    }
}

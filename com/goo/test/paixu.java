package com.goo.test;

import org.apache.commons.lang3.StringUtils;

public class paixu {

    public static void main(String[] args) {

        Long roadSectionId = 1234567890L;
        String sectionId = roadSectionId.toString();
        sectionId = StringUtils.leftPad(sectionId, 4, '0');
        System.out.println(sectionId);
        sectionId = sectionId.substring(sectionId.length() - 4);
        System.out.println(sectionId);



    }

    int calculateDaysBetweenDates(String date1, String date2) {
        int days = 0;
        int year1 = Integer.parseInt(date1.substring(0, 4));
        int year2 = Integer.parseInt(date2.substring(0, 4));
        int month1 = Integer.parseInt(date1.substring(5, 7));
        int month2 = Integer.parseInt(date2.substring(5, 7));
        int day1 = Integer.parseInt(date1.substring(8, 10));
        int day2 = Integer.parseInt(date2.substring(8, 10));
        if (year1 == year2) {
            if (month1 == month2) {
                days = day2 - day1;
            } else {
                days = (month2 - month1) * 30 + day2 - day1;
            }
        } else {
            days = (year2 - year1) * 365 + (month2 - month1) * 30 + day2 - day1;
        }
        return days;
    }

}

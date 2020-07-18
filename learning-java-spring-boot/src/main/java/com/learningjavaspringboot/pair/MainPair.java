package com.learningjavaspringboot.pair;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.trimToEmpty;

public class MainPair {

    private static final Pattern LAST_NUMBER_PATTERN = Pattern.compile("\\d[\\d,.]*$"); // match digits at the end of the line

    public static void main(String[] args) {
        Pair<String, String> stringStringPair = splitAddressStreetAndNumber("hey, 20");

        System.out.println(stringStringPair);
    }

    public static Pair<String, String> splitAddressStreetAndNumber(String streetWithNumber) {
        String street = trimToEmpty(streetWithNumber);
        String number = "";

        Matcher matcher = LAST_NUMBER_PATTERN.matcher(street);
        if (matcher.find()) {
            street = streetWithNumber.substring(0, matcher.start()).trim();
            if (street.endsWith(","))
                street = street.substring(0, street.length() - 1);

            number = matcher.group();
        }

        return new Pair<>(streetWithNumber, number);
    }

}

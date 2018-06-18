package com.sudha.wsautomation.utils;

import com.sudha.wsautomation.model.MatchType;

public class MatchTypeValidator {

    public static boolean validate(String expected, String actual, MatchType matchType) {

        switch (matchType) {

            case EQUALS:
                return expected.equalsIgnoreCase(actual);

            case CONTAINS:
                return actual.contains(expected);

            case NON_EMPTY:
                if (actual != null) {
                    return !actual.isEmpty();
                } else {
                    return false;
                }

            case NON_NULL:
                return actual != null;
        }
        return false;
    }
}

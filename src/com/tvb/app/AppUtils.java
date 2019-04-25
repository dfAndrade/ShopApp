package com.tvb.app;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppUtils {
    public static String repeat(String s, int n, String delimiter) {
        return Stream.generate(() -> s).limit(n).collect(Collectors.joining(delimiter));
    }
}

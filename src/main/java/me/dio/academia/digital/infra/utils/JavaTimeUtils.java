package me.dio.academia.digital.infra.utils;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class JavaTimeUtils {
    private JavaTimeUtils() {
        throw new AssertionError("This class should not be instantiated");
    }

    private static final Locale LOCALE_BR = Locale.forLanguageTag("pt-BR");
    private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", LOCALE_BR);
    private static final DateTimeFormatter LOCAL_DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy", LOCALE_BR);

    public static DateTimeFormatter localDateTimeFormatter() {
        return LOCAL_DATE_TIME_FORMATTER;
    }

    public static DateTimeFormatter localDateFormatter() {
        return LOCAL_DATE_FORMATTER;
    }
}

package com.fullcycle.admin.catologo.domain.utils;
import java.time.temporal.ChronoUnit;
import java.time.Instant;

public final  class InstantUtils {

    private InstantUtils() {
    }

    public static Instant now() {
        return Instant.now().truncatedTo(ChronoUnit.MICROS);
    }
}

package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.entity.Country.*;

class LocalizationServiceImplTest {

    LocalizationService localization = new LocalizationServiceImpl();

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(RUSSIA, "Добро пожаловать"),
                Arguments.of(USA, "Welcome"),
                Arguments.of(GERMANY, "Welcome"));
    }

    @ParameterizedTest
    @MethodSource("source")
    void localeTest(Country country, String expected) {
        String actual = localization.locale(country);
        assertEquals(expected, actual);
    }
}
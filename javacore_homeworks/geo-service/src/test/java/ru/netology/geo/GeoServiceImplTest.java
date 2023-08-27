package ru.netology.geo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.internal.matchers.Null;
import ru.netology.entity.Country;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

class GeoServiceImplTest {
    private GeoService geoService = new GeoServiceImpl();

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of("127.0.0.1", null),
                Arguments.of("172.0.32.11", RUSSIA),
                Arguments.of("96.44.183.149", USA));
    }

    @ParameterizedTest
    @MethodSource("source")
    void byIpTest(String ip, Country expected) {
        Country actual = geoService.byIp(ip).getCountry();
        assertEquals(expected, actual);
    }
}
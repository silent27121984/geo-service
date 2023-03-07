package ru.netology.geo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceTests {

    @ParameterizedTest
    @MethodSource("locationByIp")
    void testByIp(String ip, Location expected) {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp(ip);
        assertEquals(expected.getCountry().toString(), location.getCountry().toString());
    }

    private static Stream<Arguments> locationByIp() {
        Location localhost = new Location(null, null, null, 0);
        Location newYorkIp = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location moscowIp = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location russiaIp = new Location("Moscow", Country.RUSSIA, null, 0);
        Location usaIp = new Location("New York", Country.USA, null, 0);
        return Stream.of(Arguments.of("172.", russiaIp),
                Arguments.of("96.", usaIp),
                Arguments.of("127.0.0.1", localhost),
                Arguments.of("96.44.183.149", newYorkIp),
                Arguments.of("172.0.32.11", moscowIp));
    }
}



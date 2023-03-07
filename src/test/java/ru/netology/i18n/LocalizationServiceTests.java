package ru.netology.i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceTests {
    @ParameterizedTest
    @MethodSource("messagesForCountries")
    public void localeTest(String expected, Country country) {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(country);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> messagesForCountries() {
        String messageForRussian = "Добро пожаловать";
        String messageForEnglish = "Welcome";
        return Stream.of(
                Arguments.of(messageForRussian, Country.RUSSIA),
                Arguments.of(messageForEnglish, Country.USA)
        );
    }
}


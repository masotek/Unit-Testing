package com.infoshareacademy.jjdd3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class FahrenheitConverterTest {
//    @Test
//    void toCelsiusShouldReturnProperValueForZeroF() {
//        assertEquals(-17, FahrenheitConverter.toCelsius(0));
//    }
//
//    @Test
//    void toCelsiusShouldReturnProperValueForPositiveInteger() {
//        assertEquals(93, FahrenheitConverter.toCelsius(200));
//    }
//
//    @Test
//    void toCelsiusShouldReturnProperValueForNegativeInteger() {
//        assertEquals(-26, FahrenheitConverter.toCelsius(-15));
//    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/farenheit_to_celsius.csv"}, delimiter = ';')
    void shouldParseFarenheitToCelsius(int fahrenheit, int celsius) {
        assertEquals(FahrenheitConverter.toCelsius(fahrenheit), celsius,
                () -> "For " + fahrenheit + "F: ");
    }

    @Test
    void toCelsiusShouldThrowExceptionWhenValueIsLowerThanMinimum() {
        assertThrows(IllegalArgumentException.class, () -> {
           FahrenheitConverter.toCelsius(-500);
        });
    }
}

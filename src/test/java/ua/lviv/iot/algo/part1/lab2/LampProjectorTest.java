package ua.lviv.iot.algo.part1.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LampProjectorTest {
    private LampProjector lampProjector;

    @BeforeEach
    void setUp() {
        lampProjector = new LampProjector("Sony XMP-100", "1920x1080", "HDMI", 1000, DisplayMode.SPORT);
    }

    @Test
    void testIncreaseLampHours() {
        int initialLampHours = lampProjector.getRemainingWorkingHours();
        int additionalLampHours = 200;
        lampProjector.increaseLampHours(additionalLampHours);
        assertEquals(initialLampHours + additionalLampHours, lampProjector.getRemainingWorkingHours());
    }

    @Test
    void testGetRemainingWorkingHours() {
        assertEquals(1000, lampProjector.getRemainingWorkingHours());
    }
}

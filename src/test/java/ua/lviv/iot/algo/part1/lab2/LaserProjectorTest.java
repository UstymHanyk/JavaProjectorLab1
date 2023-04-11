package ua.lviv.iot.algo.part1.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LaserProjectorTest {
    private LaserProjector laserProjector;

    @BeforeEach
    void setUp() {
        laserProjector = new LaserProjector("LG G-85", "1920x1080", "HDMI", 20000, 500);
    }

    @Test
    void testGetRemainingWorkingHours() {
        assertEquals(20000, laserProjector.getRemainingWorkingHours());
    }
}

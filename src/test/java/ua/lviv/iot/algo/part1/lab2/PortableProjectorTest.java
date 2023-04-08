package ua.lviv.iot.algo.part1.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PortableProjectorTest {
    private PortableProjector portableProjector;

    @BeforeEach
    void setUp() {
        portableProjector = new PortableProjector("Samsung Porta-7", "1920x1080", "HDMI", 5000, 3000, 1.5);
    }

    @Test
    void testGetRemainingWorkingHours() {
        assertEquals(5000, portableProjector.getRemainingWorkingHours());
    }
}
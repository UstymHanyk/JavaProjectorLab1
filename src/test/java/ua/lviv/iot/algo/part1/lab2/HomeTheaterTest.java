
package ua.lviv.iot.algo.part1.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeTheaterTest {
    private HomeTheater homeTheater;

    @BeforeEach
    void setUp() {
        homeTheater = new HomeTheater("Xiaomi Mi-Theather", "1920x1080", "HDMI", 2021, 55, "SmartTV", 3);
    }

    @Test
    void testGetRemainingWorkingHours() {
        final int WORKING_HOURS_PER_YEAR = 3650;
        assertEquals(3 * WORKING_HOURS_PER_YEAR, homeTheater.getRemainingWorkingHours());
    }

    @Test
    void testAddInputDevice() {
        String newInputDevice = "VGA";
        homeTheater.addInputDevice(newInputDevice);
        assertEquals("VGA", homeTheater.getConnectedDevice());
    }

    @Test
    void testDisconnectDevice() {
        homeTheater.disconnectDevice();
        assertEquals(null, homeTheater.getConnectedDevice());
    }
}
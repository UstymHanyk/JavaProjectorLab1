package ua.lviv.iot.algo.part1.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProjectorManagerTest {
    private ProjectorManager projectorManager;
    private PortableProjector portableProjector;
    private LaserProjector laserProjector;
    private HomeTheater homeTheater;

    @BeforeEach
    void setUp() {
        projectorManager = new ProjectorManager();
        portableProjector = new PortableProjector("Portable", "1920x1080", "HDMI", 5000, 3000, 1.5);
        laserProjector = new LaserProjector("Laser", "1920x1080", "HDMI", 20000, 500);
        homeTheater = new HomeTheater("Home", "2160x1440", "VGA", 2021, 55, "SmartTV", 3);

        projectorManager.addProjector(portableProjector);
        projectorManager.addProjector(laserProjector);
        projectorManager.addProjector(homeTheater);
    }

    @Test
    void testAddProjector() {
        assertEquals(3, projectorManager.getProjectors().size());
        assertTrue(projectorManager.getProjectors().contains(portableProjector));
        assertTrue(projectorManager.getProjectors().contains(laserProjector));
        assertTrue(projectorManager.getProjectors().contains(homeTheater));
    }

    @Test
    void testFindAllProjectorsWithConnectionDevice() {
        List<AbstractProjector> projectorsWithHDMI = projectorManager.findAllProjectorsWithConnectionDevice("HDMI");
        assertEquals(2, projectorsWithHDMI.size());
        assertTrue(projectorsWithHDMI.contains(portableProjector));
        assertTrue(projectorsWithHDMI.contains(laserProjector));
    }

    @Test
    void testFindAllProjectorsWithResolutionHigherThan() {
        List<AbstractProjector> projectorsWithHigherResolution = projectorManager.findAllProjectorsWithResolutionHigherThan(1280, 720);
        assertEquals(3, projectorsWithHigherResolution.size());
        assertTrue(projectorsWithHigherResolution.contains(portableProjector));
        assertTrue(projectorsWithHigherResolution.contains(laserProjector));

        projectorsWithHigherResolution = projectorManager.findAllProjectorsWithResolutionHigherThan(1920, 1080);
        assertEquals(1, projectorsWithHigherResolution.size());
        assertTrue(projectorsWithHigherResolution.contains(homeTheater));

    }
}
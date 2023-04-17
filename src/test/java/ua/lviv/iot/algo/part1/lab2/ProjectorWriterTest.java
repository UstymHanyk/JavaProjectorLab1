package ua.lviv.iot.algo.part1.lab2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProjectorWriterTest {
    private ProjectorWriter projectorWriter;

    @BeforeEach
    public void setUp() {
        projectorWriter = new ProjectorWriter();
    }

    @Test
    public void testSuccessfulWriteToFileWithCorrectContent() throws IOException {
        String fileName = "test_successful_write.csv";
        List<AbstractProjector> projectors = Arrays.asList(
                new HomeTheater("Samsung HTS",
                        "1920x1080", "VGA", 2020,
                        32, "11.2", 5),
                new LampProjector("LG U-40K",
                        "1280x720", "HDMI", 2,
                        DisplayMode.SPORT),
                new LaserProjector("OPTOMA CINEMAX P2", "3840x2160", "HDMI",
                        20000, 3000),
                new PortableProjector(
                        "ViewSonic M1 mini", "1920x1080",
                        "HDMI", 4000,
                        0, 0.4));

        projectorWriter.writeToFile(projectors, fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String expected =
                    "model,resolution,connectedDevice,yearOfSale,screenSizeInInches,smartTVVersion,warrantyPeriodInYears\n" +
                    "Samsung HTS,1920x1080,VGA,2020,32,11.2,5\n" +
                    "model,resolution,connectedDevice,lampHours,displayMode\n" +
                    "LG U-40K,1280x720,HDMI,2,SPORT\n" +
                            "model,resolution,connectedDevice,batteryCapacityInMahs,currentBatteryChargeLevelInMahs,weightInKg\n" +
                            "ViewSonic M1 mini,1920x1080,HDMI,4000,0,0.4\n" +
                    "model,resolution,connectedDevice,laserLifespanInHours,laserBrightnessInLumens\n" +
                    "OPTOMA CINEMAX P2,3840x2160,HDMI,20000,3000";
            String actual = reader.lines().collect(Collectors.joining("\n"));
            assertEquals(expected, actual, "Written content does not match expected content");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        Files.deleteIfExists(Paths.get("test_successful_write.csv"));

    }


    @Test
    public void testWriteEmptyListToFile() {
        String fileName = "test_empty_list_write.csv";
        List<AbstractProjector> projectors = Collections.emptyList();
        assertThrows(IllegalArgumentException.class, () -> projectorWriter.writeToFile(projectors, fileName));
    }

    @Test
    public void testAlreadyExistingFileOverride() throws IOException {
        final String TEST_FILE_NAME = "test_override.csv";

        try(FileWriter testWriter = new FileWriter(TEST_FILE_NAME);){
            testWriter.write("Text to be overwritten.");
            testWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<AbstractProjector> projectors = Arrays.asList(
                new HomeTheater("Samsung HTS",
                        "1920x1080", "VGA", 2020,
                        32, "11.2", 5),
                new LampProjector("LG U-40K",
                        "1280x720", "HDMI", 2,
                        DisplayMode.SPORT));

        projectorWriter.writeToFile(projectors, TEST_FILE_NAME);

        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_FILE_NAME))) {
            String expected =
                    "model,resolution,connectedDevice,yearOfSale,screenSizeInInches,smartTVVersion,warrantyPeriodInYears\n" +
                    "Samsung HTS,1920x1080,VGA,2020,32,11.2,5\n"+
                            "model,resolution,connectedDevice,lampHours,displayMode\n" +
                            "LG U-40K,1280x720,HDMI,2,SPORT" ;
            String actual = reader.lines().collect(Collectors.joining("\n"));
            assertEquals(expected, actual, "Written content does not match expected content");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        Files.deleteIfExists(Paths.get(TEST_FILE_NAME));
    }
}

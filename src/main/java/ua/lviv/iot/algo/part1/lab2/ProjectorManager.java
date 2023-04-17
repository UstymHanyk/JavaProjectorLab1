package ua.lviv.iot.algo.part1.lab2;

import lombok.Generated;
import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProjectorManager {

    private final List<AbstractProjector> projectors = new LinkedList<>();


    public void addProjector(final AbstractProjector projector) {
        projectors.add(projector);
    }

    public List<AbstractProjector> findAllProjectorsWithConnectionDevice(
            final String connectedDevice) {
        return projectors.stream().
                filter(projector -> projector.getConnectedDevice()
                        .equals(connectedDevice)).
                collect(Collectors.toList());
    }

    public List<AbstractProjector> findAllProjectorsWithResolutionHigherThan
            (final int widthInPixels, final int heightInPixels) {
        return projectors.stream().filter(projector -> {
                    String[] resolutionArray = projector.getResolution()
                            .split("x");
                    return Integer.parseInt(resolutionArray[0]) >
                            widthInPixels &&
                            Integer.parseInt(resolutionArray[1]) >
                                    heightInPixels;
                })
                .collect(Collectors.toList());
    }

    @Generated
    public static void main(String[] args) {
        ProjectorManager projectorManager = new ProjectorManager();

        projectorManager.addProjector(new LampProjector("Sony X-232",
                "1920x1080", "USB", 2,
                DisplayMode.ACTIVE));
        projectorManager.addProjector(new LampProjector("LG U-40K",
                "1280x720", "HDMI", 2,
                DisplayMode.SPORT));

        projectorManager.addProjector(new HomeTheater("Samsung HTS",
                "1920x1080", "VGA", 2020,
                32, "11.2", 5));
        projectorManager.addProjector(new HomeTheater("EPSON LS-100",
                "3840x2160", "HDMI", 2020,
                32, "11.2", 5));

        projectorManager.addProjector(new LaserProjector("OPTOMA CINEMAX P2", "3840x2160", "HDMI",
                20000, 3000));
        projectorManager.addProjector(new LaserProjector("SONY VW325ES",
                "1920x1080", "HDMI",
                20000, 3000));

        projectorManager.addProjector(new PortableProjector(
                "ViewSonic M1 mini", "1920x1080",
                "HDMI", 4000,
                0, 0.4));
        projectorManager.addProjector(new PortableProjector(
                "Anker Nebula", "5120x2880",
                "HDMI", 3000,
                3000, 0.8));

        System.out.printf("All projectors:%n");
        for (AbstractProjector projector : projectorManager.projectors) {
            System.out.println(projector);
        }

        System.out.printf("%n Projectors that connect via HDMI:%n");
        List<AbstractProjector> hdmiProjectors = projectorManager.
                findAllProjectorsWithConnectionDevice("HDMI");
        for (AbstractProjector projector : hdmiProjectors) {
            System.out.println(projector);
        }


        System.out.printf("%n resolution higher than 1920x1080:%n");
        List<AbstractProjector> highResolutionProjectors = projectorManager.
                findAllProjectorsWithResolutionHigherThan(1920, 1080);
        for (AbstractProjector projector : highResolutionProjectors) {
            System.out.println(projector);
        }


        ProjectorWriter projectorWriter = new ProjectorWriter();
        projectorWriter.writeToFile(projectorManager.projectors, "projectors.csv");


    }

}

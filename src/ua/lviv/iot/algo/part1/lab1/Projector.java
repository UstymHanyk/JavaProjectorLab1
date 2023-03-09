package ua.lviv.iot.algo.part1.lab1;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Projector {
    private String model;
    private String resolution;
    private int lampHours;
    private String connectedDevice;
    private static Projector defaultProjector = new Projector();

    public static Projector getInstance() {
        return defaultProjector;
    }

    public void addInputDevice(String device) {
        this.connectedDevice = device;
    }

    public void disconnectDevice() {
        this.connectedDevice = null;
    }

    public void increaseLampHours(int hours) {
        this.lampHours += hours;
    }

    public static void main(String[] args) {
        Projector projector1 = new Projector();
        Projector projector2 = new Projector("Sony", "1280x720", 300, "VGA");
        Projector projector3 = Projector.getInstance();
        Projector projector4 = Projector.getInstance();

        Projector[] projectors = {projector1, projector2, projector3, projector4};

        for (Projector projector :projectors) {
            System.out.println(projector);
        }
    }
}

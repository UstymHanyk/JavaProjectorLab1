package ua.lviv.iot.algo.part1.lab1;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

        Projector[] projectors = {new Projector(), new Projector("Sony", "1280x720", 300, "VGA"), Projector.getInstance(), Projector.getInstance()};

        for (Projector projector : projectors) {
            System.out.println(projector);
        }
    }
}

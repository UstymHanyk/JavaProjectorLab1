package ua.lviv.iot.algo.part1.lab2;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class AbstractProjector {
    private String model;
    private String resolution;
    private String connectedDevice;

    public void addInputDevice(String device) {
        this.connectedDevice = device;
    }

    public void disconnectDevice() {
        this.connectedDevice = null;
    }

    public abstract int getRemainingWorkingHours();

}

package ua.lviv.iot.algo.part1.lab2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class AbstractProjector {
    private String model;
    private String resolution;
    private String connectedDevice;

    public void addInputDevice(final String device) {
        this.connectedDevice = device;
    }

    public void disconnectDevice() {
        this.connectedDevice = null;
    }

    public abstract int getRemainingWorkingHours();

    public String getHeaders() {
        return "model,resolution,connectedDevice";
    }

    public String toCSV() {
        return model + "," + resolution + "," + connectedDevice;
    }
}

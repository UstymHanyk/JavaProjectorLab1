package ua.lviv.iot.algo.part1.lab2;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class LaserProjector extends AbstractProjector {
    private int laserLifespanInHours;
    private int laserBrightnessInLumens;


    public LaserProjector(String model, String resolution, String connectedDevice, int laserLifespanInHours, int laserBrightnessInLumens) {
        super(model, resolution, connectedDevice);
        this.laserLifespanInHours = laserLifespanInHours;
        this.laserBrightnessInLumens = laserBrightnessInLumens;
    }

    @Override
    public int getRemainingWorkingHours() {
        return laserLifespanInHours;
    }
}
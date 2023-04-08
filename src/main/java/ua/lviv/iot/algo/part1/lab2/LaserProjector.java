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
@ToString(callSuper = true)
public class LaserProjector extends AbstractProjector {
    private int laserLifespanInHours;
    private int laserBrightnessInLumens;


    public LaserProjector(final String model, final String resolution,
                          final String connectedDevice,
                          final int laserLifespanInHours,
                          final int laserBrightnessInLumens) {
        super(model, resolution, connectedDevice);
        this.laserLifespanInHours = laserLifespanInHours;
        this.laserBrightnessInLumens = laserBrightnessInLumens;
    }

    @Override
    public int getRemainingWorkingHours() {
        return laserLifespanInHours;
    }
}

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
public class PortableProjector extends AbstractProjector {
    private int batteryCapacityInMahs;
    private int currentBatteryChargeLevelInMahs;
    private double weightInKg;

    public PortableProjector(final String model, final String resolution,
                             final String connectedDevice,
                             final int batteryCapacityInMahs,
                             final int currentBatteryChargeLevelInMahs,
                             final double weightInKg) {
        super(model, resolution, connectedDevice);
        this.batteryCapacityInMahs = batteryCapacityInMahs;
        this.currentBatteryChargeLevelInMahs = currentBatteryChargeLevelInMahs;
        this.weightInKg = weightInKg;
    }

    @Override
    public int getRemainingWorkingHours() {
        return this.batteryCapacityInMahs;
    }
}

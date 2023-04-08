package ua.lviv.iot.algo.part1.lab2;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class PortableProjector extends AbstractProjector {
    private int batteryCapacityInMahs;
    private int currentBatteryChargeLevelInMahs;
    private double weightInKg;

    public PortableProjector(String model, String resolution, String connectedDevice, int batteryCapacityInMahs, int currentBatteryChargeLevelInMahs, double weightInKg) {
        super(model, resolution,connectedDevice);
        this.batteryCapacityInMahs = batteryCapacityInMahs;
        this.currentBatteryChargeLevelInMahs = currentBatteryChargeLevelInMahs;
        this.weightInKg = weightInKg;
    }

    @Override
    public int getRemainingWorkingHours() {
        return this.batteryCapacityInMahs;
    }
}
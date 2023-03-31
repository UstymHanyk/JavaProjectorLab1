package ua.lviv.iot.algo.part1.lab2;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class HomeTheater extends AbstractProjector {
    private int yearOfSale;
    private int screenSizeInInches;
    private String smartTVVersion;
    private int warrantyPeriodInYears;
    private static final int WORKING_HOURS_PER_YEAR = 3650;

    public HomeTheater(String model, String resolution, String connectedDevice, int yearOfSale, int screenSizeInInches, String smartTVVersion, int warrantyPeriodInYears) {
        super(model, resolution, connectedDevice);
        this.yearOfSale = yearOfSale;
        this.screenSizeInInches = screenSizeInInches;
        this.smartTVVersion = smartTVVersion;
        this.warrantyPeriodInYears = warrantyPeriodInYears;
    }

    @Override
    public int getRemainingWorkingHours() {
        return this.warrantyPeriodInYears * WORKING_HOURS_PER_YEAR;
    }
}

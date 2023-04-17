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
public class HomeTheater extends AbstractProjector {
    private static final int WORKING_HOURS_PER_YEAR = 3650;
    private int yearOfSale;
    private int screenSizeInInches;
    private String smartTVVersion;
    private int warrantyPeriodInYears;

    public HomeTheater(final String model, final String resolution,
                       final String connectedDevice, final int yearOfSale,
                       final int screenSizeInInches,
                       final String smartTVVersion,
                       final int warrantyPeriodInYears) {
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

    @Override
    public String getHeaders() {
        return super.getHeaders() + ",yearOfSale,screenSizeInInches,smartTVVersion,warrantyPeriodInYears";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + yearOfSale + "," + screenSizeInInches + "," + smartTVVersion + "," + warrantyPeriodInYears;
    }
}

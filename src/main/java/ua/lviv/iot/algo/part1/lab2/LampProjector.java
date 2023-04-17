package ua.lviv.iot.algo.part1.lab2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

enum DisplayMode {
    SPORT,
    ACTIVE,
    PRESENTATION
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class LampProjector extends AbstractProjector {
    private int lampHours;
    private DisplayMode displayMode;

    public LampProjector(final String model, final String resolution,
                         final String connectedDevice,
                         final int lampHours, final DisplayMode displayMode) {
        super(model, resolution, connectedDevice);
        this.lampHours = lampHours;
        this.displayMode = displayMode;
    }

    @Override
    public int getRemainingWorkingHours() {
        return this.lampHours;
    }

    public void increaseLampHours(final int lampHours) {
        this.lampHours += lampHours;
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ",lampHours,displayMode";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + lampHours + "," + displayMode;
    }
}

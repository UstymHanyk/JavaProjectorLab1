package ua.lviv.iot.algo.part1.lab2;
import lombok.*;

enum DisplayMode {
    SPORT,
    ACTIVE,
    PRESENTATION
}

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class LampProjector extends AbstractProjector {
    private int lampHours;
    private DisplayMode displayMode;

    public LampProjector(String model, String resolution, String connectedDevice, int lampHours, DisplayMode displayMode){
        super(model, resolution, connectedDevice);
        this.lampHours = lampHours;
        this.displayMode = displayMode;
    }

    @Override
    public int getRemainingWorkingHours(){
        return this.lampHours;
    }

    public void increaseLampHours(int lampHours) {
        this.lampHours += lampHours;
    }


}



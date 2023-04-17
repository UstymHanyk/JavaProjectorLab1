package ua.lviv.iot.algo.part1.lab2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProjectorWriter {
    public void writeToFile(List<AbstractProjector> projectors, String fileName) {
        if (projectors.isEmpty()) {
            throw new IllegalArgumentException("Список проекторів порожній");
        }

        Map<Class<? extends AbstractProjector>, List<AbstractProjector>> groupedProjectors = projectors.stream()
                .collect(Collectors.groupingBy(AbstractProjector::getClass));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (List<AbstractProjector> projectorGroup : groupedProjectors.values()) {
                if (!projectorGroup.isEmpty()) {
                    writer.write(projectorGroup.get(0).getHeaders());
                    writer.newLine();

                    for (AbstractProjector projector : projectorGroup) {
                        writer.write(projector.toCSV());
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }

}

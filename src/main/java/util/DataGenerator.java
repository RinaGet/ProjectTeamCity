package util;

import model.Project;

import java.time.LocalDateTime;
import java.util.UUID;

public class DataGenerator {
    public static Project randomProject() {
        return new Project(
                "Project_" + UUID.randomUUID(),
                "TestProject_" + LocalDateTime.now(),
                "_Root"
        );
    }
}

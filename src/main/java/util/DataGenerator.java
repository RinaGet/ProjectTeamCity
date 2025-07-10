package util;

import model.Project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class DataGenerator {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static Project randomProject() {

        String unique = LocalDateTime.now().format(formatter) + "-" + UUID.randomUUID().toString().substring(0, 8);

        return Project.builder()
                .id("AutoProj-" + unique)
                .name("Generated Project" + unique)
                .parentProjectId("_Root")
                .build();
    }
}

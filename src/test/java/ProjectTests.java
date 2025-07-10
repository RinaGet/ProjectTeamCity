import httpClient.TeamCityApiClient;
import io.restassured.response.Response;
import model.Project;
import org.junit.jupiter.api.Test;
import util.DataGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTests {
    @Test
    void createProjectTest() {
        Project project = DataGenerator.randomProject();

        Response response = TeamCityApiClient.post("/app/rest/projects", project);
        response.then().statusCode(200);

        Project created = response.as(Project.class);
        assertEquals(project.getName(), created.getName());
        assertEquals(project.getParentProjectId(), created.getParentProjectId());
    }
}

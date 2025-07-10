import httpClient.project.ProjectClient;
import io.restassured.response.Response;
import model.Project;
import org.junit.jupiter.api.Test;
import util.DataGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTests {

    private final ProjectClient projectClient = new ProjectClient();

    @Test
    void createAndFetchProjectTest() {
        Project newProject = DataGenerator.randomProject();
        System.out.println(newProject.getId()); //remove later!

        Response createResponse = projectClient.createProject(newProject);
        createResponse.then().statusCode(200);

        Project created = createResponse.as(Project.class);
        assertEquals(newProject.getName(), created.getName());

        Response getResponse = projectClient.getProject(created.getId());
        getResponse.then().statusCode(200);

        Project fetched = getResponse.as(Project.class);
        assertEquals(created.getName(), fetched.getName());
    }
}

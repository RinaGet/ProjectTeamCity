package httpClient.project;


import httpClient.base.BaseApiClient;
import io.restassured.response.Response;
import model.Project;

public class ProjectClient extends BaseApiClient {

    private static final String PROJECTS_ENDPOINT = "/app/rest/projects";

    public Response createProject(Project project) {
        return post(PROJECTS_ENDPOINT, project);
    }

    public Response getProject(String locator) {
        return get(PROJECTS_ENDPOINT + "/" + locator);
    }

    public Response deleteProject(String locator) {
        return delete(PROJECTS_ENDPOINT + "/" + locator);
    }
}

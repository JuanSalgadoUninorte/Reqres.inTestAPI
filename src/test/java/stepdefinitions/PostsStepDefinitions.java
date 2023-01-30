package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.ModelData;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.ResponseStatusDeleted;
import questions.ResponseStatusPost;
import task.PostsTask;
import util.enums.RestService;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PostsStepDefinitions {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("The page")
    public void thePage() {
        OnStage.theActorCalled("Juan").whoCan(CallAnApi.at(RestService.BASE_URL.toString()));
    }

    @When("I tried all posts")
    public void iTriedAllPosts(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(PostsTask.post(ModelData.setData(dataTable).get(0)));
    }

    @Then("My work is done, status {int} or {int}")
    public void myWorkIsDoneStatusOr(int arg0, int arg1) {
        arg0 = 201;
        arg1 = 200;
        OnStage.theActorInTheSpotlight().should(
                seeThat("Last response status code is 201",
                        ResponseStatusPost.post(arg0))
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat("Last response status code is 200",
                        ResponseStatusPost.post(arg1))
        );
    }

    @Then("My work is done, and in the final test the result must be {int}")
    public void myWorkIsDoneAndInTheFinalTestTheResultMustBe(int arg0) {
        arg0 = 400;
        OnStage.theActorInTheSpotlight().should(
                seeThat("Last response status code is 400",
                        ResponseStatusPost.post(arg0))
        );
    }
}

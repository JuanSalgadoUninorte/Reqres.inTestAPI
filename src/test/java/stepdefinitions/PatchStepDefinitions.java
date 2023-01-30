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
import questions.ResponseStatusPatch;
import task.PatchTask;
import util.enums.RestService;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PatchStepDefinitions {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("The final stage")
    public void theFinalStage() {
        OnStage.theActorCalled("Juan").whoCan(CallAnApi.at(RestService.BASE_URL.toString()));
    }

    @When("We add the info in the body")
    public void weAddTheInfoInTheBody(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(PatchTask.patchProcess(ModelData.setData(dataTable).get(0)));
    }

    @Then("We get a final status of {int}")
    public void weGetAFinalStatusOf(int arg0) {
        arg0 = 200;
        OnStage.theActorInTheSpotlight().should(
                seeThat("Last response status code is 200",
                        ResponseStatusPatch.patch(arg0))
        );
    }
}

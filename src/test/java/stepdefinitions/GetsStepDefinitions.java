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
import questions.LastResponseStatus;
import task.GetsTask;
import util.enums.RestService;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class GetsStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("The access to requestin")
    public void theAccessToRequestin() {
        OnStage.theActorCalled("Juan").whoCan(CallAnApi.at(RestService.BASE_URL.toString()));
    }

    @When("I had proved all the GETS processes")
    public void iHadProvedAllTheGETSProcesses(DataTable datatable) {
        OnStage.theActorInTheSpotlight().attemptsTo(GetsTask.process(ModelData.setData(datatable).get(0)));
    }

    @Then("I had finished the process with an status code {int}")
    public void iHadFinishedTheProcessWithAnStatusCode(int arg0) {
        arg0 = 200;
        OnStage.theActorInTheSpotlight().should(
                seeThat("Last response status code is 200",
                        LastResponseStatus.isEqualsTo(arg0))
        );
    }
}

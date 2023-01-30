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
import questions.ResponseStatusPut;
import task.PutTask;
import util.enums.RestService;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PutStepDefinitions {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("We are in the penultimate step")
    public void weAreInThePenultimateStep() {
        OnStage.theActorCalled("Juan").whoCan(CallAnApi.at(RestService.BASE_URL.toString()));
    }

    @When("We add the info to this case")
    public void weAddTheInfoToThisCase(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(PutTask.putProcess(ModelData.setData(dataTable).get(0)));
    }

    @Then("Let's go to the final step with an status of {int}")
    public void letSGoToTheFinalStepWithAnStatusOf(int arg0) {
        arg0 = 200;
        OnStage.theActorInTheSpotlight().should(seeThat("Last response status is 200", ResponseStatusPut.put(arg0)));
    }
}

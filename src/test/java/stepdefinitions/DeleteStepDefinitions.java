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
import task.DeleteTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static util.enums.RestService.BASE_URL;

public class DeleteStepDefinitions {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("We almost finish")
    public void weAlmostFinish() {
        OnStage.theActorCalled("Juan").whoCan(CallAnApi.at(BASE_URL.toString()));
    }

    @When("We try the only delete")
    public void weTryTheOnlyDelete(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteTask.removed(ModelData.setData(dataTable).get(0)));
    }

    @Then("We are done with a final status {int}")
    public void weAreDoneWithAFinalStatus(Integer int1) {
        int1 = 204;
        OnStage.theActorInTheSpotlight().should(
                seeThat("Last response status code is 204",
                        ResponseStatusDeleted.deleted(int1))
        );
    }

}

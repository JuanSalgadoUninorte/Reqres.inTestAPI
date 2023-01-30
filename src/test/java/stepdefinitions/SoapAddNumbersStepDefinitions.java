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
import task.AddNumbers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static util.enums.SoapService.BASE_URL;

public class SoapAddNumbersStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Scenario")
    public void scenario() {
        OnStage.theActorCalled("Juan").whoCan(CallAnApi.at(BASE_URL.toString()));
    }

    @When("you add two numbers")
    public void youAddTwoNumbers(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(AddNumbers.with(ModelData.setData(dataTable)));
    }

    @Then("I should see the response of the service is {int}")
    public void iShouldSeeTheResponseOfTheServiceIs(Integer int1) {
        int1 = 200;
        OnStage.theActorInTheSpotlight().should(
                seeThat("Last response status code is 200",
                        LastResponseStatus.isEqualsTo(int1))
        );
    }

}

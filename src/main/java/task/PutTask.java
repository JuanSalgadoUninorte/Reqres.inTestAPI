package task;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import model.ModelData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.assertj.core.api.BDDAssertions.not;
import static org.hamcrest.Matchers.isEmptyString;

public class PutTask implements Task {

    private ModelData modelData;

    public PutTask(ModelData modelData) {
        this.modelData = modelData;
    }

    public static PutTask putProcess(ModelData modelData) {
        return Tasks.instrumented(PutTask.class, modelData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("users/2").with(
                        request -> request.header("Content-type", "application/json").body(
                                "{\"name\":\"" + modelData.getName() + "\",\"job\":\"" + modelData.getJobOne() + "\"}")
                )
        );
        actor.should(
                seeThatResponse(
                        response -> response.statusCode(200)));
    }

}

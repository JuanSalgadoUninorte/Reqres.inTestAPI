package task;

import model.ModelData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class PatchTask implements Task {

    private ModelData modelData;

    public PatchTask(ModelData modelData) {
        this.modelData = modelData;
    }

    public static PatchTask patchProcess(ModelData modelData) {
        return Tasks.instrumented(PatchTask.class, modelData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Patch.to("users/2").with(
                        request -> request.header("Content-Type","application/json").
                                body("{\"name\": \""+modelData.getName()+"\",\"job\":\""+modelData.getJobOne()+"\"}"))
        );
        actor.should(
                seeThatResponse("The user was successfully updated",
                        response -> response.statusCode(200))
        );
    }
}

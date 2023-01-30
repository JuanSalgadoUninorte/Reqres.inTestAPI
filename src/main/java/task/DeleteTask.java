package task;

import model.ModelData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteTask implements Task {

    private ModelData modelData;

    public DeleteTask(ModelData modelData) {
        this.modelData = modelData;
    }

    public static DeleteTask removed(ModelData modelData) {
        return Tasks.instrumented(DeleteTask.class, modelData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Delete.from("users/2")
        );

    }
}

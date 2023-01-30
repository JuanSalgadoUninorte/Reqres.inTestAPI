package task;

import model.ModelData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import static org.assertj.core.api.Assertions.assertThat;

public class GetsTask implements Task {

    private ModelData modelData;

    public GetsTask(ModelData modelData) {
        this.modelData = modelData;
    }

    public static GetsTask process(ModelData modelData) {
        return Tasks.instrumented(GetsTask.class, modelData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("users?page=2")
        );
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(modelData.getOkStatus());
        actor.attemptsTo(
                Get.resource("users/2")
        );
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(modelData.getOkStatus());
        actor.attemptsTo(
                Get.resource("users/23")
        );
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(modelData.getNotFoundStatus());
        actor.attemptsTo(
                Get.resource("unknown")
        );
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(modelData.getOkStatus());
        actor.attemptsTo(
                Get.resource("unknown/2")
        );
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(modelData.getOkStatus());
        actor.attemptsTo(
                Get.resource("unknown/23")
        );
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(modelData.getNotFoundStatus());
        actor.attemptsTo(
                Get.resource("users?delay=3")
        );
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(modelData.getOkStatus());
    }
}

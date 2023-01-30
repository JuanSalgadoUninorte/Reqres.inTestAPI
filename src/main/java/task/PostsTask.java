package task;

import model.ModelData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class PostsTask implements Task {
    private ModelData modelData;

    public PostsTask(ModelData modelData) {
        this.modelData = modelData;
    }

    public static PostsTask post(ModelData modelData) {
        return Tasks.instrumented(PostsTask.class, modelData);
    }

    public void response() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("users/")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"name\": \"" + modelData.getName() + "\",\"job\": \"" + modelData.getJob() + "\"}")
                        ));
        actor.should(
                seeThatResponse("The user should have been successfully added",
                        response -> response.statusCode(201))
        );
        actor.attemptsTo(
                Post.to("register")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"email\": \"" + modelData.getEmailSuccessful() + "\",\"password\": \"" + modelData.getPasswordOne() + "\"}")
                        ));
        actor.should(
                seeThatResponse("Successful register",
                        response -> response.statusCode(200))
        );
        actor.attemptsTo(
                Post.to("register")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"email\": \"" + modelData.getEmailUnsuccessfulOne() + "\"}")
                        ));
        actor.should(
                seeThatResponse("Unsuccessful register",
                        response -> response.statusCode(400))
        );
        actor.attemptsTo(
                Post.to("login")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"email\": \"" + modelData.getEmailSuccessful() + "\",\"password\": \"" + modelData.getPasswordTwo() + "\"}")
                        ));
        actor.should(
                seeThatResponse("Login successfull",
                        response -> response.statusCode(200))
        );
        actor.attemptsTo(
                Post.to("login")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"email\": \"" + modelData.getEmailUnsuccessfulTwo() + "\"}")
                        ));
        actor.should(
                seeThatResponse("Login successfull",
                        response -> response.statusCode(400))
        );

    }
}

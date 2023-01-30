package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseStatusPost implements Question<Boolean> {

    private int code;

    public ResponseStatusPost(int code) {
        this.code = code;
    }

    public static ResponseStatusPost post(int code) {
        return new ResponseStatusPost(code);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return lastResponse().statusCode() == code;

    }
}

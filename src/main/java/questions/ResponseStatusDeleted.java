package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseStatusDeleted implements Question<Boolean> {

    private int code;

    public ResponseStatusDeleted(int code) {
        this.code = code;
    }

    public static ResponseStatusDeleted deleted(int code) {
        return new ResponseStatusDeleted(code);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return lastResponse().statusCode() == code;
    }
}

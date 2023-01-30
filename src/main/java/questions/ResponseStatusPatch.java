package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseStatusPatch implements Question<Boolean> {

    private int code;

    public ResponseStatusPatch(int code) {
        this.code = code;
    }

    public static ResponseStatusPatch patch(int code) {
        return new ResponseStatusPatch(code);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return lastResponse().statusCode() == code;
    }
}

package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseStatusPut implements Question<Boolean> {

    private int code;

    public ResponseStatusPut(int code) {
        this.code = code;
    }

    public static ResponseStatusPut put(int code) {
        return new ResponseStatusPut(code);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return lastResponse().statusCode() == code;
    }
}

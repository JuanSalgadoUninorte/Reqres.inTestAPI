package task;

import model.ModelData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static util.enums.SoapService.ADD_NUMBERS;

public class AddNumbers implements Task {
    private List<ModelData> values;

    public AddNumbers(List<ModelData> values) {
        this.values = values;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(ADD_NUMBERS.toString())
                        .with(request -> request
                                .header("Content-Type", "text/xml")
                                .body("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                                        "<soap:Envelope\n" +
                                        "   xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                                        "   xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n" +
                                        "   xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                                        "   <soap:Body>\n" +
                                        "       <Add\n" +
                                        "           xmlns=\"http://tempuri.org/\">\n" +
                                        "           <intA>" + values.get(0).getNumUno() + "</intA>\n" +
                                        "           <intB>" + values.get(0).getNumDos() + "</intB>\n" +
                                        "       </Add>\n" +
                                        "   </soap:Body>\n" +
                                        "</soap:Envelope>")
                        )
        );
    }

    public static AddNumbers with(List<ModelData> values){
        return instrumented(AddNumbers.class, values);
    }

}

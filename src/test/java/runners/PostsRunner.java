package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/api_processes.feature",
        tags = "@post",
        glue = "stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class PostsRunner {
}

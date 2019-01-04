package CucumberFrameworkExercises.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/CucumberFrameworkExercises/featureFiles/"},
        glue = {"CucumberFrameworkExercises.steps"},
        monochrome = true,
        tags = {},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class RunCucumberTest {


}

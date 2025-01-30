package Testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/feature/student_form.feature", // Path to your feature files
    glue = {"StepDefinitions"} // Package where your step definitions are located
 //   plugin = {"io.cucumber.allure.CucumberAllure", "pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"}
  //  monochrome = true
)
public class TestRunner {
    // No methods needed, just a configuration class
}





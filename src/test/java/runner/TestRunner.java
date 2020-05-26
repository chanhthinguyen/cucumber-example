package runner;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/api"},
                 glue = {"steps.api"},
                 plugin = {"pretty","html:target/cucumber-html-report","json:reports/cucumber-reports/Cucumber.json"},
                 strict = false)
public class TestRunner  {
}
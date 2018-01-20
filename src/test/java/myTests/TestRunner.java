package myTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:/simpleCucumber/src/test/resources/features/simple_atm_operation.feature",
glue={"myTests/steps/"},
format = {"pretty"})
public class TestRunner {
}

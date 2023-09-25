package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"StepDefinitions"},
    //tags = "@activity1 or @activity2 or @activity3 or @activity4 or @activity5 or @activity6"
    //tags = "@activity5",
    tags = "@SmokeTest", //Should run only the simple alert Scenario
    // tags = "@SimpleTest or @ConfirmAlert", // Should run the simple alert Scenario and the confirm alert Scenario
    // tags = "@PromptAlert",  //Should run only the prompt alert Scenario
    // tags = "@activity3", //Should run the all the Scenarios from activity 3
   // plugin = {"pretty"},
   //plugin = {"html: test-reports"},
    plugin = {"json: test-reports-json"},
    monochrome = true
    
)

public class ActivitiesRunner {
    //empty
}


package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:Reports/htmlReport.html", "json:Reports/jsonReport.json"},
	    features="./src/test/resources/features/Supakan's Features",
        glue="step_definitions_UI",
        dryRun=false, //cucumber will only run scenario steps that haven't been implemented
        tags="@resetPassword",
        publish = true
)

public class TestRunner_Supakan {

}

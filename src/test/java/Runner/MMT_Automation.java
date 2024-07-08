package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/Sparsh/Contact.feature", glue = "Steps") //name of any steps defn package


public class MMT_Automation {

}

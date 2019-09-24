package runner;



import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
/* @CucumberOptions(features = {"src/test/java/Feature"}, glue = "Steps")tags = "@4all"*/
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
               features = {"src/test/java/Feature"},
                   tags = {"@4all"} ,
                  glue = {"Steps"}
                   )
public class TestRunner {


}

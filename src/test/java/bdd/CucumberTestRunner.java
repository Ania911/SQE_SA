package bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/bdd/bddEpam.feature",
        glue = "bdd"
)

public class CucumberTestRunner {
}

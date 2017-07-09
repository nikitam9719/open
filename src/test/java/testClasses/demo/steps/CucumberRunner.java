package testClasses.demo.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import base.Base;
import org.testng.annotations.Test;
import testNames.TestNames;

import static testNames.CaseNames.CN_000;
import static testNames.CaseNames.CN_002;

/**
 * Created by sergey on 09.07.14.
 */

@RunWith(Cucumber.class)
@CucumberOptions(tags = {},format = {"pretty", "json:target/cucumber.json","html:target/cucumber.html"}, features = {"src/test/java/testClasses/demo/features/"})
public class CucumberRunner extends Base {

}
package runners;

import com.google.common.collect.ClassToInstanceMap;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import jdk.javadoc.doclet.Reporter;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {

                "src/test/java/resources"
        },
        glue = {
                "stepdefinitions"
        },
        /*tags = {"~@blocked",
                "~@ignore"
        },*/
        plugin = {
               /* "usage:target/results/usage.json",
                "pretty",
                "junit:target/results/test.xml",
                "json:target/results/test.json",
                "html:target/results/htmlreport/",
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"*/
        }
)

final class TestRunner {
}


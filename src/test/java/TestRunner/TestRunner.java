package TestRunner;

import org.junit.runner.RunWith;

import StepsDefinations.Excel;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features",glue={"StepsDefinations"})
public class TestRunner 
{
	
}

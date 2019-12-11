

package Runners;

	import org.junit.runner.RunWith;
	import cucumber.api.CucumberOptions;
	import cucumber.api.SnippetType;
	import cucumber.api.junit.Cucumber;
	
	@RunWith(Cucumber.class)
@CucumberOptions(
	dryRun = false,
	monochrome = true,
	strict = true,
	plugin = {"pretty", "json:target/teste.json"},
	snippets = SnippetType.CAMELCASE,
	features = {"classpath:features"},
	glue = {"classpath:Steps"},
	tags = {"@BRQ"}
)
public class RunnerTest {
}

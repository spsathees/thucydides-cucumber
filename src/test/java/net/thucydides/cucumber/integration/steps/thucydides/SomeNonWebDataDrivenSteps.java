package net.thucydides.cucumber.integration.steps.thucydides;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

import static net.thucydides.core.steps.StepData.withTestDataFrom;

public class SomeNonWebDataDrivenSteps {

    @Steps
    CheckValuesStep checkValueSteps;

    String dataSource;

    @Given("^the data in (.*)$")
    public void givenTheNamesIn(String dataSource) {
        this.dataSource = dataSource;
    }

    @When("^we enter this data$")
    public void whenWeEnterThisData() {}

    @Then("^the values should be correct$")
    public void thenTheValuesShouldBeCorrect() throws IOException {
        withTestDataFrom(dataSource).run(checkValueSteps).checkValues();
    }

}

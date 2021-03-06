package net.thucydides.cucumber.integration.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import net.thucydides.cucumber.integration.steps.thucydides.SampleSteps;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by john on 15/07/2014.
 */
public class StepInstantiationSteps {

    @Steps
    SampleSteps sampleSteps;

    @Given("I have a Cucumber feature file containing Thucydides @Steps fields")
    public void featureFileContainsStepsFields() {
    }

    @Then("the step fields should be instantiated")
    public void theStepFieldsShouldBeInstantiated() {
        assertThat(sampleSteps).isNotNull();
    }

    @Then("the nested pages objects should be instantiated")
    public void thePageObjectsShouldBeInstantiated() {
        assertThat(sampleSteps.pageObject).isNotNull();
    }

}

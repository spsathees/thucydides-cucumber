package net.thucydides.cucumber.util;

import cucumber.api.CucumberOptions;
import net.thucydides.cucumber.CucumberWithThucydides;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;
import net.thucydides.core.webdriver.SystemPropertiesConfiguration;
import org.junit.runner.Computer;
import org.junit.runner.JUnitCore;

import java.io.File;

/**
 * Created by john on 31/07/2014.
 */
public class CucumberRunner {

    public static void run(Class testClass) {
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.run(new Computer(), testClass);
    }

    public static cucumber.runtime.Runtime thucydidesRunnerForCucumberTestRunner(Class testClass, File outputDirectory) {
        return thucydidesRunnerForCucumberTestRunner(testClass, outputDirectory, new SystemEnvironmentVariables());
    }

    public static cucumber.runtime.Runtime thucydidesRunnerForCucumberTestRunner(Class testClass, File outputDirectory,
                                                                                 EnvironmentVariables environmentVariables) {
        ClassLoader classLoader = testClass.getClassLoader();
        ResourceLoader resourceLoader = new MultiLoader(classLoader);
        RuntimeOptionsFactory runtimeOptionsFactory = new RuntimeOptionsFactory(testClass, new Class[]{CucumberOptions.class});
        RuntimeOptions runtimeOptions = runtimeOptionsFactory.create();

        Configuration systemConfiguration = new SystemPropertiesConfiguration(environmentVariables);
        systemConfiguration.setOutputDirectory(outputDirectory);
        return CucumberWithThucydides.createThucydidesEnabledRuntime(resourceLoader, classLoader, runtimeOptions, systemConfiguration);
    }

    public static cucumber.runtime.Runtime thucydidesRunnerForCucumberTestRunner(Class testClass, Configuration systemConfiguration) {
        ClassLoader classLoader = testClass.getClassLoader();
        ResourceLoader resourceLoader = new MultiLoader(classLoader);
        RuntimeOptionsFactory runtimeOptionsFactory = new RuntimeOptionsFactory(testClass, new Class[]{CucumberOptions.class});
        RuntimeOptions runtimeOptions = runtimeOptionsFactory.create();

        return CucumberWithThucydides.createThucydidesEnabledRuntime(resourceLoader, classLoader, runtimeOptions, systemConfiguration);
    }

}


# Java + Selenium + Cucumber

Repository with all the best practices I've seen for Selenium, TestNG, JUnit, Cucumber, etc.


## Prerequisites

The user must have installed and configured Maven (Environment Variables) from the following site: https://allurereport.org/docs/install-for-windows/

## Running Tests

To generate the Allure report with the result of the execution, we can run the test cases from the TestRunner class or from the command line with Maven (Remember to change the value of the @):

```bash
  mvn clean verify test -Dcucumber.filter.tags=@CheckBox
```

The generated reports will appear in the path `target/allure-report/index.html`

In the path `src/test/resources/allure.properties` is the file where we can customize the configuration of the generated reports.
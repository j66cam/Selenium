
# Java + Selenium + Cucumber

Repository with all the best practices I've seen for Selenium, TestNG, JUnit, Cucumber, etc.


## Running Tests With The Cucumber Basic Report

To generate the Cucumber basic report with the result of the execution, we copy the following command in the terminal replacing the value of @ by the tag we want to execute:

```bash
  mvn clean test -Dcucumber.filter.tags=@CheckBox
```

- The link to the generated report will appear in the console.
- The report will expire in 24 hours if it is not associated with a valid Profile.

If we would like to execute the command from the IntelliJ terminal we must add single quotes like this:

```bash
  mvn clean test -D'cucumber.filter.tags=@CheckBox'
```
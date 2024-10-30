
# Java + Selenium + Cucumber

Repository with all the best practices I've seen for Selenium, TestNG, JUnit, Cucumber, etc.


## Running Tests

To generate the Cluecumber report with the result of the execution, we copy the following command in the terminal replacing the value of @ by the tag we want to execute:

```bash
  mvn clean verify test -D'cucumber.filter.tags=@CheckBox'
```

The generated report `index.html` will be located in the following path: `target/generated-report/`
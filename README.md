
# Java + Selenium + Cucumber

Repository with all the best practices I've seen for Selenium, TestNG, JUnit, Cucumber, etc.


## Running Tests

To generate the Extent report with the result of the execution, we can run the test cases from the TestRunner class or from the command line with Maven (Remember to change the value of the @):

```bash
  mvn clean verify test -Dcucumber.filter.tags=@CheckBox
```

The generated reports will appear in the path `target/SparkReport d_MMM_YYY/`

In the path `src/test/resources/extent.properties` is the file where we can customize the configuration of the generated reports.
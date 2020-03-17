### Code Coverage:
Code coverage is a software metric used to measure how many lines of our code are executed during automated tests.

### Jacoco tool:

1. Need to add `jacoco-maven-plugin` to the pom file

```
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>${jacoco.version}</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>prepare-package</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>

```
2. Source code:

``` java
package com.code_coverage;

public class DiscountCalculator {
	
	public double calculateDiscountAmt(final int purchaseAmt){
		if(purchaseAmt<0){
			throw new IllegalArgumentException("Purchasing Amount shoudn't be negative");
		}
		if(purchaseAmt >=20_000){
			return (purchaseAmt/10)*100;
		}
		return (purchaseAmt/5)*100;
		
	}
}
````

3. Unit Test:

``` java

package com.code_coverage;

import org.junit.Test;

public class DiscountCalculatorTest{
	
	private DiscountCalculator discountCalculator = new DiscountCalculator();
	
	@Test(expected=IllegalArgumentException.class)
	public void whenPurchaseAmt_IsNegative_ShouldThrow_IllegalArgumentException(){
		//Assert.fail("this is fail");
		discountCalculator.calculateDiscountAmt(-20);
	}
}

```

3. once we run junit tests by using `mvn test` it will create a coverage report in binary format in the target directory with filename `target/jacoco.exec`

4. To interpret `jacoco.exec` report file we have to user Sonar Qube. 

5. we can use `jacoco:report` goal to generate readable code coverage reports in several formats – e.g. HTML, CSV, and XML. 
   **but how?**
   5.1 run tests by using `mvn test jacoco:report` command then it creates **jacoco directory** in **target/site/** location. see below image for created files list
   
   ![JaCoCo Report Directory Structure](file:///jacoco_report_folder_structure.png)
   

	5.2 We can now take a look for example at target/site/jacoco/index.html page to see what the generated report looks like: it's like below
	![JaCoCo Report View in  Index html](file:///jacoco_report_view_in_index_html.png)
	**Note:** As I have only one package it's showing one package under Element Tab. If you have multiple packages then it will list down all the packages
	


### How Jacoco Works Internally?

JaCoCo runs as a Java agent, it is responsible for instrumenting the bytecode while running the tests. JaCoCo drills into each instruction and shows which lines are exercised during each test.


To gather coverage data, JaCoCo uses ASM for code instrumentation on the fly, receiving events from the JVM Tool Interface in the process:


It is also possible to run the JaCoCo agent in server mode, in this case, we can run our tests with jacoco:dump as a goal, to initiate a dump request.

## Need to get more info about internals.



### How to view coverage score at class level and method level?

When we click on `/target/site/jacoco/index.html` it will display default report page.

![JaCoCo Report View in  Index html](file:///jacoco_report_view_in_index_html.png)

In the above page you can see your **java package structure under Element Tab**, So you can navigate through the package to check the coverage at class level and method level. Once you click on class file it will show the detailed report for specific class by highlighting with different colors.

![Class level detailed view](file:///detailed_view_of_class_report.png)


### How to understand detailed report?





### How to improve score?
Now that we know a bit about how JaCoCo works, let's improve our code coverage score.

In order to achieve 100% code coverage we need to introduce tests, that covers the missing parts shown in the initial report:




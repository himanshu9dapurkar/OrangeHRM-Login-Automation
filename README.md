# OrangeHRM-Login-Automation
# TestNG DataProvider Example

This project demonstrates the use of **TestNG**'s `@DataProvider` annotation in a Selenium WebDriver test. The test attempts to log in to the [OrangeHRM Demo Site](https://opensource-demo.orangehrmlive.com) with multiple sets of credentials and validates the result.

## Project Structure

- **`src/test/java/TestNGPrac/DataProviderDemo.java`**: Contains the main test class with setup, teardown, and login test using `DataProvider`.

## Prerequisites

Before running the tests, ensure you have the following installed:

- **Java JDK 8 or higher**: [Download Java](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- **Maven**: [Download Maven](https://maven.apache.org/download.cgi)
- **ChromeDriver**: The version of ChromeDriver must match the version of the installed Chrome browser. [Download ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads)

## Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/TestNGDataProviderExample.git
    cd TestNGDataProviderExample
    ```

2. **Install dependencies**:
    ```bash
    mvn clean install
    ```

## Running the Tests

To execute the tests, run the following Maven command:

```bash
mvn test

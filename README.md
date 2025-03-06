# TestAutomationSuite

## 📌 Overview
TestAutomationSuite is a robust test automation framework designed for web applications using Selenium, TestNG, Cucumber (BDD), and ExtentReports. This project enables cross-browser testing, API testing, and detailed test reporting.

## 🏗️ Project Structure
```
TestAutomationSuite/
│-- src/
│   ├── main/java/ (Core framework logic)
│   ├── test/java/ (Test cases & Step Definitions)
│   ├── test/resources/ (Feature files, Configs, etc.)
│-- config/
│   ├── extent.properties (ExtentReports config)
│-- reports/ (Generated test reports)
│-- pom.xml (Maven dependencies & plugins)
│-- testng.xml (TestNG execution configuration)
```

## 🛠️ Tech Stack
- **Java** - Programming language
- **Selenium WebDriver** - UI automation
- **TestNG** - Test execution framework
- **Cucumber** - BDD framework
- **ExtentReports** - Test reporting
- **Maven** - Dependency management

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Maven installed and configured
- Chrome and Edge browsers installed

### Clone the Repository
```sh
git clone https://github.com/sunilkumarsukesan/TestAutomationSuite.git
cd TestAutomationSuite
```

### Install Dependencies
```sh
mvn clean install
```

### Run Tests
- **Run all tests using TestNG**:
  ```sh
  mvn test
  ```
- **Run Cucumber tests**:
  ```sh
  mvn test -Dcucumber.options="--tags @Regression"
  ```
- **Run specific test suite**:
  ```sh
  mvn test -DsuiteXmlFile=testng.xml
  ```

## 📊 Test Reports
- After execution, reports will be available in the **`reports/`** folder.
- Open `index.html` inside the reports folder to view Extent Reports.

## 🛠️ Configuration
- Update `extent.properties` for report customization.
- Modify `testng.xml` to include/exclude test cases.

## 🏗️ CI/CD Integration
- Can be integrated with **Jenkins** or **GitHub Actions** for automated execution.

## 📌 Contributing
- Fork the repository.
- Create a new branch.
- Commit your changes.
- Push to your branch and create a pull request.

---
Happy Testing! 🚀


# Serenity BDD Automation Framework

A test automation framework built using **Java**, **Serenity BDD**, **Cucumber**, **JUnit**, and **Maven** following industry best practices for scalable and maintainable test automation.

## 🚀 Tech Stack

- Java
- Serenity BDD
- Cucumber
- JUnit
- Maven
- Selenium WebDriver
- REST Assured
- GitHub Actions / Jenkins (ToDo)

---

## 📁 Project Structure

```text
src
├── test
│   ├── java
│   │   ├── runners
│   │   ├── stepdefinitions
│   │   ├── pages
│   │   ├── actions
│   │   └── utils
│   └── resources
│       ├── features
│       ├── testdata
│       └── serenity.conf
```

---

## ✅ Key Features

- BDD implementation using Cucumber
- Detailed Serenity Reports
- Page Object Model (POM)
- Reusable utilities and helper methods
- Cross-browser execution support
- Configurable test environments
- Easy integration with CI/CD pipelines
- Scalable and maintainable framework design

---

## Prerequisites

Before running the tests, ensure the following are installed:

- Java 17+ (or project-specific version)
- Maven
- Git
- Chrome Browser

Verify installations:

```bash
java -version
mvn -version
git --version
```

---


## Generate Serenity Reports

```bash
mvn serenity:aggregate
```

Generated report location:

```text
target/site/serenity/index.html
```

---

## Test Reports

Serenity automatically generates:

- Test Execution Summary
- Step-level Reporting
- Screenshots
- Failure Analysis
- Execution Statistics
---

## Best Practices Followed

- Page Object Model (POM)
- Separation of Test Data from Test Logic
- Reusable Components
- Meaningful Logging
- Clean Code Principles
- Easy Maintenance and Scalability

---

## CI/CD Integration

This framework can be integrated with:

- Jenkins
- GitHub Actions
- Azure DevOps
- GitLab CI/CD

---

## Author

**Tejas Kumar K**

Senior Software Development Engineer

`

# Brizy Test Automation Framework

This is a Java-based test automation framework designed for Brizy web application testing. The framework provides a
structured and scalable approach to writing and executing automated tests, allowing to efficiently validate the
functionality and behavior of the application;

# Features

* **Page Object Model**: The framework follows the Page Object Model design pattern to create a logical separation
  between the web pages and the test scripts, making the tests more maintainable and readable;
* **Cross-Browser Testing**: Brizy atf supports cross-browser testing, allowing to run tests on different web browsers
  such as Chrome, Firefox, and WebKit;
* **Data-Driven Testing**: It supports data-driven testing, enabling to execute tests with different sets of test data,
  enhancing test coverage and re-usability;
* **Dependency Injection**: It leverages Spring's DI capabilities, enabling managing and injection of dependencies
  seamlessly; This promotes loose coupling and facilitates easier test case maintenance;
* **Configuration Management**: Spring's configuration management capabilities are utilized to handle test environment
  settings, browser preferences, timeouts, and other parameters; This ensures flexibility and easy customization of the
  framework;
* **Reporting**: Detailed allure test reports with clear test execution results and logs are generated, helping to
  analyze and track the test progress effectively;
* **Parallel Execution**: Parallel test execution is supported, allowing to execute tests concurrently and reduce the
  overall test execution time;
* **Integration with Continuous Integration (CI) Tools**: The framework can be easily integrated with popular CI tools
  enabling seamless test execution as part of CI/CD pipeline;
* **Logging and Debugging**: It incorporates logging and debugging capabilities to facilitate troubleshooting and error
  analysis during test execution.

# Project structure

The project follows a multi-module Maven structure, providing a logical separation of components and enhancing
maintainability. The project structure is as follows:

├── **web-common** - Contains common utilities or shared code that can be used across the modules. \
├── **web-driver** - Includes code for managing browser configurations.         \
├── **web-interactions** - Follows POM pattern and focuses on encapsulating web pages, locators and elements. \
├── **web-reporting** - This module is responsible for generating reports during web testing or automation.      \
├── **web-test** - Contains the test cases or test suites for the application            \
└── **web-test-data** - Deals with managing test data required for web testing. It can include resources like sample
datasets, configuration files, or scripts to generate or manipulate test data. \

# Prerequisites

Before getting started ensure that the following prerequisites are met:

* Java Development Kit (JDK): Install JDK 17 or later;
* Apache Maven: Install Maven to manage the project's dependencies and build process.

# Getting Started

To start using the Automation Framework, follow these steps:

1. Clone the repository: `git clone https://github.com/bagrinsergiu/brizy-atf`
2. Install the required dependencies using Maven: `mvn clean compile install -DskipTests`
3. Run the tests using the command: `mvn test`
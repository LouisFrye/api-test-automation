# QA Test Automation Framework

This project is a **test automation framework** built with Java for automated API and UI testing.

It demonstrates modern QA automation practices including API testing, UI testing, test data management, reporting, and CI integration.

---

## Tech Stack

* Java
* Maven
* JUnit 5
* Selenium WebDriver
* REST Assured
* Allure Reports
* Git / GitHub
* GitHub Actions (CI)

---

## Project Structure

src
├── main
└── test
    ├── base
    ├── baseui
    ├── config
    ├── data
    ├── pages
    ├── tests
    └── utils

---

## Test Types

### API Tests

Automated API tests using REST Assured.

Examples:

* GET users
* GET user by ID
* Parameterized API tests

### UI Tests

Automated browser tests using Selenium.

Examples:

* Login success
* Login failure
* Screenshot on failure

---

## Test Execution

Run all tests:

mvn test

Run smoke tests:

mvn test -Djunit.jupiter.tags=smoke

Run API tests:

mvn test -Djunit.jupiter.tags=api

Run UI tests:

mvn test -Djunit.jupiter.tags=ui

---

## Allure Reporting

Generate report:

mvn allure:report

Open report:

target/site/allure-maven-plugin/index.html

---

## Features Implemented

* Page Object Model
* Test Data from JSON
* Parameterized Tests
* Screenshot on failure
* Allure reporting
* Test tagging (smoke / regression / api / ui)
* CI pipeline with GitHub Actions

---

## Purpose

This project was built as a **QA Automation learning project** to practice modern testing frameworks and tools used in real-world QA engineering roles.

# UI Testing Framework

A framework for conducting UI tests on a specific mock e-commerce website. The project is written in Java using Selenium, Cucumber, Spring, and Spring Boot. Key features include the implementation of a unique scope for the WebDriver bean and the use of AOP to switch between browser tabs. The project also utilizes Lombok, among other tools.

## Table of Contents

1. [Introduction](#introduction)
2. [Key Features](#Key-Features)
3. [Usage](#usage)
4. [Project Structure](#Installation-and-test-execution)


## Introduction

This framework is designed to facilitate UI testing on a specific mock e-commerce website. The primary goals are to ensure that the website's UI behaves as expected and to automate repetitive testing tasks.

### Key Features

- **Unique WebDriver Bean Scope**: Custom implementation to manage the WebDriver lifecycle.
- **AOP for Tab Switching**: Aspect-Oriented Programming (AOP) to handle browser tab switching.
- **Lombok**: Utilized for reducing boilerplate code.
- **Cucumber Scenario Outlines**: Used in feature files to parameterize tests.

## Installation and test execution

To get started with the project, clone the repository and install the required dependencies:

```sh
./mvnw clean install
./mvn test

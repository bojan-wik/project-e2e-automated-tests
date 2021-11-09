# project-e2e-automated-tests

It is a framework (e2e) which automates testing of an online shop (http://automationpractice.com/index.php) using Java code (Maven, PageObject pattern) and Selenium.
I created this project for my Java and Selenium learning. Due to that it contains a lot of private notes and comments which helps me in the process.
Goal of the project is to create a fully functional testing framework and learn as much as possible in the meantime.

## Getting Started

### Prerequisites

* at least Java 8;
* Maven 3;
* Intellij;

### Framework structure

```
src>main>java>pageobjects>***Page.java -> web objects from store application (per page)
src>main>resources> -> non-code property/config files for the framework
src>test>java>tests>***Tests.java -> tests for store application (per page or per feature)
src>test>java>tests>alpha> -> drafts of tests (in the form of scripts)
```

## Author

* **Wiktor Bojanowski**
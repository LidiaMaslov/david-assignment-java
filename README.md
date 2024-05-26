# Selenium on Java tests

## Demonstration Video

Watch the [YouTube Video](https://youtu.be/0duadxJvgX0)

## Install Maven

```brew install maven```

## How to run tests

```HEADLESS=false mvn test```

### Created a Development Docker

- docker-compose.yaml
    - Java testing environment

### Introduction

My goal is to make my tests as human-readable as possible. Please look at `src/test/java/com/app/AssignmentTests.java`. Those tests are a bit different than typical Selenium tests, I tried to make improvements over classic approach. But I have no problem maintaining and supporting codebase with their own technical decisions.

The main problem with the Page Object model is that it's hard to maintain. As classes grow, developers tend to add more methods and locators, sometimes under different names.

If the application uses a consistent component-based design like Vue or React, it's easier to develop a reusable component system. 

However, for example older Ruby On Rails projects often have copy-paste HTML where similarly looking components are structured differently and are not compatible.

When creating a method, I consider where it should go:

- Non-reusable methods go to the test class code.
- Reusable methods belong in the page object, base page, components, or utilities.
- I organize my code with 
    - Navigation Classes
    - Components
    - Page Objects 
    - Page Sections for nested logic 
    - Utilities
        - Component Finders
        - Handlers
        - Helpers

Components help me build higher-level objects that simplify interactions with the component logic, making them as easy to use as WebElements. 

For example, using `settingsPage.findToggle("Use SSL").toggleOn();` is an efficient way to manage dynamic components like lists and tables. This approach prevents the clutter of methods like `settingsPage.toggleOnUseSSL()`, which are difficult to read and can overload the page objects with too many methods. 

It also helps balance the code between tests and page objects, leading to fewer bugs and faster development of new tests.

*Cypress* does a lot to prevent flaky tests, unlike Selenium which does the bare minimum. For instance, Cypress will scroll through a list to find an element, while Selenium will only search the visible part and may fail if the element is not in view.

I hope you would like my project!
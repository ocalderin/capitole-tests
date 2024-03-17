# Automated Web Tests 

#### **Overview:**
The purpose of this project is to create a solution that executes the automated web tests requested in the technical test. It was developed 
using Java, Maven, Selenium, and Docker. The architecture of the solution follows what is defined by the Page Objects Model design pattern,
one of the most used design patterns when developing an automated tests framework. Also, Cucumber was used to create the test cases
following the Behavior Driven Development testing approach.

#### **Technologies Used:**
* Maven: Project management and build tool.
* Java: Programming language used for test automation.
* Selenium WebDriver: Web UI testing framework.
* Docker: Tool used to build, share, and run container applications.
* Cucumber: Tool that supports Behavior Driven Development.

#### **Prerequisites:**
Ensure the following tools are installed on your machine:
* Java JDK (version 17 or higher)
* Maven
* Docker

Also, if you want to run the tests locally you will need to install the browser where the tests will run.
Currently, the framework can run the tests locally on Chrome, Firefox, Edge, and Safari.

#### **Project Structure:**
* **src/test/java:** Java source code for test classes.
* **src/test/resources:** Features and config files.
* **.github/workflows/main.yml:** GitHub Action definition file.
* **pom.xml:** Maven project object model file.
* **docker-compose.yml:** Docker compose file to run the test remotely.
* **docker-compose-arm.yml:** Docker compose file to run the test remotely (for Mac with an Apple Silicon chip).
* **Dockerfile:** Dockerfile to build the container where the tests will run.
* **reports:** Reports folder.
* **images:** Screenshots folder.
* **logs:** Logs generated by test execution.

#### **Configuration:**
You can find the configuration file at **src/test/resources**.
On this file, you can select the browser where the tests will be running. Currently, in local executions, you can use
Chrome, Firefox, Edge, and Safari. Safari can not be used to do remote executions.

#### **Running the tests:**
1. Clone the repository
```bash
git clone https://github.com/ocalderin/capitole-tests.git
```
2. Move to the folder that contains the automated tests code

3. Execute the tests (Locally)

**All the tests**
```bash
mvn clean test
```

**By feature**
```bash
mvn clean test -Dtest=com.capitole.capitoletests.runners.RunnerWebTests
```

You can run the tests in headless mode by setting the headless parameter. The accepted values are
**true** or **false**. This value is false by default.
```bash
mvn clean test -Dheadless=true
```

Execute the tests (Remotely)
```bash
docker compose up --build --exit-code-from tests
```

If you are using a Mac with an Apple Silicon chip you must use the **docker-compose-arm-yml** file
```bash
docker compose -f docker-compose-arm.yml up --build --exit-code-from tests
```

#### **Reporting:**
When the execution finishes a report file with the test results is generated
at this path **reports/cucumber-report/web-report.html**

Also, the screenshots taken by the automated tests are saved in the folder **images**

#### **GitHub Actions:**
Additionally, you can also run the automated tests on GitHub, using GitHub Actions. To do that:
1. Go to https://github.com/ocalderin/capitole-tests
2. Create a fork
![Captura de pantalla 2024-03-17 a las 7 49 23 p  m](https://github.com/ocalderin/capitole-tests/assets/12141626/eff2d6f7-ff21-444d-b287-5ff32440c4a2)
3. Click on the Actions button   
![Captura de pantalla 2024-03-17 a las 12 11 06 p  m](https://github.com/ocalderin/capitole-tests/assets/12141626/c29beae2-0933-4cd8-990d-14b6a9f14e75)
4. Select the **Running Web Automated Tests** workflow
![Captura de pantalla 2024-03-17 a las 12 19 19 p  m](https://github.com/ocalderin/capitole-tests/assets/12141626/a193c258-a245-4386-9d02-fb9d3efc49fa)
5. Run the workflow by clicking on the Run workflow button and then selecting the branch (main is used by default), and then clicking on the Run workflow button (green button)
![Captura de pantalla 2024-03-17 a las 12 21 19 p  m](https://github.com/ocalderin/capitole-tests/assets/12141626/0597c302-f0c0-4d7e-b1b6-7d9b13fefc5f)
6. Select the running workflow
![Captura de pantalla 2024-03-17 a las 12 24 38 p  m](https://github.com/ocalderin/capitole-tests/assets/12141626/2163713f-8d7d-45b8-b773-b81b100a230e)
7. Select the running job
![Captura de pantalla 2024-03-17 a las 12 25 50 p  m](https://github.com/ocalderin/capitole-tests/assets/12141626/e3a2e576-cd3b-4546-aa94-89edcf4b432f)

In this screen, you will be able to see all the logs related to your workflow execution
![Captura de pantalla 2024-03-17 a las 12 26 56 p  m](https://github.com/ocalderin/capitole-tests/assets/12141626/3df0220e-a037-4d6c-94ba-b1449e36de6f)

The screenshots taken and the report generated by the test execution will be ready to download on the Summary screen
1. Click on the Summary button
![Captura de pantalla 2024-03-17 a las 12 29 34 p  m](https://github.com/ocalderin/capitole-tests/assets/12141626/4455bc61-6e8c-4804-937b-b04037358818)
2. Download the artifacts
![Captura de pantalla 2024-03-17 a las 12 30 54 p  m](https://github.com/ocalderin/capitole-tests/assets/12141626/5034e0be-d5e5-4931-919f-924b1755cb7a)

**This GitHub Action is also executed automatically when you push any change on the main branch**
   

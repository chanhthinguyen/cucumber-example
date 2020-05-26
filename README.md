# Netflix PI QA Automation
 
This README file documents the information required to get started with the QA automation for the [Netflix PI Middleware](https://bitbucket.org/truedmp/netflix-pi-middleware/src/master/) project.
 
## Table of Contents 
 
- [Introduction](#markdown-header-introduction)
- [Prerequisites](#markdown-header-prerequisites)
- [Getting Started](#markdown-header-getting-started)
- [Repository Structure](#markdown-header-repository-structure)
- [Testing Cases](#markdown-header-testing-cases)
     - [Add New Test Cases](#markdown-header-add-new-test-cases)
     - [Add New Test Data](#markdown-header-add-new-test-data)
     - [Add the Environment Configuration](#markdown-header-add-the-environment-configuration)
     - [Run the Test Case](#markdown-header-run-the-test-case)
     - [Check Test Reports](#markdown-header-check-test-reports)
- [Contribution Guidelines](#markdown-header-contribution-guidelines)
     - [Create a Git Branch](#markdown-header-create-a-git-branch)
     - [Code Review](#markdown-header-code-review)
- [Additional Resources](#markdown-header-additional-resources)
- [Deployment](#markdown-header-deployment)
- [Contributors](#markdown-header-contributors)
 
## Introduction
This repository is used to run automated testing on the following APIs, which are created and consumed by the Netflix PI Middleware:
- [`GET /accounts`](src/test/java/api/account/get/GetAccountInfo.java)
- [`POST /accounts`](src/test/java/api/account/post/PostAccountInfo.java)
 
## Prerequisites
 
To run automated test cases for Netflix PI APIs you require the following prerequisites:
 
- Java
 
```shell
brew cask install java
```
- Maven
 
```shell
brew install maven
```
 
## Getting Started
 
To get started with running the automated test cases:
 
1. Clone project into your local:
 
     ```shell
     git clone git@bitbucket.org:truedmp/netflix-pi-qa-automation.git
     ```
 
2. Run test cases for different {environment-values} such as `dev`, `alpha`, `preprod`, and `prod`:
 
   ```shell
   mvn test -Denv={environment}
   ```
 
   The message `BUILD FAILURE` or `BUILD SUCCESS` is shown based on the test case result. For more information on checking the test results, see section, [Check Test Reports](#markdown-check-test-reports).
 
**NOTE:** The `preprod` and `prod` environment are not yet setup.
 
## Repository Structure
 
The Netflix QA automation repository comprises the following folders and files:
 
- [`src/main/java/common/models`](src/main/java/common/models): It contains the [`Common.java`](src/main/java/common/models/Common.java) model, which is a set of [`Accounts`]((src/main/java/common/models/Accounts.java)), [`Configuration`]((src/main/java/common/models/Configuration.java)), and [`NetflixHeader`]((src/main/java/common/models/NetflixHeader.java)) models. 
 
- [`src/main/java/common/utils`](src/main/java/common/utils): It contains the [`helper.java`](src/main/java/common/utils/helper.java) that contains the common functions to form the `Common` model based on the environment.
 
- [`src/main/resources`](src/main/resources): It contains the configuration and test data for alpha and dev environments. 
 
- [`src/test/java/api/account`](src/test/java/api/account): It contains the test cases for [`GET`](src/test/java/api/account/get/GetAccountInfo.java) and [`POST`](src/test/java/api/account/post/PostAccountInfo.java) requests.
 
- [`pom.xml`](pom.xml): It contains information about the project including all dependencies.
 
## Testing Cases
 
To run test cases, first install the [prerequisites](#markdown-header-prerequisites) and [cloning the repository](#markdown-header-getting-started).
 
The following subsections explain working with test cases, test data, environment configuration, and test reports.
 
### Add New Test Cases
 
To add test cases for your APIs:
 
1. Add a folder `{modelName}` under the [`test/java/api`](test/java/api) directory. The valid values for {modelName} are `accounts`, `purchases`, and `subscribers`.
2. Add test cases for different API methods inside the newly-created directory.
 
**Note:** Make sure to add all test cases mentioned in the [Netflix Middleware: Test case coverage](https://truedmp.atlassian.net/wiki/spaces/AP/pages/934183444/Netflix+Middleware+-+Test+case+coverage) document.
 
### Add New Test Data
 
You can find test data for the `netflixheader` and `otttoken` object in the [src/main/resources/data](src/main/resources/data) folder. You can use different data to verify test cases on the `alpha` and `dev` environments. 
 
The `netflixheader` comprises the following values:
- X-Netflix-Header-Authorization
- X-Netflix-AuthorizationTime
- X-Netflix-PartnerDeviceIdentifier
 
The `otttoken` comprises the following values:
- ott_token
- pdi
 
To add test data:
 
1. Go to the JSON file [src/main/resources/data/{env}/{folder}/data-test.json](src/main/resources/data/netflixheader/data-test.json), where {env} is `alpha` or `dev` and {folder} is `netflixheader` or `otttoken`.
 
2. Add a valid new object.
 
**IMPORTANT:** For more information on how to generate **Netflix header** and **OTT tokens**, see the [FAQ: Testing](https://truedmp.atlassian.net/wiki/spaces/AP/pages/948568598/FAQ+Netflix+PI+Testing) document.
 
### Add the Environment Configuration
 
To add configuration for a new environment:
 
1. Go to `src/main/resources/config` folder.
2. Add a new folder `preprod` or `prod`.
3. Create a copy of the `config/alpha/env-config.json` file in the new folder.
4. Edit the newly created configuration file `env-config.json`.
 
### Run the Test Case
 
For more information on running the test cases, see the [Getting Started](#markdown-header-getting-started) section.
 
To skip an API during testing:
 
1. Go to the [`src/test/java/testsuite/AllApiTest.java`](src/test/java/testsuite/AllApiTest.java) file.
2. Comment the API that you want to skip during testing.
 
### Check Test Reports
 
You can get the following two test reports under the `target > surefire-reports` folder:
 
- `Surefire test.html`
- `emailable-report.html`
 
**NOTE:** The `emailable-report.html` file displays the response time for each API call.
 
## Contribution Guidelines
 
To contribute to this repository, first install the [prerequisites](#markdown-header-prerequisites) and clone the repository.
 
### Create a Git Branch
 
Create a branch from the `master` branch.
 
```shell
gco -b feature/NETFLIX20--post-accounts
```
 
**Note:** To add a new test case, it is recommended that the branch name follows the naming convention,`feature/{JIRA_taskName}`. For example, `NETFLIX20--post-accounts`.
 
### Code Review
 
Submit your PR to **Thi Nguyen** for review. Once reviewed, it will be approved and merged to the `master` branch.
 
## Additional Resources
The following is a list of additional resources for the project:
 
- [Apache Maven Project](https://maven.apache.org/)
- [Getting Started: Rest Assured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)
- [Configure `bitbucket-pipelines.yml`](https://confluence.atlassian.com/bitbucket/configure-bitbucket-pipelines-yml-792298910.html)
 
## Deployment
 
The [Netflix PI Middleware](https://bitbucket.org/truedmp/netflix-pi-middleware/src/develop/) pipeline runs automated tests for the `GET /accounts` and `POST /accounts` APIs.
 
For more information on the pipeline, see the [`bitbucket-pipelines.yml`](bitbucket-pipelines.yml) file.
 
## Contributors
This following is a list of contributors to the [Netflix QA Automation]() repository:

- Repository Owner: [Thi Nguyen](thi@wizeline.com)
- Contributors: [Payal Dhiman](payal.dhiman@wizeline.com)
 

/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codenvy.ide.test;

import com.codenvy.ide.shared.GWTIDConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * New Project Creation Test
 */
public class NewWSO2AppServerProjectCreation {
	private static final Logger logger =
			LoggerFactory.getLogger(NewWSO2AppServerProjectCreation.class);

	final WebDriver driver;

	@FindBy(how = How.ID, using = GWTIDConstants.WSO2_FILE_MENU_ID)
	WebElement wso2FileMenu;
	@FindBy(how = How.ID, using = GWTIDConstants.WSO2_FILE_NEW_OPTION_ID)
	WebElement wso2NewOption;
	@FindBy(how = How.ID, using = GWTIDConstants.WSO2_NEW_PROJECT_OPTION_ID)
	WebElement wso2NewProjectOption;
	@FindBy(how = How.ID, using = GWTIDConstants.WSO2_NEW_PROJECT_NAME_OPTION_ID)
	WebElement wso2NewProjectName;
	@FindBy(how = How.ID, using = GWTIDConstants.WSO2_NEW_PROJECT_DESCRIPTION_ID)
	WebElement wso2NewProjectDescrption;
	@FindBy(how = How.XPATH, using = GWTIDConstants.WSO2_NEW_PROJECT_OPTIONS_DROP_DOWN_XPATH)
	WebElement wso2NewProjectCategoriesList;
	@FindBy(how = How.XPATH, using = GWTIDConstants.PROJECT_CREATION_WIZARD_NEXT_BUTTON_XPATH)
	WebElement wso2NewProjectNextButton;
	@FindBy(how = How.ID, using = GWTIDConstants.WSO2_NEW_PROJECT_ARTIFACTID_ID)
	WebElement wso2NewProjectArtifactId;
	@FindBy(how = How.ID, using = GWTIDConstants.WSO2_NEW_PROJECT_GROUPID_ID)
	WebElement wso2NewProjectGroupId;
	@FindBy(how = How.ID, using = GWTIDConstants.WSO2_NEW_PROJECT_VERION_ID)
	WebElement wso2NewProjectVersionId;
	@FindBy(how = How.XPATH, using = GWTIDConstants.PROJECT_CREATION_WIZARD_CREATE_BUTTON_XPATH)
	WebElement wso2NewProjectCreateButton;
	WebElement wso2NewProject;

	public NewWSO2AppServerProjectCreation(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * tests the WSO2 App Server project creation UI
	 *
	 * @throws Exception
	 */
	public void createNewWSO2AppServerProject() {

		try {
			for (int projectTypeOrder = 1; projectTypeOrder <= GWTIDConstants.noOfAppServerProjects; projectTypeOrder++) {
				wso2FileMenu.click();
				wso2NewOption.click();
				wso2NewProjectOption.click();
				wso2NewProjectCategoriesList.click();
				String dynamicProjectXpath = GWTIDConstants.WSO2_NEW_PROJECT_TYPE_XPATH + "div[" + projectTypeOrder +"]";
				wso2NewProject = driver.findElement(By.xpath(dynamicProjectXpath));
				wso2NewProject.click();
				String projectType = driver.findElement(By.xpath(dynamicProjectXpath)).getText();
				if (projectType
						.equals(GWTIDConstants.JAX_RS_PROJECT_TYPE)) { // because the x path for the project type might change
					enterJAXRSProjectDetails();
				} else if (projectType.equals(GWTIDConstants.JAX_WS_PROJECT_TYPE)) {
					enterJAXWSProjectDetails();
				} else if (projectType.equals(GWTIDConstants.WEB_APP_PROJECT_TYPE)) {
					enterWebAppProjectDetails();
				}
			}

		} catch (TimeoutException toe) {
			WebDriverWait wait = new WebDriverWait(driver, GWTIDConstants.WAITING_TIME_CONSTANT);
			wait.until(ExpectedConditions.elementToBeClickable(wso2FileMenu));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewOption));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectOption));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectCategoriesList));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProject));
		} catch (Exception e) {
			logger.error(
					"An exception was thrown in running the UI test on App server Project creation", e);
		}
	}

	/**
	 * tests the JAX RS Project creation wizard
	 */
	public void enterJAXRSProjectDetails() {
		try {
			wso2NewProjectName.sendKeys(GWTIDConstants.TEST_JAXRS_PROJECT_NAME);
			wso2NewProjectDescrption.sendKeys(GWTIDConstants.TEST_PROJECT_DESCRIPTION);
			wso2NewProjectNextButton.click();
			wso2NewProjectArtifactId.sendKeys(GWTIDConstants.TEST_PROJECT_ARTIFACT_ID);
			wso2NewProjectGroupId.sendKeys(GWTIDConstants.TEST_PROJECT_GROUP_ID);
			wso2NewProjectVersionId.sendKeys(GWTIDConstants.TEST_PROJECT_VERSION_ID);
			wso2NewProjectCreateButton.click();
		} catch (TimeoutException toe) {
			WebDriverWait wait = new WebDriverWait(driver, GWTIDConstants.WAITING_TIME_CONSTANT);
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectName));
			wait.until(ExpectedConditions.elementToBeSelected(wso2NewProjectDescrption));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectNextButton));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectArtifactId));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectGroupId));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectVersionId));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectCreateButton));
		} catch (Exception e) {
			logger.error(
					"An exception was thrown in running the UI test on JAX RS Project creation", e);
		}
	}

	/**
	 * tests the JAX WS Project creation wizard
	 */
	public void enterJAXWSProjectDetails() {
		try {
			wso2NewProjectName.sendKeys(GWTIDConstants.TEST_JAXWS_PROJECT_NAME);
			wso2NewProjectDescrption.sendKeys(GWTIDConstants.TEST_PROJECT_DESCRIPTION);
			wso2NewProjectNextButton.click();
			wso2NewProjectArtifactId.sendKeys(GWTIDConstants.TEST_PROJECT_ARTIFACT_ID);
			wso2NewProjectGroupId.sendKeys(GWTIDConstants.TEST_PROJECT_GROUP_ID);
			wso2NewProjectVersionId.sendKeys(GWTIDConstants.TEST_PROJECT_VERSION_ID);
			wso2NewProjectCreateButton.click();
		} catch (TimeoutException toe) {
			WebDriverWait wait = new WebDriverWait(driver, GWTIDConstants.WAITING_TIME_CONSTANT);
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectName));
			wait.until(ExpectedConditions.elementToBeSelected(wso2NewProjectDescrption));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectNextButton));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectArtifactId));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectGroupId));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectVersionId));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectCreateButton));
		} catch (Exception e) {
			logger.error(
					"An exception was thrown in running the UI test on JAX WS Project creation", e);
		}
	}

	/**
	 * tests the Web App Project creation wizard
	 */
	public void enterWebAppProjectDetails() {
		try {
			wso2NewProjectName.sendKeys(GWTIDConstants.TEST_WEBAPP_PROJECT_NAME);
			wso2NewProjectDescrption.sendKeys(GWTIDConstants.TEST_PROJECT_DESCRIPTION);
			wso2NewProjectNextButton.click();
			wso2NewProjectArtifactId.sendKeys(GWTIDConstants.TEST_PROJECT_ARTIFACT_ID);
			wso2NewProjectGroupId.sendKeys(GWTIDConstants.TEST_PROJECT_GROUP_ID);
			wso2NewProjectVersionId.sendKeys(GWTIDConstants.TEST_PROJECT_VERSION_ID);
			wso2NewProjectCreateButton.click();
		} catch (TimeoutException toe) {
			WebDriverWait wait = new WebDriverWait(driver, GWTIDConstants.WAITING_TIME_CONSTANT);
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectName));
			wait.until(ExpectedConditions.elementToBeSelected(wso2NewProjectDescrption));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectNextButton));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectArtifactId));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectGroupId));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectVersionId));
			wait.until(ExpectedConditions.elementToBeClickable(wso2NewProjectCreateButton));
		} catch (Exception e) {
			logger.error(
					"An exception was thrown in running the UI test on Web Application Project creation", e);
		}
	}

	//need to delete the created projects once integrated
}

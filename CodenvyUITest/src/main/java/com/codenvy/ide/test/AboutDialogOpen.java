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

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codenvy.ide.shared.GWTIDConstants;

/**
 * opens the about action on the UI
 */
public class AboutDialogOpen {

	private static Logger logger = LoggerFactory.getLogger(AboutDialogOpen.class);

	final WebDriver driver;
	// Create web elements using GWT IDs
	@FindBy(how = How.ID, using = GWTIDConstants.WSO2_DEV_STUDIO_GWT_ID)
	WebElement wso2DevStudioAction;
	@FindBy(how = How.ID, using = GWTIDConstants.WSO2_ABOUT_ACTION_GWT_ID)
	WebElement wso2AboutAction;
	@FindBy(how = How.ID, using = GWTIDConstants.WSO2_ABOUT_ACTION_SELECTION_CLICK_ID)
	WebElement wso2AboutActionClick;
	@FindBy(how = How.ID, using = GWTIDConstants.WSO_ABOUT_ACTION_CLOSE_BUTTON_ID)
	WebElement wso2AboutActionClose;

	public AboutDialogOpen(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Select the WSO2 Developer Studio menu
	 *
	 * @throws Exception
	 */
	public void selectWSO2DevStudioMenu() throws Exception {

		try {
			wso2DevStudioAction.click();
			wso2AboutAction.click();
			wso2AboutActionClick.click();
			wso2AboutActionClose.click();

		} catch (TimeoutException toe) {
			WebDriverWait wait = new WebDriverWait(driver, GWTIDConstants.WAITING_TIME_CONSTANT);
			wait.until(ExpectedConditions.elementToBeClickable(wso2DevStudioAction));
			wait.until(ExpectedConditions.elementToBeClickable(wso2AboutAction));
			wait.until(ExpectedConditions.elementToBeClickable(wso2AboutActionClick));

		} catch (Exception e) {
			logger.error("An exception was thrown in running the UI test on About dialog", e);
		}

	}

}

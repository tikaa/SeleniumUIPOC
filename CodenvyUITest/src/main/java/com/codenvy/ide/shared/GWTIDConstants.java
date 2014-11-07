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
package com.codenvy.ide.shared;

/**
 * Defines constants
 */
public interface GWTIDConstants {

	/*Testing about menu popup*/
	String WSO2_DEV_STUDIO_GWT_ID = "gwt-debug-MainMenu/wso2ActionGroup";
	String WSO2_ABOUT_ACTION_GWT_ID = "gwt-debug-topmenu/WSO2 Developer Studio/wso2AboutAction";
	String WSO2_ABOUT_ACTION_SELECTION_CLICK_ID = "topmenu/WSO2 Developer Studio/About";
	String WSO_ABOUT_ACTION_CLOSE_BUTTON_ID = "gwt-debug-ABOUT-OK-BUTTON-ID";

	/*Testing creating a new project*/
	String WSO2_FILE_MENU_ID = "gwt-debug-MainMenu/FileGroup";
	String WSO2_FILE_NEW_OPTION_ID = "topmenu/File/New";
	String WSO2_NEW_PROJECT_OPTION_ID = "topmenu/File/New/Project...";
	String WSO2_NEW_PROJECT_NAME_OPTION_ID = "gwt-debug-file-newProject-projectName";
	String WSO2_NEW_PROJECT_DESCRIPTION_ID = "gwt-debug-file-newProject-projectDescription";
	String WSO2_NEW_PROJECT_OPTIONS_DROP_DOWN_XPATH =
			"//span[contains(.,'WSO2 APPLICATION SERVER')]";
	String WSO2_NEW_PROJECT_TYPE_XPATH =
			"//div/div[1]/div/div/div[2]/div/div[3]/div/div[2]/div/div/div[1]/div[2]/";
	String WSO2_NEW_PROJECT_ARTIFACTID_ID = "gwt-debug-mavenPageView-artifactId";
	String WSO2_NEW_PROJECT_GROUPID_ID = "gwt-debug-mavenPageView-groupId";
	String WSO2_NEW_PROJECT_VERION_ID = "gwt-debug-mavenPageView-version";

	String PROJECT_CREATION_WIZARD_NEXT_BUTTON_XPATH = "//button[contains(.,'Next')]";
	String PROJECT_CREATION_WIZARD_CREATE_BUTTON_XPATH = "//button[contains(.,'CREATE')]";

	String TEST_JAXRS_PROJECT_NAME = "Test_JAX_RS_Project";
	String TEST_JAXWS_PROJECT_NAME = "Test_JAX_WS_Project";
	String TEST_WEBAPP_PROJECT_NAME = "Test_WEB_APP_Project";
	String TEST_PROJECT_DESCRIPTION = "Testing Description";
	String TEST_PROJECT_ARTIFACT_ID = "sampleproject";
	String TEST_PROJECT_GROUP_ID = "org.wso2.test.project";
	String TEST_PROJECT_VERSION_ID = "1.0.0";

	String JAX_RS_PROJECT_TYPE = "JAX RS Project";
	String JAX_WS_PROJECT_TYPE = "JAX WS Project";
	String WEB_APP_PROJECT_TYPE = "Java Web Application";

	int WAITING_TIME_CONSTANT = 15;
	int noOfAppServerProjects = 3;

	String WEB_APP_URL = "http://localhost:50692/ide";
			// retrieve this from the properties file once integrated

}

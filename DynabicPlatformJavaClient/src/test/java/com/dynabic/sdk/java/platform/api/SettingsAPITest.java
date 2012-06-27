package com.dynabic.sdk.java.platform.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;

import com.dynabic.sdk.java.platform.model.SettingRequest;
import com.dynabic.sdk.java.platform.model.SettingResponse;
import com.dynabic.sdk.java.platform.model.SettingsSettingsInput;
import com.wordnik.swagger.runtime.exception.APIException;

@Category(IntegrationTest.class)
public class SettingsAPITest extends AbstractIntegrationTest {

	private List<SettingResponse> settings;

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUpSettings() throws APIException {
		log("Setting up Settings...");
		settings = SettingsAPI.GetSettings(testData.subdomain);
		Assert.assertNotNull(settings);
		Assert.assertTrue(settings.size() > 0);

		log("Executing test case " + testName.getMethodName() + "()");
	}

	@Test
	public void GetDefaultSetting() throws APIException {
		SettingResponse response = SettingsAPI.GetDefaultSetting(settings.get(0).getName());
		Assert.assertNotNull(response);
	}

	@Test
	public void GetSettingById() throws APIException {
		SettingResponse response = SettingsAPI.GetSettingById(testData.subdomain, settings.get(0).getId().toString());
		Assert.assertNotNull(response);
	}

	@Test
	public void GetSettingByName() throws APIException {
		SettingResponse response = SettingsAPI.GetSettingByName(testData.subdomain, settings.get(0).getName());
		Assert.assertNotNull(response);
	}

	@Test
	public void GetSettings() throws APIException {
		Assert.assertNotNull(settings.get(0).getId());
	}

	@Test
	public void UpdateSetting() throws APIException {
		SettingRequest postData = new SettingRequest();
		postData.setSite_id(testData.siteId);
		postData.setName(settings.get(0).getName());
		postData.setValue(settings.get(0).getValue());
		postData.setDescription(settings.get(0).getDescription() + "_updated");
		SettingResponse updatedSetting = SettingsAPI.UpdateSetting(testData.subdomain, settings.get(0).getId().toString(), postData);
		Assert.assertNotNull(updatedSetting);
		Assert.assertEquals(updatedSetting.getDescription(), postData.getDescription());
	}

	@Test
	public void UpdateSettingWithExplicitParameters() throws APIException {
		SettingsSettingsInput postData = new SettingsSettingsInput();
		postData.setSettingId(settings.get(0).getId().toString());
		postData.setSiteSubdomain(testData.subdomain);
		postData.setSettingDescription(settings.get(0).getDescription() + "_updated");
		postData.setSettingName(settings.get(0).getName());
		postData.setSettingValue(settings.get(0).getValue() + "_updated");
		SettingResponse updatedSetting = SettingsAPI.UpdateSettingWithExplicitParameters(postData);
		Assert.assertNotNull(updatedSetting);
		Assert.assertEquals(updatedSetting.getDescription(), postData.getSettingDescription());
	}

	@Test
	public void UpdateSettingWithExplicitParameters2() throws APIException {
		String newValue = settings.get(0).getValue() + "_updated";
		SettingResponse updatedSetting = SettingsAPI.UpdateSettingWithExplicitParameters2(testData.subdomain, settings.get(0).getId().toString(), newValue);
		Assert.assertNotNull(updatedSetting);
		Assert.assertEquals(updatedSetting.getValue(), newValue);
	}
}

package com.dynabic.sdk.java.platform.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.dynabic.sdk.java.platform.model.CompanyInfoRequest;
import com.dynabic.sdk.java.platform.model.CompanyInfoResponse;
import com.wordnik.swagger.runtime.exception.APIException;

@Category(IntegrationTest.class)
public class CompanyinfoAPITest extends AbstractIntegrationTest {

	{
		runSetup = false;
	}

	@Test
	public void GetCompanyInfo() throws APIException {
		CompanyInfoResponse companyInfo = CompanyinfoAPI.GetCompanyInfo();
		Assert.assertNotNull(companyInfo);
	}

	@Test
	public void UpdateCompanyInfo() throws APIException {
		CompanyInfoResponse companyInfo = CompanyinfoAPI.GetCompanyInfo();
		Assert.assertNotNull(companyInfo);

		CompanyInfoRequest postData = new CompanyInfoRequest();
		postData.setCountry(companyInfo.getCountry());
		postData.setCulture(companyInfo.getCulture());
		postData.setCurrency(companyInfo.getCurrency());
		postData.setEmail(companyInfo.getEmail());
		postData.setPhone(companyInfo.getPhone());
		postData.setTimezone(companyInfo.getTimezone());
		postData.setName(companyInfo.getName() + "_updated");
		CompanyInfoResponse updatedCompanyInfo = CompanyinfoAPI.UpdateCompanyInfo(postData);
		Assert.assertNotNull(updatedCompanyInfo);
		Assert.assertEquals(updatedCompanyInfo.getName(), postData.getName());

		// restore previous values
		postData = new CompanyInfoRequest();
		postData.setCountry(companyInfo.getCountry());
		postData.setCulture(companyInfo.getCulture());
		postData.setCurrency(companyInfo.getCurrency());
		postData.setEmail(companyInfo.getEmail());
		postData.setPhone(companyInfo.getPhone());
		postData.setTimezone(companyInfo.getTimezone());
		postData.setName(companyInfo.getName());
		updatedCompanyInfo = CompanyinfoAPI.UpdateCompanyInfo(postData);
		Assert.assertNotNull(updatedCompanyInfo);
		Assert.assertEquals(updatedCompanyInfo.getName(), companyInfo.getName());
	}
}

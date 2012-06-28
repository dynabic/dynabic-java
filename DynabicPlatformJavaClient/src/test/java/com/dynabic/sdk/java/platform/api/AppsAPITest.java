package com.dynabic.sdk.java.platform.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.dynabic.sdk.java.platform.model.ApplicationInCompanyResponse;
import com.dynabic.sdk.java.platform.model.ApplicationPlan;
import com.dynabic.sdk.java.platform.model.ApplicationResponse;
import com.wordnik.swagger.runtime.exception.APIException;

@Category(IntegrationTest.class)
public class AppsAPITest extends AbstractIntegrationTest {

	{
		runSetup = false;
	}

	@Test
	public void GetAllApplications() throws APIException {
		List<ApplicationResponse> applications = AppsAPI.GetAllApplications();
		Assert.assertNotNull(applications);
	}

	@Ignore("GetApplicationCurrentPlan returns null")
	@Test
	public void GetApplicationCurrentPlan() throws APIException {
		List<ApplicationInCompanyResponse> applications = AppsAPI.GetCompanyApplications();
		ApplicationPlan plan = AppsAPI.GetApplicationCurrentPlan(applications.get(0).getApplication_id().toString());
		Assert.assertNotNull(plan);
	}

	@Test
	public void GetCompanyApplicationById() throws APIException {
		List<ApplicationInCompanyResponse> applications = AppsAPI.GetCompanyApplications();
		ApplicationInCompanyResponse app = AppsAPI.GetCompanyApplicationById(applications.get(0).getApplication_id().toString());
		Assert.assertNotNull(app);
	}

	@Ignore("CompanyApplicationByName Analytics returns null")
	@Test
	public void GetCompanyApplicationByName() throws APIException {
		ApplicationInCompanyResponse app = AppsAPI.GetCompanyApplicationByName("Analytics");
		Assert.assertNotNull(app);
	}

	@Test
	public void GetCompanyApplications() throws APIException {
		List<ApplicationInCompanyResponse> applications = AppsAPI.GetCompanyApplications();
		Assert.assertNotNull(applications);
		Assert.assertTrue(applications.size() > 0);
	}

	@Test
	public void SetApplicationStatus() throws APIException {
		List<ApplicationInCompanyResponse> applications = AppsAPI.GetCompanyApplications();
		AppsAPI.SetApplicationStatus(applications.get(0).getId().toString(), "false");
		AppsAPI.SetApplicationStatus(applications.get(0).getId().toString(), applications.get(0).getActive().toString());
	}
}

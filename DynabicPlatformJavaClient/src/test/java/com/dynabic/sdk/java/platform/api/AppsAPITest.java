package com.dynabic.sdk.java.platform.api;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dynabic.sdk.java.platform.model.ApplicationInCompanyResponse;
import com.dynabic.sdk.java.platform.model.ApplicationPlan;
import com.dynabic.sdk.java.platform.model.ApplicationResponse;
import com.wordnik.swagger.runtime.exception.APIException;

public class AppsAPITest extends AbstractIntegrationTest {

	@Test(groups={"integration"})
	public void GetAllApplications() throws APIException {
		List<ApplicationResponse> applications = AppsAPI.GetAllApplications();
		Assert.assertNotNull(applications);
	}

	@Test(groups={"integration"}, enabled=false, description="GetApplicationCurrentPlan returns null")
	public void GetApplicationCurrentPlan() throws APIException {
		List<ApplicationInCompanyResponse> applications = AppsAPI.GetCompanyApplications();
		ApplicationPlan plan = AppsAPI.GetApplicationCurrentPlan(applications.get(0).getApplication_id().toString());
		Assert.assertNotNull(plan);
	}

	@Test(groups={"integration"})
	public void GetCompanyApplicationById() throws APIException {
		List<ApplicationInCompanyResponse> applications = AppsAPI.GetCompanyApplications();
		ApplicationInCompanyResponse app = AppsAPI.GetCompanyApplicationById(applications.get(0).getApplication_id().toString());
		Assert.assertNotNull(app);
	}

	@Test(groups={"integration"}, enabled=false, description="GetCompanyApplicationByName Analytics returns null")
	public void GetCompanyApplicationByName() throws APIException {
		ApplicationInCompanyResponse app = AppsAPI.GetCompanyApplicationByName("Analytics");
		Assert.assertNotNull(app);
	}

	@Test(groups={"integration"})
	public void GetCompanyApplications() throws APIException {
		List<ApplicationInCompanyResponse> applications = AppsAPI.GetCompanyApplications();
		Assert.assertNotNull(applications);
		Assert.assertTrue(applications.size() > 0);
	}

	@Test(groups={"integration"})
	public void SetApplicationStatus() throws APIException {
		List<ApplicationInCompanyResponse> applications = AppsAPI.GetCompanyApplications();
		AppsAPI.SetApplicationStatus(applications.get(0).getId().toString(), "false");
		AppsAPI.SetApplicationStatus(applications.get(0).getId().toString(), applications.get(0).getActive().toString());
	}
}

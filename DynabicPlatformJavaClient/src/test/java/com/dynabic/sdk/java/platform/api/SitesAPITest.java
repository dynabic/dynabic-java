package com.dynabic.sdk.java.platform.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.dynabic.sdk.java.platform.model.SiteRequest;
import com.dynabic.sdk.java.platform.model.SiteResponse;
import com.wordnik.swagger.runtime.exception.APIException;

@Category(IntegrationTest.class)
public class SitesAPITest extends AbstractIntegrationTest {

	@Test
	public void AddSite() {
		Assert.assertNotNull(testData.siteId);
	}

	@Test
	public void DeleteSite() throws APIException {
		SitesAPI.DeleteSite(testData.siteId.toString());
	}

	@Test
	public void GetSiteById() throws APIException {
		SiteResponse response = SitesAPI.GetSiteById(testData.siteId.toString());
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getId(), testData.siteId);
	}

	@Test
	public void GetSiteBySubdomain() throws APIException {
		SiteResponse response = SitesAPI.GetSiteBySubdomain(testData.subdomain);
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getSubdomain(), testData.subdomain);
	}

	@Test
	public void GetSites() throws APIException {
		List<SiteResponse> response = SitesAPI.GetSites(null, null);
		Assert.assertNotNull(response);
	}

	@Test
	public void GetSitesByName() throws APIException {
		List<SiteResponse> response = SitesAPI.GetSitesByName(testData.siteName);
		Assert.assertNotNull(response);
		for (SiteResponse site : response) {
			Assert.assertEquals(site.getName(), testData.siteName);
		}
	}

	@Test
	public void UpdateSite() throws APIException {
		SiteRequest postData = new SiteRequest();
		postData.setIs_test_mode(true);
		postData.setSubdomain(testData.subdomain);
		postData.setName(testData.siteName + "_updated");
		SiteResponse updatedSite = SitesAPI.UpdateSite(postData , testData.siteId.toString());
		Assert.assertNotNull(updatedSite);
		Assert.assertEquals(updatedSite.getName(), postData.getName());
	}
}

package com.dynabic.sdk.java.platform.api;

import java.text.SimpleDateFormat;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.dynabic.sdk.java.platform.model.SiteRequest;
import com.dynabic.sdk.java.platform.model.SiteResponse;
import com.dynabic.sdk.java.platform.model.UserRequest;
import com.dynabic.sdk.java.platform.model.UserResponse;
import com.wordnik.swagger.runtime.common.APIInvoker;
import com.wordnik.swagger.runtime.common.DynabicUrlSigningSecurityHandler;
import com.wordnik.swagger.runtime.exception.APIException;

public abstract class AbstractIntegrationTest {

	public static String apiServerPlatform;
	public static APIInvoker apiInvokerPlatform;
	public static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("ddMMyyyy");
	private static final Boolean enableLogging;

	static {
		String apiServer = System.getProperty("apiServer", "https://stage-api.dynabic.com/");
		if(apiServer.endsWith("/")){
			apiServerPlatform = apiServer + "Platform/";
		} else {
			apiServerPlatform = apiServer + "/Platform/";
		}
		String clientKey = System.getProperty("clientKey", "demo_public_key");
		String privateKey = System.getProperty("privateKey", "demo_private_key");
		enableLogging = Boolean.valueOf(System.getProperty("enableLogging", "true"));
		DynabicUrlSigningSecurityHandler securityHandler = new DynabicUrlSigningSecurityHandler(clientKey, privateKey);
		apiInvokerPlatform = APIInvoker.initialize(securityHandler, apiServerPlatform, enableLogging);

		AppsAPI.setApiInvoker(apiInvokerPlatform);
		CompanyinfoAPI.setApiInvoker(apiInvokerPlatform);
		DynabicmarketingplansAPI.setApiInvoker(apiInvokerPlatform);
		EventsAPI.setApiInvoker(apiInvokerPlatform);
		SettingsAPI.setApiInvoker(apiInvokerPlatform);
		SitesAPI.setApiInvoker(apiInvokerPlatform);
		UsersAPI.setApiInvoker(apiInvokerPlatform);
	}

	protected TestData testData;

	@BeforeMethod
	public void setUpSite() throws APIException {
		log("Setting up site...");

		SiteResponse site = addSite();
		Assert.assertNotNull(site);
		Assert.assertNotNull(site.getId());
		Assert.assertNotNull(site.getName());
		Assert.assertNotNull(site.getSubdomain());
		testData = new TestData();
		testData.siteId = site.getId();
		testData.siteName = site.getName();
		testData.subdomain = site.getSubdomain();
	}

	@AfterMethod
	public void tearDownSite() {
		log("Tearing down site...");
		try {
			SitesAPI.DeleteSite(testData.siteId.toString());
		} catch (APIException ignore) {
			// already deleted
		}
	}

	public static void log(Object msg){
		if(enableLogging){
			System.out.println(msg);
		}
	}

	public SiteResponse addSite() throws APIException {
		String subdomain = "javaTestSubdomain";

		try {
			SiteResponse response = SitesAPI.GetSiteBySubdomain(subdomain);
			if(response != null && response.getId() != null){
				SitesAPI.DeleteSite(response.getId().toString());
			}
		} catch(APIException ignore){}

		SiteRequest postData = new SiteRequest();
		postData.setIs_test_mode(true);
		postData.setName("Name");
		postData.setSubdomain(subdomain);

		return SitesAPI.AddSite(postData);
	}

	public UserResponse addUser(String subdomain) throws APIException {
		return UsersAPI.AddUser(newUser());
	}

	public UserRequest newUser() {
		UserRequest user = new UserRequest();
		user.setEmail("b@b.com");
		user.setFacebook_id("facebook_id");
		user.setGoogleapps_user_name("googleapps_user_name");
		user.setFirst_name("first_name");
		user.setLast_name("last_name");
		user.setYahoo_user_name("yahoo_user_name");
		user.setPassword("test123");
		user.setActive(true);
		user.setDeleted(false);
		user.setIs_subscribed_to_newsletter(false);
		return user;
	}

	public static class TestData {
		public Integer siteId;
		public String siteName;
	    public String subdomain;
	}
}

package com.dynabic.sdk.java.api;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dynabic.sdk.java.model.Statement;
import com.dynabic.sdk.java.model.SubscriptionResponse;
import com.wordnik.swagger.runtime.exception.APIException;

public class StatementsAPITest extends AbstractIntegrationTest {

	private SubscriptionResponse subscription;

	@BeforeMethod(dependsOnMethods = { "setUpSite" })
	public void setUpSubscription(Method m) throws APIException {
		log("Setting up Subscription...");
		subscription = addSubscription(testData.siteId);
		Assert.assertNotNull(subscription);
		Assert.assertNotNull(subscription.getId());
		log("Executing test case " + m.getName() + "()");
	}

	@AfterMethod
	public void tearDownSubscription() throws APIException {
		log("Tearing down Subscription...");
		SubscriptionsAPI.DeleteSubscription(subscription.getId().toString());
	}

	@Test(groups={"integration"})
	public void GetStatementsForSubscription() throws APIException {
		List<Statement> statements = StatementsAPI.GetStatementsForSubscription(subscription.getId().toString(), null, null);
		Assert.assertNotNull(statements);
	}
}

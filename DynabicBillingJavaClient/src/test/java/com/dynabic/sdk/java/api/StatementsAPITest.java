package com.dynabic.sdk.java.api;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.dynabic.sdk.java.model.Statement;
import com.dynabic.sdk.java.model.SubscriptionResponse;
import com.wordnik.swagger.runtime.exception.APIException;

@Category(IntegrationTest.class)
public class StatementsAPITest extends AbstractIntegrationTest {

	private SubscriptionResponse subscription;

	@Before
	public void setUpSubscription() throws APIException {
		log("Setting up Subscription...");
		subscription = addSubscription(testData.siteId);
		Assert.assertNotNull(subscription);
		Assert.assertNotNull(subscription.getId());
	}

	@After
	public void tearDownSubscription() throws APIException {
		log("Tearing down Subscription...");
		SubscriptionsAPI.DeleteSubscription(subscription.getId().toString());
	}

	@Test
	public void GetStatementsForSubscription() throws APIException {
		List<Statement> statements = StatementsAPI.GetStatementsForSubscription(subscription.getId().toString(), null, null);
		Assert.assertNotNull(statements);
	}
}

package com.dynabic.sdk.java.api;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dynabic.sdk.java.model.SubscriptionResponse;
import com.dynabic.sdk.java.model.TransactionResponse;
import com.wordnik.swagger.runtime.exception.APIException;

public class TransactionsAPITest extends AbstractIntegrationTest {

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
	public void GetTransactionsForCustomer() throws APIException {
		List<TransactionResponse> trx = TransactionsAPI.GetTransactionsForCustomer(subscription.getCustomer_id().toString(), null, null);
		Assert.assertNotNull(trx);
	}

	@Test(groups={"integration"})
	public void GetTransactionsForSite() throws APIException {
		List<TransactionResponse> trx = TransactionsAPI.GetTransactionsForSite(testData.subdomain, null, null);
		Assert.assertNotNull(trx);
	}

	@Test(groups={"integration"})
	public void GetTransactionsForSubscription() throws APIException {
		List<TransactionResponse> trx = TransactionsAPI.GetTransactionsForSubscription(subscription.getId().toString(), null, null);
		Assert.assertNotNull(trx);
	}
}

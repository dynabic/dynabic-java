package com.dynabic.sdk.java.api;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dynabic.sdk.java.model.ActiveSubscriptionsCountResponse;
import com.dynabic.sdk.java.model.ProductsRevenues;
import com.dynabic.sdk.java.model.ProductsSignups;
import com.dynabic.sdk.java.model.ReportDecimalValueItem;
import com.dynabic.sdk.java.model.ReportIntValueItem;
import com.dynabic.sdk.java.model.RevenueAmount;
import com.dynabic.sdk.java.model.SiteSummary;
import com.dynabic.sdk.java.model.SubscriptionResponse;
import com.dynabic.sdk.java.model.TodayNewSubscribersCountResponse;
import com.dynabic.sdk.java.model.TotalSubscribersCountResponse;
import com.wordnik.swagger.runtime.exception.APIException;

public class ReportsAPITest extends AbstractIntegrationTest {

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
	public void GetActiveSubscriptionsCount() throws APIException {
		ActiveSubscriptionsCountResponse response = ReportsAPI.GetActiveSubscriptionsCount(testData.subdomain);
		Assert.assertNotNull(response);
	}

	@Test(groups={"integration"})
	public void GetCustomersEvolution() throws APIException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);
		List<ReportIntValueItem> response = ReportsAPI.GetCustomersEvolution(
				testData.subdomain, DATE_FORMATTER.format(cal.getTime()),
				DATE_FORMATTER.format(new Date()));
		Assert.assertNotNull(response);
	}

	@Test(groups={"integration"})
	public void GetProductsRevenuesEvolution() throws APIException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);
		List<ProductsRevenues> response = ReportsAPI.GetProductsRevenuesEvolution(
				testData.subdomain, DATE_FORMATTER.format(cal.getTime()),
				DATE_FORMATTER.format(new Date()));
		Assert.assertNotNull(response);
	}

	@Test(groups={"integration"})
	public void GetProductsSignupsEvolution() throws APIException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);
		List<ProductsSignups> response = ReportsAPI.GetProductsSignupsEvolution(
				testData.subdomain, DATE_FORMATTER.format(cal.getTime()),
				DATE_FORMATTER.format(new Date()));
		Assert.assertNotNull(response);
	}

	@Test(groups={"integration"})
	public void GetRevenuesEvolution() throws APIException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);
		List<ReportDecimalValueItem> response = ReportsAPI.GetRevenuesEvolution(
				testData.subdomain, DATE_FORMATTER.format(cal.getTime()),
				DATE_FORMATTER.format(new Date()));
		Assert.assertNotNull(response);
	}

	@Test(groups={"integration"})
	public void GetSignupsEvolution() throws APIException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);
		List<ReportIntValueItem> response = ReportsAPI.GetSignupsEvolution(
				testData.subdomain, DATE_FORMATTER.format(cal.getTime()),
				DATE_FORMATTER.format(new Date()));
		Assert.assertNotNull(response);
	}

	@Test(groups={"integration"})
	public void GetSitesSummary() throws APIException {
		List<SiteSummary> response = ReportsAPI.GetSitesSummary();
		Assert.assertNotNull(response);
	}

	@Test(groups={"integration"})
	public void GetSubscriptionsEvolution() throws APIException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);
		List<ReportIntValueItem> response = ReportsAPI.GetSubscriptionsEvolution(
				testData.subdomain, DATE_FORMATTER.format(cal.getTime()),
				DATE_FORMATTER.format(new Date()));
		Assert.assertNotNull(response);
	}

	@Test(groups={"integration"})
	public void GetTodayNewSubscribersCount() throws APIException {
		TodayNewSubscribersCountResponse response = ReportsAPI.GetTodayNewSubscribersCount(testData.subdomain);
		Assert.assertNotNull(response);
	}

	@Test(groups={"integration"})
	public void GetTodayRevenueAmount() throws APIException {
		List<RevenueAmount> response = ReportsAPI.GetTodayRevenueAmount(testData.subdomain);
		Assert.assertNotNull(response);
	}

	@Test(groups={"integration"})
	public void GetTotalRevenueAmount() throws APIException {
		List<RevenueAmount> response = ReportsAPI.GetTotalRevenueAmount(testData.subdomain);
		Assert.assertNotNull(response);
	}

	@Test(groups={"integration"})
	public void GetTotalSubscribersCount() throws APIException {
		TotalSubscribersCountResponse response = ReportsAPI.GetTotalSubscribersCount(testData.subdomain);
		Assert.assertNotNull(response);
	}
}

package com.dynabic.sdk.java.api;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dynabic.sdk.java.model.SubscriptionResponse;
import com.dynabic.sdk.java.platform.api.EventsAPI;
import com.dynabic.sdk.java.platform.model.EventResponse;
import com.wordnik.swagger.runtime.exception.APIException;

public class EventsAPITest extends AbstractIntegrationTest {

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

	@Test(timeOut=1200000)
	public void GetEvent() throws APIException {
		List<EventResponse> events = EventsAPI.GetEventsForSubscription(subscription.getId().toString(), null, null);
		Assert.assertNotNull(events);
		EventResponse event = EventsAPI.GetEvent(events.get(0).getId().toString());
		Assert.assertNotNull(event);
		Assert.assertNotNull(event.getId());
	}

	@Test(timeOut=1200000)
	public void GetEvents() throws APIException {
		List<EventResponse> events = EventsAPI.GetEvents(null, "100");
		Assert.assertNotNull(events);
	}

	@Test(timeOut=1200000)
	public void GetEventsForSite() throws APIException {
		List<EventResponse> events = EventsAPI.GetEventsForSite(testData.siteId.toString(), null, "1", "100");
		Assert.assertNotNull(events);
	}

	@Test(timeOut=1200000)
	public void GetEventsForSubscription() throws APIException {
		List<EventResponse> events = EventsAPI.GetEventsForSubscription(subscription.getId().toString(), null, null);
		Assert.assertNotNull(events);
	}

	@Test(timeOut=1200000)
	public void GetEventsForSubscriptionBetweenDates() throws APIException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -5);
		List<EventResponse> events = EventsAPI.GetEventsForSubscriptionBetweenDates(subscription.getId().toString(),
				DATE_FORMATTER.format(cal.getTime()), DATE_FORMATTER.format(new Date()));
		Assert.assertNotNull(events);
	}
}

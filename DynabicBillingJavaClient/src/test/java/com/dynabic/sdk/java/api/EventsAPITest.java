package com.dynabic.sdk.java.api;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.dynabic.sdk.java.model.SubscriptionResponse;
import com.dynabic.sdk.java.platform.api.EventsAPI;
import com.dynabic.sdk.java.platform.model.EventResponse;
import com.wordnik.swagger.runtime.exception.APIException;

@Category(IntegrationTest.class)
public class EventsAPITest extends AbstractIntegrationTest {

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

	@Test(timeout=1200000)
	public void GetEvent() throws APIException {
		List<EventResponse> events = EventsAPI.GetEventsForSubscription(subscription.getId().toString(), null, null);
		Assert.assertNotNull(events);
		EventResponse event = EventsAPI.GetEvent(events.get(0).getId().toString());
		Assert.assertNotNull(event);
		Assert.assertNotNull(event.getId());
	}

	@Test(timeout=1200000)
	public void GetEvents() throws APIException {
		List<EventResponse> events = EventsAPI.GetEvents(null, "100");
		Assert.assertNotNull(events);
	}

	@Test(timeout=1200000)
	public void GetEventsForSite() throws APIException {
		List<EventResponse> events = EventsAPI.GetEventsForSite(testData.siteId.toString(), null, "1", "100");
		Assert.assertNotNull(events);
	}

	@Test(timeout=1200000)
	public void GetEventsForSubscription() throws APIException {
		List<EventResponse> events = EventsAPI.GetEventsForSubscription(subscription.getId().toString(), null, null);
		Assert.assertNotNull(events);
	}

	@Test(timeout=1200000)
	public void GetEventsForSubscriptionBetweenDates() throws APIException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -5);
		List<EventResponse> events = EventsAPI.GetEventsForSubscriptionBetweenDates(subscription.getId().toString(),
				DATE_FORMATTER.format(cal.getTime()), DATE_FORMATTER.format(new Date()));
		Assert.assertNotNull(events);
	}
}

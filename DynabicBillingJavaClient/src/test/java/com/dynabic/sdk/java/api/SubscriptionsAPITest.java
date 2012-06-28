package com.dynabic.sdk.java.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;

import com.dynabic.sdk.java.model.AddressResponse;
import com.dynabic.sdk.java.model.CancellationRequest;
import com.dynabic.sdk.java.model.ChargeRequest;
import com.dynabic.sdk.java.model.CustomerResponse;
import com.dynabic.sdk.java.model.ProductResponse;
import com.dynabic.sdk.java.model.SubscriptionItemRequest;
import com.dynabic.sdk.java.model.SubscriptionItemResponse;
import com.dynabic.sdk.java.model.SubscriptionRequest;
import com.dynabic.sdk.java.model.SubscriptionResponse;
import com.dynabic.sdk.java.model.TransactionResponse;
import com.wordnik.swagger.runtime.exception.APIException;

@Category(IntegrationTest.class)
public class SubscriptionsAPITest extends AbstractIntegrationTest {

	private SubscriptionResponse subscription;

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUpSubscription() throws APIException {
		log("Setting up Subscription...");
		subscription = addSubscription(testData.siteId);
		Assert.assertNotNull(subscription);
		Assert.assertNotNull(subscription.getId());

		log("Executing test case " + testName.getMethodName() + "()");
	}

	@After
	public void tearDownSubscription() {
		if(subscription == null) {
			return;
		}

		log("Tearing down Subscription...");
		try {
			SubscriptionsAPI.DeleteSubscription(subscription.getId().toString());
		} catch (APIException ignore) {
			// already deleted
		}
	}

	@Test
	public void AddChargeToSubscription() throws APIException {
		ChargeRequest postData = new ChargeRequest();
		postData.setAmount(100d);
		postData.setMemo("test charge");
		TransactionResponse trx = SubscriptionsAPI.AddChargeToSubscription(subscription.getId().toString(), postData );
		Assert.assertNotNull(trx);
		Assert.assertEquals(trx.getAmount().intValue(), postData.getAmount().intValue());
	}

	@Test
	public void AddSubscription() {
		Assert.assertNotNull(subscription);
		Assert.assertNotNull(subscription.getId());
	}

	@Test
	public void AddSubscriptionItems() throws APIException {
		ProductResponse product = ProductsAPI.GetProductById(subscription.getProduct_id().toString());
		List<SubscriptionItemRequest> items = new ArrayList<SubscriptionItemRequest>();
		SubscriptionItemRequest item = new SubscriptionItemRequest();
		item.setProduct_item_id(product.getPricing_plans().get(0).getProduct_items().get(0).getId());
		item.setSubscription_id(subscription.getId());
		item.setQuantity(100d);
		items.add(item);
		SubscriptionsAPI.AddSubscriptionItems(items);
	}

	@Test
	public void AdjustSubscriptionBalance() throws APIException {
		ChargeRequest postData = new ChargeRequest();
		postData.setAmount(100d);
		postData.setMemo("test charge");
		SubscriptionsAPI.AdjustSubscriptionBalance(subscription.getId().toString(), "false", postData);
	}

	@Test
	public void CancelSubscription() throws APIException {
		CancellationRequest postData = new CancellationRequest();
		postData.setIsCancelledAtEndOfPeriod(false);
		postData.setCancelationDetails("detaild");
		SubscriptionsAPI.CancelSubscription(subscription.getId().toString(), postData);
	}

	@Test
	public void ChangeSubscriptionProduct() throws APIException {
		ProductResponse product = ProductsAPI.GetProductById(subscription.getProduct_id().toString());
		SubscriptionsAPI.ChangeSubscriptionProduct(subscription.getId().toString(), product.getPricing_plans().get(0).getId().toString());
	}

	@Test
	public void DeleteSubscription() throws APIException {
		SubscriptionsAPI.DeleteSubscription(subscription.getId().toString());
		subscription = null;
	}

	@Test
	public void GetAddress() throws APIException {
		AddressResponse address = SubscriptionsAPI.GetAddress(subscription.getId().toString());
		Assert.assertNotNull(address);
		Assert.assertEquals(address.getId(), subscription.getBilling_address_id());
	}

	@Test
	public void GetCustomersForProduct() throws APIException {
		List<CustomerResponse> customers = SubscriptionsAPI.GetCustomersForProduct(subscription.getId().toString());
		Assert.assertNotNull(customers);
        Assert.assertEquals(1, customers.size());
        Assert.assertEquals(subscription.getCustomer_id(), customers.get(0).getId());
	}

	@Test
	public void GetSubscription() throws APIException {
		SubscriptionResponse subscription2 = SubscriptionsAPI.GetSubscription(subscription.getId().toString());
		Assert.assertNotNull(subscription2);
	}

	@Test
	public void GetSubscriptionItems() throws APIException {
		ProductResponse product = ProductsAPI.GetProductById(subscription.getProduct_id().toString());

		List<SubscriptionItemRequest> items = new ArrayList<SubscriptionItemRequest>();
		SubscriptionItemRequest item = new SubscriptionItemRequest();
		item.setProduct_item_id(product.getPricing_plans().get(0).getProduct_items().get(0).getId());
		item.setSubscription_id(subscription.getId());
		item.setQuantity(100d);
		items.add(item);
		SubscriptionsAPI.UpdateSubscriptionItems(items);

		items = new ArrayList<SubscriptionItemRequest>();
		item = new SubscriptionItemRequest();
		item.setProduct_item_id(product.getPricing_plans().get(0).getProduct_items().get(0).getId());
		item.setSubscription_id(subscription.getId());
		item.setQuantity(50d);
		items.add(item);
		SubscriptionsAPI.UpdateSubscriptionItems(items);

		List<SubscriptionItemResponse> components = SubscriptionsAPI.GetSubscriptionItems(subscription.getId().toString());
		Assert.assertNotNull(components);
		Assert.assertEquals(2, components.size());
		Assert.assertEquals(50, components.get(0).getQuantity().intValue());
		Assert.assertEquals(3, components.get(0).getUpdate_history().size());
	}

	@Test
	public void GetSubscriptions() throws APIException {
		List<SubscriptionResponse> subscriptions = SubscriptionsAPI.GetSubscriptions(testData.subdomain, null, null);
		Assert.assertNotNull(subscriptions);
	}

	@Test
	public void GetSubscriptionsForStatus() throws APIException {
		List<SubscriptionResponse> subscriptions = SubscriptionsAPI.GetSubscriptionsForStatus(testData.subdomain, "Active", null, null);
		Assert.assertNotNull(subscriptions);
	}

	@Test
	public void GetSubscriptionsOfCustomer() throws APIException {
		List<SubscriptionResponse> subscriptions = SubscriptionsAPI.GetSubscriptionsOfCustomer(subscription.getCustomer_id().toString());
		Assert.assertNotNull(subscriptions);
	}

	@Test
	public void GetSubscriptionsOfCustomerByReferenceId() throws APIException {
		List<SubscriptionResponse> subscriptions = SubscriptionsAPI.GetSubscriptionsOfCustomerByReferenceId(
				testData.subdomain, subscription.getCustomer().getReference());
		Assert.assertNotNull(subscriptions);
	}

	@Test
	public void ReactivateSubscription() throws APIException {
		SubscriptionsAPI.ReactivateSubscription(subscription.getId().toString());
	}

	@Test
	public void Refund() throws APIException {
		ChargeRequest charge = new ChargeRequest();
		charge.setAmount(100d);
		charge.setMemo("test charge");
		SubscriptionsAPI.AddChargeToSubscription(subscription.getId().toString(), charge );

		List<TransactionResponse> transactions = TransactionsAPI.GetTransactionsForSubscription(subscription.getId().toString(), null, null);
		Assert.assertNotNull(transactions);
		Assert.assertTrue(transactions.size() > 0);

		charge.setAmount(50d);
		TransactionResponse trx = SubscriptionsAPI.Refund(subscription.getId().toString(), charge, transactions.get(0).getId().toString());
		Assert.assertNotNull(trx);
		Assert.assertEquals(charge.getAmount().intValue(), trx.getAmount().intValue());
	}

	@Test
	public void ResetSubscriptionMeteredItems() throws APIException {
		ProductResponse product = ProductsAPI.GetProductById(subscription.getProduct_id().toString());

		List<SubscriptionItemRequest> items = new ArrayList<SubscriptionItemRequest>();
		SubscriptionItemRequest item = new SubscriptionItemRequest();
		item.setProduct_item_id(product.getPricing_plans().get(0).getProduct_items().get(0).getId());
		item.setSubscription_id(subscription.getId());
		item.setQuantity(100d);
		items.add(item);
		SubscriptionsAPI.UpdateSubscriptionItems(items);

		items = new ArrayList<SubscriptionItemRequest>();
		item = new SubscriptionItemRequest();
		item.setProduct_item_id(product.getPricing_plans().get(0).getProduct_items().get(0).getId());
		item.setSubscription_id(subscription.getId());
		item.setQuantity(50d);
		items.add(item);
		SubscriptionsAPI.UpdateSubscriptionItems(items);

		List<SubscriptionItemResponse> components = SubscriptionsAPI.GetSubscriptionItems(subscription.getId().toString());
		Assert.assertNotNull(components);
		Assert.assertEquals(2, components.size());
		Assert.assertEquals(3, components.get(0).getUpdate_history().size());

		SubscriptionsAPI.ResetSubscriptionMeteredItems(subscription.getId().toString());
		components = SubscriptionsAPI.GetSubscriptionItems(subscription.getId().toString());
		Assert.assertNotNull(components);
		Assert.assertEquals(2, components.size());
		Assert.assertEquals(0, components.get(0).getQuantity().intValue());
		Assert.assertEquals(0, components.get(0).getUpdate_history().size());
	}

	@Test
	public void UpdateSubscription() throws APIException {
		SubscriptionRequest postData = new SubscriptionRequest();
		postData.setCancellation_details(subscription.getCancellation_details() + "_updated");
		postData.setSubscription_items(null);
		postData.setCustomer_id(subscription.getCustomer_id());
		postData.setProduct_id(subscription.getProduct_id());
		postData.setPricing_plan_id(subscription.getPricing_plan_id());
		postData.setBilling_address_id(subscription.getBilling_address_id());
		postData.setCredit_card_id(subscription.getCredit_card_id());
		SubscriptionResponse updatedSubscription = SubscriptionsAPI.UpdateSubscription(testData.subdomain, subscription.getId().toString(), postData);
		Assert.assertNotNull(updatedSubscription);
		Assert.assertEquals(postData.getCancellation_details(), updatedSubscription.getCancellation_details());
	}

	@Test
	public void UpdateSubscriptionItems() throws APIException {
		ProductResponse product = ProductsAPI.GetProductById(subscription.getProduct_id().toString());
		List<SubscriptionItemRequest> items = new ArrayList<SubscriptionItemRequest>();
		SubscriptionItemRequest item = new SubscriptionItemRequest();
		item.setProduct_item_id(product.getPricing_plans().get(0).getProduct_items().get(0).getId());
		item.setSubscription_id(subscription.getId());
		item.setQuantity(100d);
		items.add(item);
		SubscriptionsAPI.UpdateSubscriptionItems(items);
	}

	@Test
	public void UpgradeDowngradeSubscriptionProduct() throws APIException {
		ProductResponse product = ProductsAPI.GetProductById(subscription.getProduct_id().toString());
        ProductResponse secondProduct = addSecondProductToFamily(product.getProduct_family_id());
        SubscriptionsAPI.UpgradeDowngradeSubscriptionProduct(subscription.getId().toString(), secondProduct.getPricing_plans().get(0).getId().toString(), "true", "true");
	}
}

package com.dynabic.sdk.java.api;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

public class SubscriptionsAPITest extends AbstractIntegrationTest {

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
	public void tearDownSubscription() {
		log("Tearing down Subscription...");
		try {
			SubscriptionsAPI.DeleteSubscription(subscription.getId().toString());
		} catch (APIException ignore) {
			// already deleted
		}
	}

	@Test(groups={"integration"})
	public void AddChargeToSubscription() throws APIException {
		ChargeRequest postData = new ChargeRequest();
		postData.setAmount(100d);
		postData.setMemo("test charge");
		TransactionResponse trx = SubscriptionsAPI.AddChargeToSubscription(subscription.getId().toString(), postData );
		Assert.assertNotNull(trx);
		Assert.assertEquals(trx.getAmount().intValue(), postData.getAmount().intValue());
	}

	@Test(groups={"integration"})
	public void AddSubscription() {
		Assert.assertNotNull(subscription);
		Assert.assertNotNull(subscription.getId());
	}

	@Test(groups={"integration"})
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

	@Test(groups={"integration"})
	public void AdjustSubscriptionBalance() throws APIException {
		ChargeRequest postData = new ChargeRequest();
		postData.setAmount(100d);
		postData.setMemo("test charge");
		SubscriptionsAPI.AdjustSubscriptionBalance(subscription.getId().toString(), "false", postData);
	}

	@Test(groups={"integration"})
	public void CancelSubscription() throws APIException {
		CancellationRequest postData = new CancellationRequest();
		postData.setIsCancelledAtEndOfPeriod(false);
		postData.setCancelationDetails("detaild");
		SubscriptionsAPI.CancelSubscription(subscription.getId().toString(), postData);
	}

	@Test(groups={"integration"})
	public void ChangeSubscriptionProduct() throws APIException {
		ProductResponse product = ProductsAPI.GetProductById(subscription.getProduct_id().toString());
		SubscriptionsAPI.ChangeSubscriptionProduct(subscription.getId().toString(), product.getPricing_plans().get(0).getId().toString());
	}

	@Test(groups={"integration"})
	public void DeleteSubscription() throws APIException {
		SubscriptionsAPI.DeleteSubscription(subscription.getId().toString());
	}

	@Test(groups={"integration"})
	public void GetAddress() throws APIException {
		AddressResponse address = SubscriptionsAPI.GetAddress(subscription.getId().toString());
		Assert.assertNotNull(address);
		Assert.assertEquals(address.getId(), subscription.getBilling_address_id());
	}

	@Test(groups={"integration"})
	public void GetCustomersForProduct() throws APIException {
		List<CustomerResponse> customers = SubscriptionsAPI.GetCustomersForProduct(subscription.getId().toString());
		Assert.assertNotNull(customers);
        Assert.assertEquals(1, customers.size());
        Assert.assertEquals(subscription.getCustomer_id(), customers.get(0).getId());
	}

	@Test(groups={"integration"})
	public void GetSubscription() throws APIException {
		SubscriptionResponse subscription2 = SubscriptionsAPI.GetSubscription(subscription.getId().toString());
		Assert.assertNotNull(subscription2);
	}

	@Test(groups={"integration"})
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
		Assert.assertEquals(components.size(), 2);
		Assert.assertEquals(components.get(0).getQuantity(), 50d);
		Assert.assertEquals(components.get(0).getUpdate_history().size(), 3); // 2 from this method + 1 from Add item operation
	}

	@Test(groups={"integration"})
	public void GetSubscriptions() throws APIException {
		List<SubscriptionResponse> subscriptions = SubscriptionsAPI.GetSubscriptions(testData.subdomain, null, null);
		Assert.assertNotNull(subscriptions);
	}

	@Test(groups={"integration"})
	public void GetSubscriptionsForStatus() throws APIException {
		List<SubscriptionResponse> subscriptions = SubscriptionsAPI.GetSubscriptionsForStatus(testData.subdomain, "Active", null, null);
		Assert.assertNotNull(subscriptions);
	}

	@Test(groups={"integration"})
	public void GetSubscriptionsOfCustomer() throws APIException {
		List<SubscriptionResponse> subscriptions = SubscriptionsAPI.GetSubscriptionsOfCustomer(subscription.getCustomer_id().toString());
		Assert.assertNotNull(subscriptions);
	}

	@Test(groups={"integration"})
	public void GetSubscriptionsOfCustomerByReferenceId() throws APIException {
		List<SubscriptionResponse> subscriptions = SubscriptionsAPI.GetSubscriptionsOfCustomerByReferenceId(
				testData.subdomain, subscription.getCustomer().getReference());
		Assert.assertNotNull(subscriptions);
	}

	@Test(groups={"integration"})
	public void ReactivateSubscription() throws APIException {
		SubscriptionsAPI.ReactivateSubscription(subscription.getId().toString());
	}

	@Test(groups={"integration"})
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

	@Test(groups={"integration"})
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
		Assert.assertEquals(components.size(), 2);
		Assert.assertEquals(components.get(0).getQuantity(), 0);
		Assert.assertEquals(components.get(0).getUpdate_history().size(), 0);
	}

	@Test(groups={"integration"})
	public void UpdateSubscription() throws APIException {
		SubscriptionRequest postData = new SubscriptionRequest();
		postData.setStatus("64");
		SubscriptionResponse updatedSubscription = SubscriptionsAPI.UpdateSubscription(testData.subdomain, subscription.getId().toString(), postData);
		Assert.assertNotNull(updatedSubscription);
		Assert.assertEquals(updatedSubscription.getStatus(), postData.getStatus());
	}

	@Test(groups={"integration"})
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

	@Test(groups={"integration"})
	public void UpgradeDowngradeSubscriptionProduct() throws APIException {
		ProductResponse product = ProductsAPI.GetProductById(subscription.getProduct_id().toString());
        ProductResponse secondProduct = addProductToFamily(product.getProduct_family_id());
        SubscriptionsAPI.UpgradeDowngradeSubscriptionProduct(subscription.getId().toString(), secondProduct.getPricing_plans().get(0).getId().toString(), "true", "true");
	}
}

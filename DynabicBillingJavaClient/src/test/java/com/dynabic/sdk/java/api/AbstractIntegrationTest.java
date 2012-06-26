package com.dynabic.sdk.java.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.dynabic.sdk.java.model.AddressRequest;
import com.dynabic.sdk.java.model.AddressResponse;
import com.dynabic.sdk.java.model.CreditCardRequest;
import com.dynabic.sdk.java.model.CreditCardResponse;
import com.dynabic.sdk.java.model.Currency;
import com.dynabic.sdk.java.model.CustomerRequest;
import com.dynabic.sdk.java.model.CustomerResponse;
import com.dynabic.sdk.java.model.PricingPlanRequest;
import com.dynabic.sdk.java.model.ProductFamilyRequest;
import com.dynabic.sdk.java.model.ProductFamilyResponse;
import com.dynabic.sdk.java.model.ProductItemRequest;
import com.dynabic.sdk.java.model.ProductItemResponse;
import com.dynabic.sdk.java.model.ProductMeteredPriceRequest;
import com.dynabic.sdk.java.model.ProductPricingPlanPaymentScheduleRequest;
import com.dynabic.sdk.java.model.ProductRequest;
import com.dynabic.sdk.java.model.ProductResponse;
import com.dynabic.sdk.java.model.SubscriptionItemRequest;
import com.dynabic.sdk.java.model.SubscriptionRequest;
import com.dynabic.sdk.java.model.SubscriptionResponse;
import com.dynabic.sdk.java.platform.api.SitesAPI;
import com.dynabic.sdk.java.platform.model.SiteRequest;
import com.dynabic.sdk.java.platform.model.SiteResponse;
import com.wordnik.swagger.runtime.common.APIInvoker;
import com.wordnik.swagger.runtime.common.DynabicUrlSigningSecurityHandler;
import com.wordnik.swagger.runtime.exception.APIException;

public abstract class AbstractIntegrationTest {

	public static String apiServerBilling;
	public static String apiServerPlatform;
	public static APIInvoker apiInvokerBilling;
	public static APIInvoker apiInvokerPlatform;
	public static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("ddMMyyyy");
	private static final Boolean enableLogging;

	static {
		String apiServer = System.getProperty("apiServer", "https://stage-api.dynabic.com/");
		if(apiServer.endsWith("/")){
			apiServerBilling = apiServer + "Billing/";
			apiServerPlatform = apiServer + "Platform/";
		} else {
			apiServerBilling = apiServer + "/Billing/";
			apiServerPlatform = apiServer + "/Platform/";
		}
		String clientKey = System.getProperty("clientKey", "demo_public_key");
		String privateKey = System.getProperty("privateKey", "demo_private_key");
		enableLogging = Boolean.valueOf(System.getProperty("enableLogging", "true"));
		DynabicUrlSigningSecurityHandler securityHandler = new DynabicUrlSigningSecurityHandler(clientKey, privateKey);
		apiInvokerBilling = APIInvoker.initialize(securityHandler, apiServerBilling, enableLogging);
		apiInvokerPlatform = APIInvoker.initialize(securityHandler, apiServerPlatform, enableLogging);

		AddressAPI.setApiInvoker(apiInvokerBilling);
		CustomersAPI.setApiInvoker(apiInvokerBilling);
		ProductfamilyAPI.setApiInvoker(apiInvokerBilling);
		ProductsAPI.setApiInvoker(apiInvokerBilling);
		ReportsAPI.setApiInvoker(apiInvokerBilling);
		StatementsAPI.setApiInvoker(apiInvokerBilling);
		SubscriptionsAPI.setApiInvoker(apiInvokerBilling);
		TestsAPI.setApiInvoker(apiInvokerBilling);
		TransactionsAPI.setApiInvoker(apiInvokerBilling);

		// dependency from platform app
		SitesAPI.setApiInvoker(apiInvokerPlatform);
	}

	protected TestData testData;

	@BeforeMethod
	public void setUpSite() throws APIException {
		log("Setting up site...");

		SiteResponse site = addSite();
		Assert.assertNotNull(site);
		Assert.assertNotNull(site.getId());
		Assert.assertNotNull(site.getSubdomain());
		testData = new TestData();
		testData.siteId = site.getId();
		testData.subdomain = site.getSubdomain();
	}

	@AfterMethod
	public void tearDownSite() throws APIException{
		log("Tearing down site...");

		SitesAPI.DeleteSite(testData.siteId.toString());
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

	public CustomerResponse addCustomer(String siteSubdomain) throws APIException {
		CustomerRequest postData = newCustomer();
		return CustomersAPI.AddCustomer(siteSubdomain, postData);
	}

	public AddressResponse addBillingAddress(Integer customerId) throws APIException {
		AddressRequest postData = newAddress("billing");
		return CustomersAPI.AddBillingAddress(customerId.toString(), postData);
	}

	public CreditCardResponse addCreditCard(Integer customerId) throws APIException {
		CreditCardRequest postData = newCreditCard();
		return CustomersAPI.AddCreditCard(customerId.toString(), postData);
	}

	public ProductFamilyResponse addProductFamily(Integer siteId) throws APIException {
		ProductFamilyRequest postData = newProductFamily(siteId);
		return ProductfamilyAPI.AddProductFamily(postData);
	}

	public SubscriptionResponse addSubscription(Integer siteId) throws APIException {
		ProductResponse product = addProduct(siteId);

		List<SubscriptionItemRequest> subscriptionItems = new ArrayList<SubscriptionItemRequest>();
		List<ProductItemResponse> items = product.getPricing_plans().get(0).getProduct_items();
		for (ProductItemResponse item : items) {
			SubscriptionItemRequest subscriptionItem = new SubscriptionItemRequest();
			subscriptionItem.setProduct_item_id(item.getId());
			subscriptionItem.setQuantity(5d);
			subscriptionItem.setDescription("Add new subscription");
			subscriptionItems.add(subscriptionItem);
		}

		SubscriptionRequest subscription = new SubscriptionRequest();
		subscription.setBilling_address(newAddress("billing"));
		subscription.setCredit_card(newCreditCard());
		subscription.setCurrency(newCurrency());
		subscription.setCurrent_ballance(100d);
		subscription.setCustomer(newCustomer());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 31);
		subscription.setNext_assesment(cal.getTime());
		subscription.setProduct_id(product.getId());
		subscription.setPricing_plan_id(product.getPricing_plans().get(0).getId());
		subscription.setStart_date(new Date());
		subscription.setStatus("2"); // Trialing
		subscription.setSubscription_items(subscriptionItems);

		return SubscriptionsAPI.AddSubscription(testData.subdomain, subscription);
	}

	public ProductResponse addProduct(Integer siteId) throws APIException {
		ProductFamilyResponse productFamily = addProductFamily(siteId);
		return addProductToFamily(productFamily.getId());
	}

	public ProductResponse addProductToFamily(int familyId) throws APIException {
		ProductRequest product = newProduct(familyId);
		product.setId(0);

		PricingPlanRequest pricingPlan = newPricingPlanRequest();
		product.getPricing_plans().add(pricingPlan);

		ProductPricingPlanPaymentScheduleRequest paymentSchedule = newProductPricingPlanPaymentScheduleRequest();
		pricingPlan.getPricing_plan_payment_schedules().add(paymentSchedule);

		List<ProductMeteredPriceRequest> meteredPriceList = new ArrayList<ProductMeteredPriceRequest>();
		ProductMeteredPriceRequest meteredPrice = new ProductMeteredPriceRequest();
		meteredPrice.setId(0);
		meteredPrice.setStart_quantity(1d);
		meteredPrice.setUnit_price(5d);
		meteredPrice.setEnd_quantity(10d);
		meteredPriceList.add(meteredPrice);

		ProductItemRequest productItem = newProductItemRequest("test product item 1", "2");
		productItem.setMetered_prices(meteredPriceList);
		pricingPlan.getProduct_items().add(productItem);

		meteredPriceList = new ArrayList<ProductMeteredPriceRequest>();
		meteredPrice = new ProductMeteredPriceRequest();
		meteredPrice.setId(0);
		meteredPrice.setStart_quantity(1d);
		meteredPrice.setUnit_price(10d);
		meteredPriceList.add(meteredPrice);

		productItem = newProductItemRequest("test product item 2", "0");
		productItem.setMetered_prices(meteredPriceList);
		pricingPlan.getProduct_items().add(productItem);

		return ProductsAPI.AddProduct(product);
	}

	public ProductItemRequest newProductItemRequest(String itemName, String itemType) {
		ProductItemRequest productItem = new ProductItemRequest();
		productItem.setCharge_model("0");
		productItem.setName(itemName);
		productItem.setItem_type(itemType);
		productItem.setIs_visible_on_hosted_page(true);

//		productItem.setDescription("");
		productItem.setProduct_item_children(null);
		productItem.setId(0);
		// setId=0

		return productItem;
	}

	public ProductPricingPlanPaymentScheduleRequest newProductPricingPlanPaymentScheduleRequest() {
		ProductPricingPlanPaymentScheduleRequest paymentSchedule = new ProductPricingPlanPaymentScheduleRequest();

		paymentSchedule.setId(0);
		paymentSchedule.setStart_date_offset_days(0);
		paymentSchedule.setEnd_date_offset_days(0);
		paymentSchedule.setSubscription_period_change(0d);

		paymentSchedule.setFrequency_interval(1);
		paymentSchedule.setFrequency_recurrence_factor(1);
		paymentSchedule.setFrequency_relative_interval("16");
		paymentSchedule.setFrequency_type("4");
		paymentSchedule.setName("name");
		return paymentSchedule;
	}

	public PricingPlanRequest newPricingPlanRequest(){
		PricingPlanRequest pricingPlan = new PricingPlanRequest();
		pricingPlan.setId(0);
		pricingPlan.setCurrency_code(newCurrency().getCode());
		pricingPlan.setName("TestPricingPlan");
		pricingPlan.setTrial_period_charge(100d);
		pricingPlan.setTrial_period_duration_days(3);
		pricingPlan.setUpfront_charge(200d);
		return pricingPlan;
	}

	public Currency newCurrency() {
		Currency currency = new Currency();
		currency.setCode("USD");
		currency.setId(1);
		currency.setName("US Dollars");
		return currency;
	}

	public ProductRequest newProduct(Integer familyId) {
		ProductRequest product = new ProductRequest();
		product.setProduct_family_id(familyId);
		product.setAccounting_code("AccountingCode");
		product.setApi_reference1("a5a563da2ff94f38aa6073ca17f02a54");
		product.setDescription("description");
		product.setIs_billing_address_at_signup_required("1");  // No = 0, Yes = 1, YesOptional = 2
		product.setIs_credit_card_at_signup_required("1");
		product.setName("name");
		return product;
	}

	public ProductFamilyRequest newProductFamily(Integer siteId) {
		ProductFamilyRequest pf = new ProductFamilyRequest();
		pf.setSite_id(siteId);
		pf.setName("name");
		pf.setDescription("description");
		return pf;
	}

	public CreditCardRequest newCreditCard() {
		CreditCardRequest card = new CreditCardRequest();
		card.setCard_number("4111111111111111");
		card.setCvv("123");
		card.setFirst_name_on_card("John B.");
		card.setLast_name_on_card("Wallace");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, 2);
		card.setExpiration_date(cal.getTime());
		return card;
	}

	public CustomerRequest newCustomer(){
		CustomerRequest customer = new CustomerRequest();
		customer.setFirst_name("John");
		customer.setLast_name("Wallace");
		customer.setEmail("a@a.com");
		customer.setPhone("3333333333");
		customer.setCompany("TEST & Co.");
		customer.setIs_shipping_address_same_to_billing(false);
		customer.setShipping_address(newAddress("shipping"));
		customer.setReference("12345");
		return customer;
	}

	public AddressRequest newAddress(String type) {
		AddressRequest address = new AddressRequest();
		address.setAddress1("St. King");
		address.setAddress2(type);
		address.setCity("London");
		address.setCountry("UK");
		address.setEmail("a@a.com");
		address.setCompany("TEST & Co.");
		address.setFax_number("1111111111");
		address.setPhone_number("3333333333");
		address.setState_province("London");
		address.setZip_postal_code("2222");
		address.setFirst_name("John");
		address.setLast_name("Wallace");
		return address;
	}

	public static class TestData {
		public Integer siteId;
	    public String subdomain;
	}
}

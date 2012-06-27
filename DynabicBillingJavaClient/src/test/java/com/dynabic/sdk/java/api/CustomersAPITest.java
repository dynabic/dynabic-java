package com.dynabic.sdk.java.api;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.dynabic.sdk.java.model.AddressRequest;
import com.dynabic.sdk.java.model.AddressResponse;
import com.dynabic.sdk.java.model.CreditCardRequest;
import com.dynabic.sdk.java.model.CreditCardResponse;
import com.dynabic.sdk.java.model.CustomerRequest;
import com.dynabic.sdk.java.model.CustomerResponse;
import com.wordnik.swagger.runtime.exception.APIException;

@Category(IntegrationTest.class)
public class CustomersAPITest extends AbstractIntegrationTest {

	private CustomerResponse customer;

	@Before
	public void setUpCustomer() throws APIException {
		log("Setting up customer...");
		customer = addCustomer(testData.subdomain);
		Assert.assertNotNull(customer);
		Assert.assertNotNull(customer.getId());
	}

	@After
	public void tearDownCustomer() throws APIException {
		log("Tearing down customer...");
		CustomersAPI.DeleteCustomer(customer.getId().toString());
	}

	@Test
	public void AddBillingAddress() throws APIException {
		AddressResponse address = addBillingAddress(customer.getId());
		Assert.assertNotNull(address);
		Assert.assertNotNull(address.getId());
	}

	@Test
	public void AddCreditCard() throws APIException {
		CreditCardResponse card = addCreditCard(customer.getId());
		Assert.assertNotNull(card);
		Assert.assertNotNull(card.getId());
	}

	@Test
	public void AddCustomer() throws APIException {
		Assert.assertNotNull(customer);
		Assert.assertNotNull(customer.getId());
	}

	@Test
	public void DeleteBillingAddress() throws APIException {
		AddressResponse address = addBillingAddress(customer.getId());
		Assert.assertNotNull(address);
		Assert.assertNotNull(address.getId());
		CustomersAPI.DeleteBillingAddress(customer.getId().toString(), address.getId().toString());
	}

	@Test
	public void DeleteCreditCard() throws APIException {
		CreditCardResponse card = addCreditCard(customer.getId());
		Assert.assertNotNull(card);
		Assert.assertNotNull(card.getId());
		CustomersAPI.DeleteCreditCard(customer.getId().toString(), card.getId().toString());
	}

	@Test
	public void DeleteCustomer() throws APIException {
		CustomersAPI.DeleteCustomer(customer.getId().toString());
	}

	@Test
	public void GetAllCustomers() throws APIException {
		List<CustomerResponse> customers = CustomersAPI.GetAllCustomers(testData.subdomain, "0", "10");
		Assert.assertNotNull(customers.get(0).getId());
	}

	@Test
	public void GetBillingAddress() throws APIException {
		addBillingAddress(customer.getId());
		AddressResponse address = CustomersAPI.GetBillingAddress(customer.getId().toString());
		Assert.assertNotNull(address);
		Assert.assertNotNull(address.getId());
	}

	@Test
	public void GetBillingAddresses() throws APIException {
		addBillingAddress(customer.getId());
		List<AddressResponse> addresses = CustomersAPI.GetBillingAddresses(customer.getId().toString());
		Assert.assertNotNull(addresses.get(0).getId());
	}

	@Test
	public void GetCreditCard() throws APIException {
		CreditCardResponse card = addCreditCard(customer.getId());
		Assert.assertNotNull(card);
		Assert.assertNotNull(card.getId());
		card = CustomersAPI.GetCreditCard(card.getId().toString());
		Assert.assertNotNull(card);
		Assert.assertNotNull(card.getId());
	}

	@Test
	public void GetCreditCards() throws APIException {
		CreditCardResponse card = addCreditCard(customer.getId());
		Assert.assertNotNull(card);
		Assert.assertNotNull(card.getId());
		List<CreditCardResponse> cards = CustomersAPI.GetCreditCards(customer.getId().toString());
		Assert.assertNotNull(cards.get(0).getId());
	}

	@Test
	public void GetCreditCardsByReferenceId() throws APIException {
		addCreditCard(customer.getId());
		List<CreditCardResponse> cards = CustomersAPI.GetCreditCardsByReferenceId(customer.getReference());
		Assert.assertNotNull(cards.get(0).getId());
	}

	@Test
	public void GetCustomer() throws APIException {
		CustomerResponse customerr = CustomersAPI.GetCustomer(customer.getId().toString());
		Assert.assertNotNull(customerr);
		Assert.assertNotNull(customerr.getId());
	}

	@Test
	public void GetCustomerByReferenceId() throws APIException {
		CustomerResponse customerr = CustomersAPI.GetCustomerByReferenceId(testData.subdomain, customer.getReference());
		Assert.assertNotNull(customerr);
		Assert.assertNotNull(customerr.getId());
	}

	@Test
	public void GetCustomersFirstCreditCard() throws APIException {
		addCreditCard(customer.getId());
		CreditCardResponse card = CustomersAPI.GetCustomersFirstCreditCard(customer.getId().toString());
		Assert.assertNotNull(card);
		Assert.assertNotNull(card.getId());
	}

	@Test
	public void GetFirstBillingAddressForCustomerByReferenceId() throws APIException {
		addBillingAddress(customer.getId());
		AddressResponse address = CustomersAPI.GetFirstBillingAddressForCustomerByReferenceId(testData.subdomain, customer.getReference());
		Assert.assertNotNull(address);
		Assert.assertNotNull(address.getId());
	}

	@Test
	public void GetFirstCreditCardForCustomerByReferenceId() throws APIException {
		addCreditCard(customer.getId());
		CreditCardResponse card = CustomersAPI.GetFirstCreditCardForCustomerByReferenceId(customer.getReference());
		Assert.assertNotNull(card);
		Assert.assertNotNull(card.getId());
	}

	@Test
	public void UpdateBillingAddress() throws APIException {
		AddressResponse address = addBillingAddress(customer.getId());
		Assert.assertNotNull(address);
		Assert.assertNotNull(address.getId());

		AddressRequest newAddress = newAddress("billing");
		newAddress.setAddress1(address.getAddress1() + "_updated");
		AddressResponse updatedAddress = CustomersAPI.UpdateBillingAddress(customer.getId().toString(), address.getId().toString(), newAddress);
		Assert.assertNotNull(updatedAddress);
		Assert.assertEquals(updatedAddress.getAddress1(), newAddress.getAddress1());
	}

	@Test
	public void UpdateBillingAddressByCustomerReferenceId() throws APIException {
		AddressResponse address = addBillingAddress(customer.getId());
		Assert.assertNotNull(address);
		Assert.assertNotNull(address.getId());

		AddressRequest newAddress = newAddress("billing");
		newAddress.setAddress1(address.getAddress1() + "_updated");
		AddressResponse updatedAddress = CustomersAPI.UpdateBillingAddressByCustomerReferenceId(testData.subdomain, customer.getReference(), address.getId().toString(), newAddress);
		Assert.assertNotNull(updatedAddress);
		Assert.assertEquals(updatedAddress.getAddress1(), newAddress.getAddress1());
	}

	@Test
	public void UpdateCreditCard() throws APIException {
		CreditCardResponse card = addCreditCard(customer.getId());
		Assert.assertNotNull(card);
		Assert.assertNotNull(card.getId());

		CreditCardRequest newCard = newCreditCard();
		newCard.setFirst_name_on_card(card.getFirst_name_on_card() + "_updated");
		CreditCardResponse updatedCard = CustomersAPI.UpdateCreditCard(customer.getId().toString(), card.getId().toString(), newCard);
		Assert.assertNotNull(updatedCard);
		Assert.assertEquals(updatedCard.getFirst_name_on_card(), newCard.getFirst_name_on_card());
	}

	@Test
	public void UpdateCreditCardByCustomerReferenceId() throws APIException {
		CreditCardResponse card = addCreditCard(customer.getId());
		Assert.assertNotNull(card);
		Assert.assertNotNull(card.getId());

		CreditCardRequest newCard = newCreditCard();
		newCard.setFirst_name_on_card(card.getFirst_name_on_card() + "_updated");
		CreditCardResponse updatedCard = CustomersAPI.UpdateCreditCardByCustomerReferenceId(testData.subdomain, customer.getReference(), card.getId().toString(), newCard);
		Assert.assertNotNull(updatedCard);
		Assert.assertEquals(updatedCard.getFirst_name_on_card(), newCard.getFirst_name_on_card());
	}

	@Test
	public void UpdateCustomer() throws APIException {
		CustomerRequest newCustomer = newCustomer();
		newCustomer.setCompany(customer.getCompany() + "_updated");
		CustomerResponse updatedCustomer = CustomersAPI.UpdateCustomer(newCustomer, customer.getId().toString());
		Assert.assertNotNull(updatedCustomer);
		Assert.assertEquals(updatedCustomer.getCompany(), newCustomer.getCompany());
	}
}

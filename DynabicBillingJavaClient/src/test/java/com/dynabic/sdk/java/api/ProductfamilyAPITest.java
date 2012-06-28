package com.dynabic.sdk.java.api;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.dynabic.sdk.java.model.ProductFamilyRequest;
import com.dynabic.sdk.java.model.ProductFamilyResponse;
import com.wordnik.swagger.runtime.exception.APIException;

@Category(IntegrationTest.class)
public class ProductfamilyAPITest extends AbstractIntegrationTest {

	private ProductFamilyResponse pf;

	@Before
	public void setUpProductFamily() throws APIException {
		log("Setting up ProductFamily...");
		pf = addProductFamily(testData.siteId);
		Assert.assertNotNull(pf);
		Assert.assertNotNull(pf.getId());
	}

	@After
	public void tearDownProductFamily() {
		if(pf == null) {
			return;
		}

		log("Tearing down ProductFamily...");
		try {
			ProductfamilyAPI.DeleteProductFamily(pf.getId().toString());
		} catch (APIException ignore) {
			// already deleted
		}
	}

	@Test
	public void ActivateProductFamily() throws APIException {
		ProductFamilyResponse productFamily = ProductfamilyAPI.GetProductFamilyById(pf.getId().toString());
		Assert.assertNotNull(productFamily);
		Assert.assertFalse(productFamily.getIs_archived());

		// Archive product family
		ProductfamilyAPI.ArchiveProductFamily(productFamily.getId().toString());
		productFamily = ProductfamilyAPI.GetProductFamilyById(productFamily.getId().toString());
		Assert.assertNotNull(productFamily);
		Assert.assertTrue(productFamily.getIs_archived());

		// Activate product family
		ProductfamilyAPI.ActivateProductFamily(productFamily.getId().toString(), null);
		productFamily = ProductfamilyAPI.GetProductFamilyById(productFamily.getId().toString());
		Assert.assertNotNull(productFamily);
		Assert.assertFalse(productFamily.getIs_archived());
	}

	@Test
	public void AddProductFamily() {
		Assert.assertNotNull(pf);
	}

	@Test
	public void ArchiveProductFamily() throws APIException {
		ProductFamilyResponse productFamily = ProductfamilyAPI.GetProductFamilyById(pf.getId().toString());
		Assert.assertNotNull(productFamily);
		Assert.assertFalse(productFamily.getIs_archived());

		// Archive product family
		ProductfamilyAPI.ArchiveProductFamily(productFamily.getId().toString());
		productFamily = ProductfamilyAPI.GetProductFamilyById(productFamily.getId().toString());
		Assert.assertNotNull(productFamily);
		Assert.assertTrue(productFamily.getIs_archived());
	}

	@Test
	public void DeleteProductFamily() throws APIException {
		ProductFamilyResponse productFamily = ProductfamilyAPI.GetProductFamilyById(pf.getId().toString());
		Assert.assertNotNull(productFamily);

		ProductfamilyAPI.DeleteProductFamily(pf.getId().toString());
		pf = null;
		List<ProductFamilyResponse> productFamilies = ProductfamilyAPI.GetProductFamilies(testData.subdomain, null, null, null);
		Assert.assertNotNull(productFamilies);
		Assert.assertTrue(productFamilies.size() == 0);
	}

	@Test
	public void GetProductFamilies() throws APIException {
		List<ProductFamilyResponse> productFamilies = ProductfamilyAPI.GetProductFamilies(testData.subdomain, null, null, null);
		Assert.assertNotNull(productFamilies);
		Assert.assertTrue(productFamilies.size() > 0);
	}

	@Test
	public void GetProductFamilyById() throws APIException {
		ProductFamilyResponse productFamily = ProductfamilyAPI.GetProductFamilyById(pf.getId().toString());
		Assert.assertNotNull(productFamily);
		Assert.assertEquals(productFamily.getId(), pf.getId());
	}

	@Test
	public void GetProductFamilyByName() throws APIException {
		ProductFamilyResponse productFamily = ProductfamilyAPI.GetProductFamilyByName(testData.subdomain, pf.getName());
		Assert.assertNotNull(productFamily);
		Assert.assertEquals(productFamily.getId(), pf.getId());
	}

	@Test
	public void UpdateProductFamily() throws APIException {
		ProductFamilyRequest postData = new ProductFamilyRequest();
		postData.setName(pf.getName() + "_updated");
		postData.setSite_id(testData.siteId);
		ProductFamilyResponse productFamily = ProductfamilyAPI.UpdateProductFamily(postData , pf.getId().toString());
		Assert.assertNotNull(productFamily);
		Assert.assertEquals(productFamily.getName(), postData.getName());
	}
}

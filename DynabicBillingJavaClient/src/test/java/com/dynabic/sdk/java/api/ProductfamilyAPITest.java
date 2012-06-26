package com.dynabic.sdk.java.api;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dynabic.sdk.java.model.ProductFamilyRequest;
import com.dynabic.sdk.java.model.ProductFamilyResponse;
import com.wordnik.swagger.runtime.exception.APIException;

public class ProductfamilyAPITest extends AbstractIntegrationTest {

	private ProductFamilyResponse pf;

	@BeforeMethod(dependsOnMethods = { "setUpSite" })
	public void setUpProductFamily(Method m) throws APIException {
		log("Setting up ProductFamily...");
		pf = addProductFamily(testData.siteId);
		Assert.assertNotNull(pf);
		Assert.assertNotNull(pf.getId());
		log("Executing test case " + m.getName() + "()");
	}

	@AfterMethod
	public void tearDownProductFamily() {
		log("Tearing down ProductFamily...");
		try {
			ProductfamilyAPI.DeleteProductFamily(pf.getId().toString());
		} catch (APIException ignore) {
			// already deleted
		}
	}

	@Test(groups={"integration"})
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

	@Test(groups={"integration"})
	public void AddProductFamily() {
		Assert.assertNotNull(pf);
	}

	@Test(groups={"integration"})
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

	@Test(groups={"integration"})
	public void DeleteProductFamily() throws APIException {
		ProductFamilyResponse productFamily = ProductfamilyAPI.GetProductFamilyById(pf.getId().toString());
		Assert.assertNotNull(productFamily);

		ProductfamilyAPI.DeleteProductFamily(pf.getId().toString());
		List<ProductFamilyResponse> productFamilies = ProductfamilyAPI.GetProductFamilies(testData.subdomain, null, null, null);
		Assert.assertNotNull(productFamilies);
		Assert.assertTrue(productFamilies.size() == 0);
	}

	@Test(groups={"integration"})
	public void GetProductFamilies() throws APIException {
		List<ProductFamilyResponse> productFamilies = ProductfamilyAPI.GetProductFamilies(testData.subdomain, null, null, null);
		Assert.assertNotNull(productFamilies);
		Assert.assertTrue(productFamilies.size() > 0);
	}

	@Test(groups={"integration"})
	public void GetProductFamilyById() throws APIException {
		ProductFamilyResponse productFamily = ProductfamilyAPI.GetProductFamilyById(pf.getId().toString());
		Assert.assertNotNull(productFamily);
		Assert.assertEquals(productFamily.getId(), pf.getId());
	}

	@Test(groups={"integration"})
	public void GetProductFamilyByName() throws APIException {
		ProductFamilyResponse productFamily = ProductfamilyAPI.GetProductFamilyByName(testData.subdomain, pf.getName());
		Assert.assertNotNull(productFamily);
		Assert.assertEquals(productFamily.getId(), pf.getId());
	}

	@Test(groups={"integration"})
	public void UpdateProductFamily() throws APIException {
		ProductFamilyRequest postData = new ProductFamilyRequest();
		postData.setName(pf.getName() + "_updated");
		postData.setSite_id(testData.siteId);
		ProductFamilyResponse productFamily = ProductfamilyAPI.UpdateProductFamily(postData , pf.getId().toString());
		Assert.assertNotNull(productFamily);
		Assert.assertEquals(productFamily.getName(), postData.getName());
	}
}

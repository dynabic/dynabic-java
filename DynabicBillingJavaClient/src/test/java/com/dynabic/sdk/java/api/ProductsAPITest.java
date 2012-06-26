package com.dynabic.sdk.java.api;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dynabic.sdk.java.model.ProductRequest;
import com.dynabic.sdk.java.model.ProductResponse;
import com.wordnik.swagger.runtime.exception.APIException;

public class ProductsAPITest extends AbstractIntegrationTest {

	private ProductResponse product;

	@BeforeMethod(dependsOnMethods = { "setUpSite" })
	public void setUpSubscription(Method m) throws APIException {
		log("Setting up Product...");
		product = addProduct(testData.siteId);
		Assert.assertNotNull(product);
		Assert.assertNotNull(product.getId());
		log("Executing test case " + m.getName() + "()");
	}

	@AfterMethod
	public void tearDownSubscription() {
		log("Tearing down Product...");
		try {
			SubscriptionsAPI.DeleteSubscription(product.getId().toString());
		} catch (APIException ignore) {
			// already deleted
		}
	}

	@Test(groups={"integration"})
	public void ActivateProduct() throws APIException {
		Assert.assertFalse(product.getIs_archived());

		// Archive product family
		ProductsAPI.ArchiveProduct(product.getId().toString());
		ProductResponse prd = ProductsAPI.GetProductById(product.getId().toString());
		Assert.assertTrue(prd.getIs_archived());

		// Activate product family
		ProductsAPI.ActivateProduct(product.getId().toString());
		prd = ProductsAPI.GetProductById(product.getId().toString());
		Assert.assertFalse(prd.getIs_archived());
	}

	@Test(groups={"integration"})
	public void AddProduct() {
		Assert.assertNotNull(product);
		Assert.assertNotNull(product.getId());
	}

	@Test(groups={"integration"})
	public void ArchiveProduct() throws APIException {
		Assert.assertFalse(product.getIs_archived());

		// Archive product family
		ProductsAPI.ArchiveProduct(product.getId().toString());
		ProductResponse prd = ProductsAPI.GetProductById(product.getId().toString());
		Assert.assertTrue(prd.getIs_archived());
	}

	@Test(groups={"integration"})
	public void DeleteProduct() throws APIException {
		ProductsAPI.DeleteProduct(product.getId().toString());
		ProductResponse prd = ProductsAPI.GetProductById(product.getId().toString());
		Assert.assertNull(prd);
	}

	@Test(groups={"integration"})
	public void GetProductByApiRef() throws APIException {
		ProductResponse prd = ProductsAPI.GetProductByApiRef(testData.siteId.toString(), product.getApi_reference1());
		Assert.assertNotNull(prd);
	}

	@Test(groups={"integration"})
	public void GetProductByFamilyIdAndProductName() throws APIException {
		ProductResponse prd = ProductsAPI.GetProductByFamilyIdAndProductName(product.getProduct_family_id().toString(), product.getName());
		Assert.assertNotNull(prd);
	}

	@Test(groups={"integration"})
	public void GetProductById() throws APIException {
		ProductResponse prd = ProductsAPI.GetProductById(product.getId().toString());
		Assert.assertNotNull(prd);
	}

	@Test(groups={"integration"})
	public void GetProductsByFamilyId() throws APIException {
		List<ProductResponse> products = ProductsAPI.GetProductsByFamilyId(product.getProduct_family_id().toString(), null);
		Assert.assertNotNull(products);
		Assert.assertEquals(products.size(), 1);
	}

	@Test(groups={"integration"})
	public void GetProductsBySite() throws APIException {
		List<ProductResponse> products = ProductsAPI.GetProductsBySite(testData.subdomain, null, null, null);
		Assert.assertNotNull(products);
		Assert.assertEquals(products.size(), 1);
	}

	@Test(groups={"integration"})
	public void GetProductsBySiteAndFamily() throws APIException {
		List<ProductResponse> products = ProductsAPI.GetProductsBySiteAndFamily(testData.subdomain, product.getProduct_family_id().toString(), null);
		Assert.assertNotNull(products);
		Assert.assertEquals(products.size(), 1);
	}

	@Test(groups={"integration"})
	public void GetProductsBySiteAndProductName() throws APIException {
		List<ProductResponse> products = ProductsAPI.GetProductsBySiteAndProductName(testData.subdomain, product.getName());
		Assert.assertNotNull(products);
		Assert.assertEquals(products.size(), 1);
	}

	@Test(groups={"integration"})
	public void UpdateProduct() throws APIException {
		ProductRequest newProduct = newProduct(product.getProduct_family_id());
		newProduct.setApi_reference1(product.getApi_reference1() + "_updated");
		ProductResponse updatedProduct = ProductsAPI.UpdateProduct(newProduct, product.getId().toString());
		Assert.assertNotNull(updatedProduct);
		Assert.assertEquals(newProduct.getApi_reference1(), updatedProduct.getApi_reference1());
	}
}

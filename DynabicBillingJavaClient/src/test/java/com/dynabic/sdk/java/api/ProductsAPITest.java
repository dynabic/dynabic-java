package com.dynabic.sdk.java.api;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.dynabic.sdk.java.model.ProductRequest;
import com.dynabic.sdk.java.model.ProductResponse;
import com.wordnik.swagger.runtime.exception.APIException;

@Category(IntegrationTest.class)
public class ProductsAPITest extends AbstractIntegrationTest {

	private ProductResponse product;

	@Before
	public void setUpProduct() throws APIException {
		log("Setting up Product...");
		product = addProduct(testData.siteId);
		Assert.assertNotNull(product);
		Assert.assertNotNull(product.getId());
	}

	@After
	public void tearDownProduct() {
		if(product == null) {
			return;
		}

		log("Tearing down Product...");
		try {
			ProductsAPI.DeleteProduct(product.getId().toString());
		} catch (APIException ignore) {
			// already deleted
		}
	}

	@Test
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

	@Test
	public void AddProduct() {
		Assert.assertNotNull(product);
		Assert.assertNotNull(product.getId());
	}

	@Test
	public void ArchiveProduct() throws APIException {
		Assert.assertFalse(product.getIs_archived());

		// Archive product family
		ProductsAPI.ArchiveProduct(product.getId().toString());
		ProductResponse prd = ProductsAPI.GetProductById(product.getId().toString());
		Assert.assertTrue(prd.getIs_archived());
	}

	@Test
	public void DeleteProduct() throws APIException {
		ProductsAPI.DeleteProduct(product.getId().toString());
		product = null;
	}

	@Test
	public void GetProductByApiRef() throws APIException {
		ProductResponse prd = ProductsAPI.GetProductByApiRef(testData.siteId.toString(), product.getApi_reference1());
		Assert.assertNotNull(prd);
	}

	@Test
	public void GetProductByFamilyIdAndProductName() throws APIException {
		ProductResponse prd = ProductsAPI.GetProductByFamilyIdAndProductName(product.getProduct_family_id().toString(), product.getName());
		Assert.assertNotNull(prd);
	}

	@Test
	public void GetProductById() throws APIException {
		ProductResponse prd = ProductsAPI.GetProductById(product.getId().toString());
		Assert.assertNotNull(prd);
	}

	@Test
	public void GetProductsByFamilyId() throws APIException {
		List<ProductResponse> products = ProductsAPI.GetProductsByFamilyId(product.getProduct_family_id().toString(), null);
		Assert.assertNotNull(products);
		Assert.assertEquals(products.size(), 1);
	}

	@Test
	public void GetProductsBySite() throws APIException {
		List<ProductResponse> products = ProductsAPI.GetProductsBySite(testData.subdomain, null, null, null);
		Assert.assertNotNull(products);
		Assert.assertEquals(products.size(), 1);
	}

	@Test
	public void GetProductsBySiteAndFamily() throws APIException {
		List<ProductResponse> products = ProductsAPI.GetProductsBySiteAndFamily(testData.subdomain, "name", null); //"name" is the product family name
		Assert.assertNotNull(products);
		Assert.assertEquals(products.size(), 1);
	}

	@Test
	public void GetProductsBySiteAndProductName() throws APIException {
		List<ProductResponse> products = ProductsAPI.GetProductsBySiteAndProductName(testData.subdomain, product.getName());
		Assert.assertNotNull(products);
		Assert.assertEquals(products.size(), 1);
	}

	@Test
	public void UpdateProduct() throws APIException {
		ProductRequest newProduct = newProduct(product.getProduct_family_id());
		newProduct.setApi_reference1(product.getApi_reference1() + "_updated");
        newProduct.setId(product.getId());
		ProductResponse updatedProduct = ProductsAPI.UpdateProduct(newProduct, product.getId().toString());
		Assert.assertNotNull(updatedProduct);
		Assert.assertEquals(newProduct.getApi_reference1(), updatedProduct.getApi_reference1());
	}
}

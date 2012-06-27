package com.dynabic.sdk.java.platform.api;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;

import com.dynabic.sdk.java.platform.model.UserRequest;
import com.dynabic.sdk.java.platform.model.UserResponse;
import com.wordnik.swagger.runtime.exception.APIException;

@Category(IntegrationTest.class)
public class UsersAPITest extends AbstractIntegrationTest {

	private UserResponse user;

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUpUser() throws APIException {
		log("Setting up user...");
		user = addUser(testData.subdomain);
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getId());

		log("Executing test case " + testName.getMethodName() + "()");
	}

	@After
	public void tearDownUser() {
		log("Tearing down user...");
		try {
			UsersAPI.DeleteUser(user.getId().toString());
		} catch (APIException ignore) {
			// already deleted
		}
	}

	@Test
	public void AddUser() {
		Assert.assertNotNull(user);
	}

	@Test
	public void DeleteUser() throws APIException {
		UsersAPI.DeleteUser(user.getId().toString());
	}

	@Test
	public void GetAllUsers() throws APIException {
		List<UserResponse> users = UsersAPI.GetAllUsers(null,  null);
		Assert.assertNotNull(users);
	}

	@Test
	public void GetUserById() throws APIException {
		UserResponse userById = UsersAPI.GetUserById(user.getId().toString());
		Assert.assertNotNull(userById);
	}

	@Test
	public void GetUserByUserName() throws APIException {
		UserResponse userByName = UsersAPI.GetUserByUserName("b@b.com");
		Assert.assertNotNull(userByName);
		UsersAPI.DeleteUser(userByName.getId().toString());
	}

	@Test
	public void ModifyPassword() throws APIException {
		UsersAPI.ModifyPassword(user.getId().toString(), "test123", "newPassword");
	}

	@Test
	public void ResetPassword() throws APIException {
		UsersAPI.ResetPassword(user.getId().toString());
	}

	@Test
	public void SetActiveStatus() throws APIException {
		UsersAPI.SetActiveStatus(user.getId().toString(), "false");
		UserResponse userById = UsersAPI.GetUserById(user.getId().toString());
		Assert.assertNotNull(userById);
		Assert.assertFalse(userById.getActive());
	}

	@Test
	public void SetDeletedStatus() throws APIException {
		Assert.assertFalse(user.getDeleted());
		UsersAPI.SetDeletedStatus(user.getId().toString(), "true");
		UserResponse userById = UsersAPI.GetUserById(user.getId().toString());
		Assert.assertNotNull(userById);
		Assert.assertTrue(userById.getDeleted());
	}

	@Test
	public void SetRoles() throws APIException {
		// remove all roles
		UsersAPI.SetRoles(user.getId().toString(), "");
		UserResponse userById = UsersAPI.GetUserById(user.getId().toString());
		Assert.assertNotNull(userById);
		Assert.assertTrue(userById.getUser_roles().isEmpty());

		// grant user to two roles
		UsersAPI.SetRoles(user.getId().toString(), "user,admin");
		userById = UsersAPI.GetUserById(user.getId().toString());
		Assert.assertNotNull(userById);
		Assert.assertEquals(userById.getUser_roles(), "Admin,User");
	}

	@Test
	public void UpdateUser() throws APIException {
		UserRequest postData = new UserRequest();
		postData.setFirst_name(user.getFirst_name() + "_updated");
		postData.setLast_name(user.getLast_name());
		postData.setActive(user.getActive());
		postData.setEmail(user.getEmail());
		postData.setDeleted(user.getDeleted());
		postData.setIs_subscribed_to_newsletter(user.getIs_subscribed_to_newsletter());
		postData.setFacebook_id(user.getFacebook_id());
		postData.setGoogleapps_user_name(user.getGoogleapps_user_name());
		postData.setFirst_name(user.getFirst_name());
		postData.setYahoo_user_name("yahoo_user_name");
		postData.setCurrency(user.getCurrency());
		postData.setCountry(user.getCountry());
		postData.setCulture(user.getCulture());
		postData.setTimezone(user.getTimezone());
		UserResponse updatedUser = UsersAPI.UpdateUser(postData, user.getId().toString());
		Assert.assertNotNull(updatedUser);
		Assert.assertEquals(updatedUser.getFirst_name(), postData.getFirst_name());
	}
}

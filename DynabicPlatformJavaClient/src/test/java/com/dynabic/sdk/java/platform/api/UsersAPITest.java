package com.dynabic.sdk.java.platform.api;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dynabic.sdk.java.platform.model.UserRequest;
import com.dynabic.sdk.java.platform.model.UserResponse;
import com.wordnik.swagger.runtime.exception.APIException;

public class UsersAPITest extends AbstractIntegrationTest {

	private UserResponse user;

	@BeforeMethod(dependsOnMethods = {"setUpSite"})
	public void setUpUser(Method m) throws APIException {
		log("Setting up user...");
		user = addUser(testData.subdomain);
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getId());
		log("Executing test case " + m.getName() + "()");
	}

	@AfterMethod
	public void tearDownUser() {
		log("Tearing down user...");
		try {
			UsersAPI.DeleteUser(user.getId().toString());
		} catch (APIException ignore) {
			// already deleted
		}
	}

	@Test(groups={"integration"})
	public void AddUser() {
		Assert.assertNotNull(user);
	}

	@Test(groups={"integration"})
	public void DeleteUser() throws APIException {
		UsersAPI.DeleteUser(user.getId().toString());
	}

	@Test(groups={"integration"})
	public void GetAllUsers() throws APIException {
		List<UserResponse> users = UsersAPI.GetAllUsers(null,  null);
		Assert.assertNotNull(users);
	}

	@Test(groups={"integration"})
	public void GetUserById() throws APIException {
		UserResponse userById = UsersAPI.GetUserById(user.getId().toString());
		Assert.assertNotNull(userById);
	}

	@Test(groups={"integration"})
	public void GetUserByUserName() throws APIException {
		UserResponse userByName = UsersAPI.GetUserByUserName("b@b.com");
		Assert.assertNotNull(userByName);
		UsersAPI.DeleteUser(userByName.getId().toString());
	}

	@Test(groups={"integration"})
	public void ModifyPassword() throws APIException {
		UsersAPI.ModifyPassword(user.getId().toString(), "test123", "newPassword");
	}

	@Test(groups={"integration"})
	public void ResetPassword() throws APIException {
		UsersAPI.ResetPassword(user.getId().toString());
	}

	@Test(groups={"integration"})
	public void SetActiveStatus() throws APIException {
		UsersAPI.SetActiveStatus(user.getId().toString(), "false");
		UserResponse userById = UsersAPI.GetUserById(user.getId().toString());
		Assert.assertNotNull(userById);
		Assert.assertFalse(userById.getActive());
	}

	@Test(groups={"integration"})
	public void SetDeletedStatus() throws APIException {
		UsersAPI.SetDeletedStatus(user.getId().toString(), "true");
		UserResponse userById = UsersAPI.GetUserById(user.getId().toString());
		Assert.assertNotNull(userById);
		Assert.assertFalse(userById.getDeleted());
	}

	@Test(groups={"integration"})
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

	@Test(groups={"integration"})
	public void UpdateUser() throws APIException {
		UserRequest postData = new UserRequest();
		postData.setFirst_name(user.getFirst_name() + "_updated");
		UserResponse updatedUser = UsersAPI.UpdateUser(postData, user.getId().toString());
		Assert.assertNotNull(updatedUser);
		Assert.assertEquals(updatedUser.getFirst_name(), postData.getFirst_name());
	}
}

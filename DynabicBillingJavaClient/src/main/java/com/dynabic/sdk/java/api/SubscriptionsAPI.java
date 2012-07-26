/**
 *  Copyright 2011 Wordnik, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

 package com.dynabic.sdk.java.api;


import com.dynabic.sdk.java.model.*;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import com.wordnik.swagger.runtime.annotations.*;
import com.wordnik.swagger.runtime.common.*;
import com.wordnik.swagger.runtime.exception.*;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.lang.Long;
import java.io.IOException;


/**
 *
 * NOTE: This class is auto generated by the swagger code generator program. Do not edit the class manually.
 * @author ramesh
 *
 */
public class SubscriptionsAPI extends Object {

    private static APIInvoker apiInvoker = null;


	/**
	 * GetSubscriptions
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param pageNumber  page number
     *  @param pageSize  page size
     *  
	 * @return List<SubscriptionResponse> {@link SubscriptionResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, pageNumber, pageSize")
	 public static List<SubscriptionResponse> GetSubscriptions(String siteSubdomain, String pageNumber, String pageSize) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/bysite/{siteSubdomain}.{format}?pageNumber={pageNumber}&pageSize={pageSize}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

		if( pageNumber != null) {
			resourcePath = resourcePath.replace("{pageNumber}", APIInvoker.toPathValue(pageNumber));
		}

		if( pageSize != null) {
			resourcePath = resourcePath.replace("{pageSize}", APIInvoker.toPathValue(pageSize));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<SubscriptionResponse>> typeRef = new TypeReference<ArrayList<SubscriptionResponse>>() {};
        try {
            List<SubscriptionResponse> responseObject = (List<SubscriptionResponse>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetSubscriptionsForStatus
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param status  status
     *  @param pageNumber  page number
     *  @param pageSize  page size
     *  
	 * @return List<SubscriptionResponse> {@link SubscriptionResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, status, pageNumber, pageSize")
	 public static List<SubscriptionResponse> GetSubscriptionsForStatus(String siteSubdomain, String status, String pageNumber, String pageSize) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/{siteSubdomain}/status={status}.{format}?pageNumber={pageNumber}&pageSize={pageSize}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

		if( status != null) {
			resourcePath = resourcePath.replace("{status}", APIInvoker.toPathValue(status));
		}

		if( pageNumber != null) {
			resourcePath = resourcePath.replace("{pageNumber}", APIInvoker.toPathValue(pageNumber));
		}

		if( pageSize != null) {
			resourcePath = resourcePath.replace("{pageSize}", APIInvoker.toPathValue(pageSize));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<SubscriptionResponse>> typeRef = new TypeReference<ArrayList<SubscriptionResponse>>() {};
        try {
            List<SubscriptionResponse> responseObject = (List<SubscriptionResponse>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetSubscription
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  
	 * @return SubscriptionResponse {@link SubscriptionResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId")
	 public static SubscriptionResponse GetSubscription(String subscriptionId) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/{subscriptionId}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		SubscriptionResponse responseObject = (SubscriptionResponse) getApiInvoker().deserialize(response, SubscriptionResponse.class);
		return responseObject;
	}


	/**
	 * GetSubscriptionsOfCustomer
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  
	 * @return List<SubscriptionResponse> {@link SubscriptionResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId")
	 public static List<SubscriptionResponse> GetSubscriptionsOfCustomer(String customerId) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/{customerId}/subscriptions.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( customerId != null) {
			resourcePath = resourcePath.replace("{customerId}", APIInvoker.toPathValue(customerId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<SubscriptionResponse>> typeRef = new TypeReference<ArrayList<SubscriptionResponse>>() {};
        try {
            List<SubscriptionResponse> responseObject = (List<SubscriptionResponse>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetSubscriptionsOfCustomerByReferenceId
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param customerReferenceId  customer Reference Id
     *  
	 * @return List<SubscriptionResponse> {@link SubscriptionResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, customerReferenceId")
	 public static List<SubscriptionResponse> GetSubscriptionsOfCustomerByReferenceId(String siteSubdomain, String customerReferenceId) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/{siteSubdomain}/{customerReferenceId}/subscriptions.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

		if( customerReferenceId != null) {
			resourcePath = resourcePath.replace("{customerReferenceId}", APIInvoker.toPathValue(customerReferenceId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<SubscriptionResponse>> typeRef = new TypeReference<ArrayList<SubscriptionResponse>>() {};
        try {
            List<SubscriptionResponse> responseObject = (List<SubscriptionResponse>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * AddSubscription
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param postData  new Subscription
     *  
	 * @return SubscriptionResponse {@link SubscriptionResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, postData")
	 public static SubscriptionResponse AddSubscription(String siteSubdomain, SubscriptionRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/{siteSubdomain}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "POST";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		SubscriptionResponse responseObject = (SubscriptionResponse) getApiInvoker().deserialize(response, SubscriptionResponse.class);
		return responseObject;
	}


	/**
	 * UpdateSubscription
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param subscriptionId  subscription Id
     *  @param postData  updated Subscription
     *  
	 * @return SubscriptionResponse {@link SubscriptionResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, subscriptionId, postData")
	 public static SubscriptionResponse UpdateSubscription(String siteSubdomain, String subscriptionId, SubscriptionRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/{siteSubdomain}/{subscriptionId}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		SubscriptionResponse responseObject = (SubscriptionResponse) getApiInvoker().deserialize(response, SubscriptionResponse.class);
		return responseObject;
	}


	/**
	 * DeleteSubscription
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId")
	 public static void DeleteSubscription(String subscriptionId) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/{subscriptionId}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "DELETE";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
	}


	/**
	 * GetAddress
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  
	 * @return AddressResponse {@link AddressResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId")
	 public static AddressResponse GetAddress(String subscriptionId) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/{subscriptionId}/billing-address.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		AddressResponse responseObject = (AddressResponse) getApiInvoker().deserialize(response, AddressResponse.class);
		return responseObject;
	}


	/**
	 * GetCustomersForProduct
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  
	 * @return List<CustomerResponse> {@link CustomerResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId")
	 public static List<CustomerResponse> GetCustomersForProduct(String subscriptionId) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/{subscriptionId}/customers.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<CustomerResponse>> typeRef = new TypeReference<ArrayList<CustomerResponse>>() {};
        try {
            List<CustomerResponse> responseObject = (List<CustomerResponse>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * AddChargeToSubscription
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  @param postData  charge
     *  
	 * @return TransactionResponse {@link TransactionResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId, postData")
	 public static TransactionResponse AddChargeToSubscription(String subscriptionId, ChargeRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/charge/{subscriptionId}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		TransactionResponse responseObject = (TransactionResponse) getApiInvoker().deserialize(response, TransactionResponse.class);
		return responseObject;
	}


	/**
	 * Refund
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  @param postData  charge
     *  @param transactionId  transaction Id
     *  
	 * @return TransactionResponse {@link TransactionResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId, postData, transactionId")
	 public static TransactionResponse Refund(String subscriptionId, ChargeRequest postData, String transactionId) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/refund/{subscriptionId}/{transactionId}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

		if( transactionId != null) {
			resourcePath = resourcePath.replace("{transactionId}", APIInvoker.toPathValue(transactionId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		TransactionResponse responseObject = (TransactionResponse) getApiInvoker().deserialize(response, TransactionResponse.class);
		return responseObject;
	}


	/**
	 * AdjustSubscriptionBalance
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  @param isAmountAbsolute  is Amount Absolute
     *  @param postData  charge
     *  
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId, isAmountAbsolute, postData")
	 public static void AdjustSubscriptionBalance(String subscriptionId, String isAmountAbsolute, ChargeRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/adjustbalance/{subscriptionId}/{isAmountAbsolute}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

		if( isAmountAbsolute != null) {
			resourcePath = resourcePath.replace("{isAmountAbsolute}", APIInvoker.toPathValue(isAmountAbsolute));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
	}


	/**
	 * ChangeSubscriptionProduct
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  @param newProductPricingPlanId  new Product Pricing Plan Id
     *  
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId, newProductPricingPlanId")
	 public static void ChangeSubscriptionProduct(String subscriptionId, String newProductPricingPlanId) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/changeproduct/{subscriptionId}/{newProductPricingPlanId}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

		if( newProductPricingPlanId != null) {
			resourcePath = resourcePath.replace("{newProductPricingPlanId}", APIInvoker.toPathValue(newProductPricingPlanId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
	}


	/**
	 * UpgradeDowngradeSubscriptionProduct
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  @param newProductPricingPlanId  new Product Pricing Plan Id
     *  @param includeTrial  include Trial
     *  @param includeUpfrontCharge  include Upfront Charge
     *  
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId, newProductPricingPlanId, includeTrial, includeUpfrontCharge")
	 public static void UpgradeDowngradeSubscriptionProduct(String subscriptionId, String newProductPricingPlanId, String includeTrial, String includeUpfrontCharge) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/upgradedowngrade/{subscriptionId}/{newProductPricingPlanId}/{includeTrial}/{includeUpfrontCharge}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

		if( newProductPricingPlanId != null) {
			resourcePath = resourcePath.replace("{newProductPricingPlanId}", APIInvoker.toPathValue(newProductPricingPlanId));
		}

		if( includeTrial != null) {
			resourcePath = resourcePath.replace("{includeTrial}", APIInvoker.toPathValue(includeTrial));
		}

		if( includeUpfrontCharge != null) {
			resourcePath = resourcePath.replace("{includeUpfrontCharge}", APIInvoker.toPathValue(includeUpfrontCharge));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
	}


	/**
	 * CancelSubscription
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  @param postData  request
     *  
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId, postData")
	 public static void CancelSubscription(String subscriptionId, CancellationRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/cancel/{subscriptionId}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
	}


	/**
	 * ReactivateSubscription
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId")
	 public static void ReactivateSubscription(String subscriptionId) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/reactivate/{subscriptionId}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
	}


	/**
	 * AddSubscriptionItems
	 *
	 * 
	 * 
     * @param postData  request
     *  
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="postData")
	 public static void AddSubscriptionItems(List<SubscriptionItemRequest> postData) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/additems";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "POST";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
	}


	/**
	 * UpdateSubscriptionItems
	 *
	 * 
	 * 
     * @param postData  request
     *  
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="postData")
	 public static void UpdateSubscriptionItems(List<SubscriptionItemRequest> postData) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/updateitems";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
	}


	/**
	 * GetSubscriptionItems
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  
	 * @return List<SubscriptionItemResponse> {@link SubscriptionItemResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId")
	 public static List<SubscriptionItemResponse> GetSubscriptionItems(String subscriptionId) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/items/{subscriptionId}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<SubscriptionItemResponse>> typeRef = new TypeReference<ArrayList<SubscriptionItemResponse>>() {};
        try {
            List<SubscriptionItemResponse> responseObject = (List<SubscriptionItemResponse>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * ResetSubscriptionMeteredItems
	 *
	 * 
	 * 
     * @param subscriptionId  subscription Id
     *  
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="subscriptionId")
	 public static void ResetSubscriptionMeteredItems(String subscriptionId) throws APIException {

		//parse inputs
		String  resourcePath = "/subscriptions/resetmetered/{subscriptionId}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "DELETE";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( subscriptionId != null) {
			resourcePath = resourcePath.replace("{subscriptionId}", APIInvoker.toPathValue(subscriptionId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
	}



    public static APIInvoker getApiInvoker() {
        if(apiInvoker == null){
            apiInvoker = APIInvoker.getApiInvoker();
        }
        return apiInvoker;
    }

    public static void setApiInvoker(APIInvoker invoker) {
        apiInvoker = invoker;
    }

}
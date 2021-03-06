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
public class CustomersAPI extends Object {

    private static APIInvoker apiInvoker = null;


	/**
	 * GetAllCustomers
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param pageNumber  page number
     *  @param pageSize  page size
     *  
	 * @return List<CustomerResponse> {@link CustomerResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, pageNumber, pageSize")
	 public static List<CustomerResponse> GetAllCustomers(String siteSubdomain, String pageNumber, String pageSize) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{siteSubdomain}.{format}?pageNumber={pageNumber}&pageSize={pageSize}";
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
        TypeReference<ArrayList<CustomerResponse>> typeRef = new TypeReference<ArrayList<CustomerResponse>>() {};
        try {
            List<CustomerResponse> responseObject = (List<CustomerResponse>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetCustomer
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  
	 * @return CustomerResponse {@link CustomerResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId")
	 public static CustomerResponse GetCustomer(String customerId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/byid/{customerId}.{format}";
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
		//create output objects if the response has more than one object
		CustomerResponse responseObject = (CustomerResponse) getApiInvoker().deserialize(response, CustomerResponse.class);
		return responseObject;
	}


	/**
	 * GetCustomerByReferenceId
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param referenceId  reference Id
     *  
	 * @return CustomerResponse {@link CustomerResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, referenceId")
	 public static CustomerResponse GetCustomerByReferenceId(String siteSubdomain, String referenceId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{siteSubdomain}/reference-id/{referenceId}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

		if( referenceId != null) {
			resourcePath = resourcePath.replace("{referenceId}", APIInvoker.toPathValue(referenceId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		CustomerResponse responseObject = (CustomerResponse) getApiInvoker().deserialize(response, CustomerResponse.class);
		return responseObject;
	}


	/**
	 * AddCustomer
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param postData  new Customer
     *  
	 * @return CustomerResponse {@link CustomerResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, postData")
	 public static CustomerResponse AddCustomer(String siteSubdomain, CustomerRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{siteSubdomain}.{format}";
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
		CustomerResponse responseObject = (CustomerResponse) getApiInvoker().deserialize(response, CustomerResponse.class);
		return responseObject;
	}


	/**
	 * UpdateCustomer
	 *
	 * 
	 * 
     * @param postData  updated Customer
     *  @param customerId  customer Id
     *  
	 * @return CustomerResponse {@link CustomerResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="postData, customerId")
	 public static CustomerResponse UpdateCustomer(CustomerRequest postData, String customerId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{customerId}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( customerId != null) {
			resourcePath = resourcePath.replace("{customerId}", APIInvoker.toPathValue(customerId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		CustomerResponse responseObject = (CustomerResponse) getApiInvoker().deserialize(response, CustomerResponse.class);
		return responseObject;
	}


	/**
	 * DeleteCustomer
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId")
	 public static void DeleteCustomer(String customerId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{customerId}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "DELETE";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( customerId != null) {
			resourcePath = resourcePath.replace("{customerId}", APIInvoker.toPathValue(customerId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
	}


	/**
	 * GetCreditCard
	 *
	 * 
	 * 
     * @param creditCardId  credit Card Id
     *  
	 * @return CreditCardResponse {@link CreditCardResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="creditCardId")
	 public static CreditCardResponse GetCreditCard(String creditCardId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/credit-card/{creditCardId}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( creditCardId != null) {
			resourcePath = resourcePath.replace("{creditCardId}", APIInvoker.toPathValue(creditCardId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		CreditCardResponse responseObject = (CreditCardResponse) getApiInvoker().deserialize(response, CreditCardResponse.class);
		return responseObject;
	}


	/**
	 * GetCreditCards
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  
	 * @return List<CreditCardResponse> {@link CreditCardResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId")
	 public static List<CreditCardResponse> GetCreditCards(String customerId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{customerId}/credit-cards.{format}";
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
        TypeReference<ArrayList<CreditCardResponse>> typeRef = new TypeReference<ArrayList<CreditCardResponse>>() {};
        try {
            List<CreditCardResponse> responseObject = (List<CreditCardResponse>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetCreditCardsByReferenceId
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param customerReferenceId  customer Reference Id
     *  
	 * @return List<CreditCardResponse> {@link CreditCardResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, customerReferenceId")
	 public static List<CreditCardResponse> GetCreditCardsByReferenceId(String siteSubdomain, String customerReferenceId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{siteSubdomain}/reference-id/{customerReferenceId}/credit-cards.{format}";
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
        TypeReference<ArrayList<CreditCardResponse>> typeRef = new TypeReference<ArrayList<CreditCardResponse>>() {};
        try {
            List<CreditCardResponse> responseObject = (List<CreditCardResponse>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetCustomersFirstCreditCard
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  
	 * @return CreditCardResponse {@link CreditCardResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId")
	 public static CreditCardResponse GetCustomersFirstCreditCard(String customerId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{customerId}/credit-card.{format}";
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
		//create output objects if the response has more than one object
		CreditCardResponse responseObject = (CreditCardResponse) getApiInvoker().deserialize(response, CreditCardResponse.class);
		return responseObject;
	}


	/**
	 * GetFirstCreditCardForCustomerByReferenceId
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param customerReferenceId  customer Reference Id
     *  
	 * @return CreditCardResponse {@link CreditCardResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, customerReferenceId")
	 public static CreditCardResponse GetFirstCreditCardForCustomerByReferenceId(String siteSubdomain, String customerReferenceId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{siteSubdomain}/reference-id/{customerReferenceId}/credit-card.{format}";
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
		//create output objects if the response has more than one object
		CreditCardResponse responseObject = (CreditCardResponse) getApiInvoker().deserialize(response, CreditCardResponse.class);
		return responseObject;
	}


	/**
	 * AddCreditCard
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  @param postData  new Credit Card
     *  
	 * @return CreditCardResponse {@link CreditCardResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId, postData")
	 public static CreditCardResponse AddCreditCard(String customerId, CreditCardRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{customerId}/credit-card.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "POST";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( customerId != null) {
			resourcePath = resourcePath.replace("{customerId}", APIInvoker.toPathValue(customerId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		CreditCardResponse responseObject = (CreditCardResponse) getApiInvoker().deserialize(response, CreditCardResponse.class);
		return responseObject;
	}


	/**
	 * UpdateCreditCard
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  @param creditCardId  credit Card Id
     *  @param postData  updated Credit Card
     *  
	 * @return CreditCardResponse {@link CreditCardResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId, creditCardId, postData")
	 public static CreditCardResponse UpdateCreditCard(String customerId, String creditCardId, CreditCardRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{customerId}/credit-card/{creditCardId}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( customerId != null) {
			resourcePath = resourcePath.replace("{customerId}", APIInvoker.toPathValue(customerId));
		}

		if( creditCardId != null) {
			resourcePath = resourcePath.replace("{creditCardId}", APIInvoker.toPathValue(creditCardId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		CreditCardResponse responseObject = (CreditCardResponse) getApiInvoker().deserialize(response, CreditCardResponse.class);
		return responseObject;
	}


	/**
	 * UpdateCreditCardByCustomerReferenceId
	 *
	 * 
	 * 
     * @param siteSubdomanin  site Subdomanin
     *  @param customerReferenceId  customer Reference Id
     *  @param creditCardId  credit Card Id
     *  @param postData  updated Credit Card
     *  
	 * @return CreditCardResponse {@link CreditCardResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomanin, customerReferenceId, creditCardId, postData")
	 public static CreditCardResponse UpdateCreditCardByCustomerReferenceId(String siteSubdomanin, String customerReferenceId, String creditCardId, CreditCardRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{siteSubdomanin}/reference-id/{customerReferenceId}/credit-card/{creditCardId}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomanin != null) {
			resourcePath = resourcePath.replace("{siteSubdomanin}", APIInvoker.toPathValue(siteSubdomanin));
		}

		if( customerReferenceId != null) {
			resourcePath = resourcePath.replace("{customerReferenceId}", APIInvoker.toPathValue(customerReferenceId));
		}

		if( creditCardId != null) {
			resourcePath = resourcePath.replace("{creditCardId}", APIInvoker.toPathValue(creditCardId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		CreditCardResponse responseObject = (CreditCardResponse) getApiInvoker().deserialize(response, CreditCardResponse.class);
		return responseObject;
	}


	/**
	 * DeleteCreditCard
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  @param creditCardId  credit Card Id
     *  
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId, creditCardId")
	 public static void DeleteCreditCard(String customerId, String creditCardId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{customerId}/credit-card/{creditCardId}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "DELETE";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( customerId != null) {
			resourcePath = resourcePath.replace("{customerId}", APIInvoker.toPathValue(customerId));
		}

		if( creditCardId != null) {
			resourcePath = resourcePath.replace("{creditCardId}", APIInvoker.toPathValue(creditCardId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
	}


	/**
	 * GetBillingAddresses
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  
	 * @return List<AddressResponse> {@link AddressResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId")
	 public static List<AddressResponse> GetBillingAddresses(String customerId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{customerId}/billing-addresses.{format}";
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
        TypeReference<ArrayList<AddressResponse>> typeRef = new TypeReference<ArrayList<AddressResponse>>() {};
        try {
            List<AddressResponse> responseObject = (List<AddressResponse>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetBillingAddresses
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  
	 * @return AddressResponse {@link AddressResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId")
	 public static AddressResponse GetBillingAddress(String customerId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{customerId}/first-billing-address.{format}";
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
		//create output objects if the response has more than one object
		AddressResponse responseObject = (AddressResponse) getApiInvoker().deserialize(response, AddressResponse.class);
		return responseObject;
	}


	/**
	 * GetFirstBillingAddressForCustomerByReferenceId
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param customerReferenceId  customer Reference Id
     *  
	 * @return AddressResponse {@link AddressResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, customerReferenceId")
	 public static AddressResponse GetFirstBillingAddressForCustomerByReferenceId(String siteSubdomain, String customerReferenceId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{siteSubdomain}/reference-id/{customerReferenceId}/first-billing-address.{format}";
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
		//create output objects if the response has more than one object
		AddressResponse responseObject = (AddressResponse) getApiInvoker().deserialize(response, AddressResponse.class);
		return responseObject;
	}


	/**
	 * AddBillingAddress
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  @param postData  new Billing Address
     *  
	 * @return AddressResponse {@link AddressResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId, postData")
	 public static AddressResponse AddBillingAddress(String customerId, AddressRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{customerId}/billing-address.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "POST";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( customerId != null) {
			resourcePath = resourcePath.replace("{customerId}", APIInvoker.toPathValue(customerId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		AddressResponse responseObject = (AddressResponse) getApiInvoker().deserialize(response, AddressResponse.class);
		return responseObject;
	}


	/**
	 * UpdateBillingAddress
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  @param billingAddressId  billing Address Id
     *  @param postData  updated Billing Address
     *  
	 * @return AddressResponse {@link AddressResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId, billingAddressId, postData")
	 public static AddressResponse UpdateBillingAddress(String customerId, String billingAddressId, AddressRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{customerId}/billing-address/{billingAddressId}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( customerId != null) {
			resourcePath = resourcePath.replace("{customerId}", APIInvoker.toPathValue(customerId));
		}

		if( billingAddressId != null) {
			resourcePath = resourcePath.replace("{billingAddressId}", APIInvoker.toPathValue(billingAddressId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		AddressResponse responseObject = (AddressResponse) getApiInvoker().deserialize(response, AddressResponse.class);
		return responseObject;
	}


	/**
	 * UpdateBillingAddressByCustomerReferenceId
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param customerReferenceId  customer Reference Id
     *  @param billingAddressId  billing Address Id
     *  @param postData  updated Billing Address
     *  
	 * @return AddressResponse {@link AddressResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, customerReferenceId, billingAddressId, postData")
	 public static AddressResponse UpdateBillingAddressByCustomerReferenceId(String siteSubdomain, String customerReferenceId, String billingAddressId, AddressRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{siteSubdomain}/reference-id/{customerReferenceId}/billing-address/{billingAddressId}.{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

		if( customerReferenceId != null) {
			resourcePath = resourcePath.replace("{customerReferenceId}", APIInvoker.toPathValue(customerReferenceId));
		}

		if( billingAddressId != null) {
			resourcePath = resourcePath.replace("{billingAddressId}", APIInvoker.toPathValue(billingAddressId));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		AddressResponse responseObject = (AddressResponse) getApiInvoker().deserialize(response, AddressResponse.class);
		return responseObject;
	}


	/**
	 * DeleteBillingAddress
	 *
	 * 
	 * 
     * @param customerId  customer Id
     *  @param billingAddressId  billing Address Id
     *  
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="customerId, billingAddressId")
	 public static void DeleteBillingAddress(String customerId, String billingAddressId) throws APIException {

		//parse inputs
		String  resourcePath = "/customers/{customerId}/billing-address/{billingAddressId}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "DELETE";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( customerId != null) {
			resourcePath = resourcePath.replace("{customerId}", APIInvoker.toPathValue(customerId));
		}

		if( billingAddressId != null) {
			resourcePath = resourcePath.replace("{billingAddressId}", APIInvoker.toPathValue(billingAddressId));
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
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
public class ReportsAPI extends Object {

    private static APIInvoker apiInvoker = null;


	/**
	 * GetProductsSignupsEvolution
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param startDate  start Date
     *  @param endDate  end Date
     *  
	 * @return List<ProductsSignups> {@link ProductsSignups} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, startDate, endDate")
	 public static List<ProductsSignups> GetProductsSignupsEvolution(String siteSubdomain, String startDate, String endDate) throws APIException {

		//parse inputs
		String  resourcePath = "/reports/ProductsSignupsEvolution/{siteSubdomain}/{startDate}/{format}?endDate={endDate}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

		if( startDate != null) {
			resourcePath = resourcePath.replace("{startDate}", APIInvoker.toPathValue(startDate));
		}

		if( endDate != null) {
			resourcePath = resourcePath.replace("{endDate}", APIInvoker.toPathValue(endDate));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<ProductsSignups>> typeRef = new TypeReference<ArrayList<ProductsSignups>>() {};
        try {
            List<ProductsSignups> responseObject = (List<ProductsSignups>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetProductsRevenuesEvolution
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param startDate  start Date
     *  @param endDate  end Date
     *  
	 * @return List<ProductsRevenues> {@link ProductsRevenues} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, startDate, endDate")
	 public static List<ProductsRevenues> GetProductsRevenuesEvolution(String siteSubdomain, String startDate, String endDate) throws APIException {

		//parse inputs
		String  resourcePath = "/reports/ProductsRevenuesEvolution/{siteSubdomain}/{startDate}/{format}?endDate={endDate}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

		if( startDate != null) {
			resourcePath = resourcePath.replace("{startDate}", APIInvoker.toPathValue(startDate));
		}

		if( endDate != null) {
			resourcePath = resourcePath.replace("{endDate}", APIInvoker.toPathValue(endDate));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<ProductsRevenues>> typeRef = new TypeReference<ArrayList<ProductsRevenues>>() {};
        try {
            List<ProductsRevenues> responseObject = (List<ProductsRevenues>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetTotalRevenueAmount
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  
	 * @return List<RevenueAmount> {@link RevenueAmount} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain")
	 public static List<RevenueAmount> GetTotalRevenueAmount(String siteSubdomain) throws APIException {

		//parse inputs
		String  resourcePath = "/reports/TotalRevenueAmount/{siteSubdomain}/{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<RevenueAmount>> typeRef = new TypeReference<ArrayList<RevenueAmount>>() {};
        try {
            List<RevenueAmount> responseObject = (List<RevenueAmount>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetActiveSubscriptionsCount
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  
	 * @return ActiveSubscriptionsCountResponse {@link ActiveSubscriptionsCountResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain")
	 public static ActiveSubscriptionsCountResponse GetActiveSubscriptionsCount(String siteSubdomain) throws APIException {

		//parse inputs
		String  resourcePath = "/reports/ActiveSubscriptionsCount/{siteSubdomain}/{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		ActiveSubscriptionsCountResponse responseObject = (ActiveSubscriptionsCountResponse) getApiInvoker().deserialize(response, ActiveSubscriptionsCountResponse.class);
		return responseObject;
	}


	/**
	 * GetTotalSubscribersCount
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  
	 * @return TotalSubscribersCountResponse {@link TotalSubscribersCountResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain")
	 public static TotalSubscribersCountResponse GetTotalSubscribersCount(String siteSubdomain) throws APIException {

		//parse inputs
		String  resourcePath = "/reports/TotalSubscribersCount/{siteSubdomain}/{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		TotalSubscribersCountResponse responseObject = (TotalSubscribersCountResponse) getApiInvoker().deserialize(response, TotalSubscribersCountResponse.class);
		return responseObject;
	}


	/**
	 * GetTodayRevenueAmount
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  
	 * @return List<RevenueAmount> {@link RevenueAmount} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain")
	 public static List<RevenueAmount> GetTodayRevenueAmount(String siteSubdomain) throws APIException {

		//parse inputs
		String  resourcePath = "/reports/TodayRevenueAmount/{siteSubdomain}/{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<RevenueAmount>> typeRef = new TypeReference<ArrayList<RevenueAmount>>() {};
        try {
            List<RevenueAmount> responseObject = (List<RevenueAmount>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetTodayNewSubscribersCount
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  
	 * @return TodayNewSubscribersCountResponse {@link TodayNewSubscribersCountResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain")
	 public static TodayNewSubscribersCountResponse GetTodayNewSubscribersCount(String siteSubdomain) throws APIException {

		//parse inputs
		String  resourcePath = "/reports/TodayNewSubscribersCount/{siteSubdomain}/{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		TodayNewSubscribersCountResponse responseObject = (TodayNewSubscribersCountResponse) getApiInvoker().deserialize(response, TodayNewSubscribersCountResponse.class);
		return responseObject;
	}


	/**
	 * GetSignupsEvolution
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param startDate  start Date
     *  @param endDate  end Date
     *  
	 * @return List<ReportIntValueItem> {@link ReportIntValueItem} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, startDate, endDate")
	 public static List<ReportIntValueItem> GetSignupsEvolution(String siteSubdomain, String startDate, String endDate) throws APIException {

		//parse inputs
		String  resourcePath = "/reports/SignupsEvolution/{siteSubdomain}/{startDate}/{format}?endDate={endDate}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

		if( startDate != null) {
			resourcePath = resourcePath.replace("{startDate}", APIInvoker.toPathValue(startDate));
		}

		if( endDate != null) {
			resourcePath = resourcePath.replace("{endDate}", APIInvoker.toPathValue(endDate));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<ReportIntValueItem>> typeRef = new TypeReference<ArrayList<ReportIntValueItem>>() {};
        try {
            List<ReportIntValueItem> responseObject = (List<ReportIntValueItem>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetRevenuesEvolution
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param startDate  start Date
     *  @param endDate  end Date
     *  
	 * @return List<ReportDecimalValueItem> {@link ReportDecimalValueItem} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, startDate, endDate")
	 public static List<ReportDecimalValueItem> GetRevenuesEvolution(String siteSubdomain, String startDate, String endDate) throws APIException {

		//parse inputs
		String  resourcePath = "/reports/RevenuesEvolution/{siteSubdomain}/{startDate}/{format}?endDate={endDate}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

		if( startDate != null) {
			resourcePath = resourcePath.replace("{startDate}", APIInvoker.toPathValue(startDate));
		}

		if( endDate != null) {
			resourcePath = resourcePath.replace("{endDate}", APIInvoker.toPathValue(endDate));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<ReportDecimalValueItem>> typeRef = new TypeReference<ArrayList<ReportDecimalValueItem>>() {};
        try {
            List<ReportDecimalValueItem> responseObject = (List<ReportDecimalValueItem>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetCustomersEvolution
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param startDate  start Date
     *  @param endDate  end Date
     *  
	 * @return List<ReportIntValueItem> {@link ReportIntValueItem} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, startDate, endDate")
	 public static List<ReportIntValueItem> GetCustomersEvolution(String siteSubdomain, String startDate, String endDate) throws APIException {

		//parse inputs
		String  resourcePath = "/reports/CustomersEvolution/{siteSubdomain}/{startDate}/{format}?endDate={endDate}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

		if( startDate != null) {
			resourcePath = resourcePath.replace("{startDate}", APIInvoker.toPathValue(startDate));
		}

		if( endDate != null) {
			resourcePath = resourcePath.replace("{endDate}", APIInvoker.toPathValue(endDate));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<ReportIntValueItem>> typeRef = new TypeReference<ArrayList<ReportIntValueItem>>() {};
        try {
            List<ReportIntValueItem> responseObject = (List<ReportIntValueItem>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetSubscriptionsEvolution
	 *
	 * 
	 * 
     * @param siteSubdomain  site Subdomain
     *  @param startDate  start Date
     *  @param endDate  end Date
     *  
	 * @return List<ReportIntValueItem> {@link ReportIntValueItem} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="siteSubdomain, startDate, endDate")
	 public static List<ReportIntValueItem> GetSubscriptionsEvolution(String siteSubdomain, String startDate, String endDate) throws APIException {

		//parse inputs
		String  resourcePath = "/reports/SubscriptionsEvolution/{siteSubdomain}/{startDate}/{format}?endDate={endDate}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if( siteSubdomain != null) {
			resourcePath = resourcePath.replace("{siteSubdomain}", APIInvoker.toPathValue(siteSubdomain));
		}

		if( startDate != null) {
			resourcePath = resourcePath.replace("{startDate}", APIInvoker.toPathValue(startDate));
		}

		if( endDate != null) {
			resourcePath = resourcePath.replace("{endDate}", APIInvoker.toPathValue(endDate));
		}

        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<ReportIntValueItem>> typeRef = new TypeReference<ArrayList<ReportIntValueItem>>() {};
        try {
            List<ReportIntValueItem> responseObject = (List<ReportIntValueItem>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}


	/**
	 * GetSitesSummary
	 *
	 * 
	 * 
     * 
	 * @return List<SiteSummary> {@link SiteSummary} 
	 * @throws APIException 
	 */
	 public static List<SiteSummary> GetSitesSummary() throws APIException {

		//parse inputs
		String  resourcePath = "/reports/SitesSummary/{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "GET";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, null, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
        TypeReference<ArrayList<SiteSummary>> typeRef = new TypeReference<ArrayList<SiteSummary>>() {};
        try {
            List<SiteSummary> responseObject = (List<SiteSummary>) getApiInvoker().mapper.readValue(response, typeRef);
            return responseObject;
        } catch (IOException ioe) {
        	String[] args = new String[]{response, typeRef.toString()};
            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe);
        }	}



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
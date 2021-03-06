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

 package com.dynabic.sdk.java.platform.api;


import com.dynabic.sdk.java.platform.model.*;

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
public class CompanyinfoAPI extends Object {

    private static APIInvoker apiInvoker = null;


	/**
	 * GetCompanyInfo
	 *
	 * 
	 * 
     * 
	 * @return CompanyInfoResponse {@link CompanyInfoResponse} 
	 * @throws APIException 
	 */
	 public static CompanyInfoResponse GetCompanyInfo() throws APIException {

		//parse inputs
		String  resourcePath = "/companyinfo/{format}";
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
		//create output objects if the response has more than one object
		CompanyInfoResponse responseObject = (CompanyInfoResponse) getApiInvoker().deserialize(response, CompanyInfoResponse.class);
		return responseObject;
	}


	/**
	 * UpdateCompanyInfo
	 *
	 * 
	 * 
     * @param postData  updated Company Info
     *  
	 * @return CompanyInfoResponse {@link CompanyInfoResponse} 
	 * @throws APIException 
	 */
	 @MethodArgumentNames(value="postData")
	 public static CompanyInfoResponse UpdateCompanyInfo(CompanyInfoRequest postData) throws APIException {

		//parse inputs
		String  resourcePath = "/companyinfo/{format}";
		resourcePath = resourcePath.replace("{format}","json").replaceAll("\\*", "");
		String method = "PUT";
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
        resourcePath = resourcePath.replaceAll("\\{\\w*\\}", "");

		//make the API Call
		String response = getApiInvoker().invokeAPI(resourcePath, method, queryParams, postData, headerParams);
        if(response == null || response.length() == 0){
            return null;
        }
		//create output objects if the response has more than one object
		CompanyInfoResponse responseObject = (CompanyInfoResponse) getApiInvoker().deserialize(response, CompanyInfoResponse.class);
		return responseObject;
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
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
 
package com.dynabic.sdk.java.platform.model;

import com.wordnik.swagger.runtime.annotations.*;
import java.util.List;


/**
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program. Do not edit the class manually.
 *
 * @author ramesh
 *
 */
public class SiteRequest extends Object {


    /**
     * 
     */
	 private String name ;

    /**
     * 
     */
	 private String subdomain ;

    /**
     * 
     */
	 private Boolean is_test_mode ;


	/**
	 * 
	 * 
	 * 
	 */
	 public String getName() {
	 	return name;
	 }  
	 
	 public void setName(String  name) {
	 	this.name = name;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public String getSubdomain() {
	 	return subdomain;
	 }  
	 
	 public void setSubdomain(String  subdomain) {
	 	this.subdomain = subdomain;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public Boolean getIs_test_mode() {
	 	return is_test_mode;
	 }  
	 
	 public void setIs_test_mode(Boolean  is_test_mode) {
	 	this.is_test_mode = is_test_mode;
	 }


}
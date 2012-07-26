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
 
package com.dynabic.sdk.java.model;

import com.wordnik.swagger.runtime.annotations.*;
import java.util.List;

import java.util.Date;


/**
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program. Do not edit the class manually.
 *
 * @author ramesh
 *
 */
public class SubscriptionItemHistoryResponse extends Object {


    /**
     * 
     */
	 private Date update_on ;

    /**
     * 
     */
	 private Double new_value ;

    /**
     * 
     */
	 private String description ;

    /**
     * 
     */
	 private Double old_value ;


	/**
	 * 
	 * 
	 * 
	 */
	 public Date getUpdate_on() {
	 	return update_on;
	 }  
	 
	 public void setUpdate_on(Date  update_on) {
	 	this.update_on = update_on;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public Double getNew_value() {
	 	return new_value;
	 }  
	 
	 public void setNew_value(Double  new_value) {
	 	this.new_value = new_value;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public String getDescription() {
	 	return description;
	 }  
	 
	 public void setDescription(String  description) {
	 	this.description = description;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public Double getOld_value() {
	 	return old_value;
	 }  
	 
	 public void setOld_value(Double  old_value) {
	 	this.old_value = old_value;
	 }


}
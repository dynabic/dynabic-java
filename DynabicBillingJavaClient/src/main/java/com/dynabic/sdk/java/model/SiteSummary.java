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


import java.util.List;

import java.util.ArrayList;


/**
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program. Do not edit the class manually.
 *
 * @author ramesh
 *
 */
public class SiteSummary extends Object {



    /**
     * 
     */
	 private List<RevenueAmount> today_revenues  =  new ArrayList<RevenueAmount>();


    /**
     * 
     */
	 private Integer total_subscribers ;


    /**
     * 
     */
	 private Integer today_new_subscriptions ;


    /**
     * 
     */
	 private List<RevenueAmount> total_revenues  =  new ArrayList<RevenueAmount>();


    /**
     * 
     */
	 private Integer site_id ;


    /**
     * 
     */
	 private String site_name ;



	/**
	 * 
	 * 
	 * 
	 */
	 public List<RevenueAmount> getToday_revenues() {
	 	return today_revenues;
	 }  
	 
	 public void setToday_revenues(List<RevenueAmount>  today_revenues) {
	 	this.today_revenues = today_revenues;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getTotal_subscribers() {
	 	return total_subscribers;
	 }  
	 
	 public void setTotal_subscribers(Integer  total_subscribers) {
	 	this.total_subscribers = total_subscribers;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getToday_new_subscriptions() {
	 	return today_new_subscriptions;
	 }  
	 
	 public void setToday_new_subscriptions(Integer  today_new_subscriptions) {
	 	this.today_new_subscriptions = today_new_subscriptions;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public List<RevenueAmount> getTotal_revenues() {
	 	return total_revenues;
	 }  
	 
	 public void setTotal_revenues(List<RevenueAmount>  total_revenues) {
	 	this.total_revenues = total_revenues;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getSite_id() {
	 	return site_id;
	 }  
	 
	 public void setSite_id(Integer  site_id) {
	 	this.site_id = site_id;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getSite_name() {
	 	return site_name;
	 }  
	 
	 public void setSite_name(String  site_name) {
	 	this.site_name = site_name;
	 }


}
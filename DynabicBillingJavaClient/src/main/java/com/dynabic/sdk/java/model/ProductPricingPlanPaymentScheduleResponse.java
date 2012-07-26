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


/**
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program. Do not edit the class manually.
 *
 * @author ramesh
 *
 */
public class ProductPricingPlanPaymentScheduleResponse extends Object {



    /**
     * 
     */
	 private Integer id ;


    /**
     * 
     */
	 private Integer frequency_recurrence_factor ;


    /**
     * 
     */
	 private Integer frequency_interval ;


    /**
     * 
     */
	 private Double subscription_period_change ;


    /**
     * 
     */
	 private String name ;


    /**
     * 
     */
	 private String frequency_relative_interval ;


    /**
     * 
     */
	 private String frequency_type ;


    /**
     * 
     */
	 private Integer pricing_plan_id ;


    /**
     * 
     */
	 private Integer end_date_offset_days ;


    /**
     * 
     */
	 private Integer start_date_offset_days ;



	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getId() {
	 	return id;
	 }  
	 
	 public void setId(Integer  id) {
	 	this.id = id;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getFrequency_recurrence_factor() {
	 	return frequency_recurrence_factor;
	 }  
	 
	 public void setFrequency_recurrence_factor(Integer  frequency_recurrence_factor) {
	 	this.frequency_recurrence_factor = frequency_recurrence_factor;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getFrequency_interval() {
	 	return frequency_interval;
	 }  
	 
	 public void setFrequency_interval(Integer  frequency_interval) {
	 	this.frequency_interval = frequency_interval;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Double getSubscription_period_change() {
	 	return subscription_period_change;
	 }  
	 
	 public void setSubscription_period_change(Double  subscription_period_change) {
	 	this.subscription_period_change = subscription_period_change;
	 }


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
	 public String getFrequency_relative_interval() {
	 	return frequency_relative_interval;
	 }  
	 
	 public void setFrequency_relative_interval(String  frequency_relative_interval) {
	 	this.frequency_relative_interval = frequency_relative_interval;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getFrequency_type() {
	 	return frequency_type;
	 }  
	 
	 public void setFrequency_type(String  frequency_type) {
	 	this.frequency_type = frequency_type;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getPricing_plan_id() {
	 	return pricing_plan_id;
	 }  
	 
	 public void setPricing_plan_id(Integer  pricing_plan_id) {
	 	this.pricing_plan_id = pricing_plan_id;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getEnd_date_offset_days() {
	 	return end_date_offset_days;
	 }  
	 
	 public void setEnd_date_offset_days(Integer  end_date_offset_days) {
	 	this.end_date_offset_days = end_date_offset_days;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getStart_date_offset_days() {
	 	return start_date_offset_days;
	 }  
	 
	 public void setStart_date_offset_days(Integer  start_date_offset_days) {
	 	this.start_date_offset_days = start_date_offset_days;
	 }


}
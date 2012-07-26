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
public class PricingPlanResponse extends Object {



    /**
     * 
     */
	 private Integer id ;


    /**
     * 
     */
	 private Integer product_id ;


    /**
     * 
     */
	 private Integer trial_period_duration_days ;


    /**
     * 
     */
	 private Double trial_period_charge ;


    /**
     * 
     */
	 private String name ;


    /**
     * 
     */
	 private Double upfront_charge ;


    /**
     * 
     */
	 private List<ProductItemResponse> product_items  =  new ArrayList<ProductItemResponse>();


    /**
     * 
     */
	 private List<ProductPricingPlanPaymentScheduleResponse> pricing_plan_payment_schedules  =  new ArrayList<ProductPricingPlanPaymentScheduleResponse>();


    /**
     * 
     */
	 private String currency_code ;



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
	 public Integer getProduct_id() {
	 	return product_id;
	 }  
	 
	 public void setProduct_id(Integer  product_id) {
	 	this.product_id = product_id;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getTrial_period_duration_days() {
	 	return trial_period_duration_days;
	 }  
	 
	 public void setTrial_period_duration_days(Integer  trial_period_duration_days) {
	 	this.trial_period_duration_days = trial_period_duration_days;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Double getTrial_period_charge() {
	 	return trial_period_charge;
	 }  
	 
	 public void setTrial_period_charge(Double  trial_period_charge) {
	 	this.trial_period_charge = trial_period_charge;
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
	 public Double getUpfront_charge() {
	 	return upfront_charge;
	 }  
	 
	 public void setUpfront_charge(Double  upfront_charge) {
	 	this.upfront_charge = upfront_charge;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public List<ProductItemResponse> getProduct_items() {
	 	return product_items;
	 }  
	 
	 public void setProduct_items(List<ProductItemResponse>  product_items) {
	 	this.product_items = product_items;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public List<ProductPricingPlanPaymentScheduleResponse> getPricing_plan_payment_schedules() {
	 	return pricing_plan_payment_schedules;
	 }  
	 
	 public void setPricing_plan_payment_schedules(List<ProductPricingPlanPaymentScheduleResponse>  pricing_plan_payment_schedules) {
	 	this.pricing_plan_payment_schedules = pricing_plan_payment_schedules;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getCurrency_code() {
	 	return currency_code;
	 }  
	 
	 public void setCurrency_code(String  currency_code) {
	 	this.currency_code = currency_code;
	 }


}
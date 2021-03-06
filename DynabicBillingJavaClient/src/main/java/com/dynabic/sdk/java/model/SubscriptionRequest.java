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
public class SubscriptionRequest extends Object {



    /**
     * 
     */
	 private Integer product_id ;


    /**
     * 
     */
	 private Boolean is_cancelled_at_end_of_period ;


    /**
     * 
     */
	 private ProductRequest next_product ;


    /**
     * 
     */
	 private PricingPlanRequest next_product_pricing_plan ;


    /**
     * 
     */
	 private CustomerRequest customer ;


    /**
     * 
     */
	 private java.util.Date next_assesment ;


    /**
     * 
     */
	 private String cancellation_details ;


    /**
     * 
     */
	 private Currency currency ;


    /**
     * 
     */
	 private Integer billing_address_id ;


    /**
     * 
     */
	 private ProductRequest product ;


    /**
     * 
     */
	 private PricingPlanRequest product_pricing_plan ;


    /**
     * 
     */
	 private java.util.Date end_date ;


    /**
     * 
     */
	 private Integer credit_card_id ;


    /**
     * 
     */
	 private CreditCardRequest credit_card ;


    /**
     * 
     */
	 private Double current_ballance ;


    /**
     * 
     */
	 private Integer pricing_plan_id ;


    /**
     * 
     */
	 private java.util.Date start_date ;


    /**
     * 
     */
	 private Integer customer_id ;


    /**
     * 
     */
	 private AddressRequest billing_address ;


    /**
     * 
     */
	 private List<SubscriptionItemRequest> subscription_items  =  new ArrayList<SubscriptionItemRequest>();



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
	 public Boolean getIs_cancelled_at_end_of_period() {
	 	return is_cancelled_at_end_of_period;
	 }  
	 
	 public void setIs_cancelled_at_end_of_period(Boolean  is_cancelled_at_end_of_period) {
	 	this.is_cancelled_at_end_of_period = is_cancelled_at_end_of_period;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public ProductRequest getNext_product() {
	 	return next_product;
	 }  
	 
	 public void setNext_product(ProductRequest  next_product) {
	 	this.next_product = next_product;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public PricingPlanRequest getNext_product_pricing_plan() {
	 	return next_product_pricing_plan;
	 }  
	 
	 public void setNext_product_pricing_plan(PricingPlanRequest  next_product_pricing_plan) {
	 	this.next_product_pricing_plan = next_product_pricing_plan;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public CustomerRequest getCustomer() {
	 	return customer;
	 }  
	 
	 public void setCustomer(CustomerRequest  customer) {
	 	this.customer = customer;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public java.util.Date getNext_assesment() {
	 	return next_assesment;
	 }  
	 
	 public void setNext_assesment(java.util.Date  next_assesment) {
	 	this.next_assesment = next_assesment;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getCancellation_details() {
	 	return cancellation_details;
	 }  
	 
	 public void setCancellation_details(String  cancellation_details) {
	 	this.cancellation_details = cancellation_details;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Currency getCurrency() {
	 	return currency;
	 }  
	 
	 public void setCurrency(Currency  currency) {
	 	this.currency = currency;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getBilling_address_id() {
	 	return billing_address_id;
	 }  
	 
	 public void setBilling_address_id(Integer  billing_address_id) {
	 	this.billing_address_id = billing_address_id;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public ProductRequest getProduct() {
	 	return product;
	 }  
	 
	 public void setProduct(ProductRequest  product) {
	 	this.product = product;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public PricingPlanRequest getProduct_pricing_plan() {
	 	return product_pricing_plan;
	 }  
	 
	 public void setProduct_pricing_plan(PricingPlanRequest  product_pricing_plan) {
	 	this.product_pricing_plan = product_pricing_plan;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public java.util.Date getEnd_date() {
	 	return end_date;
	 }  
	 
	 public void setEnd_date(java.util.Date  end_date) {
	 	this.end_date = end_date;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getCredit_card_id() {
	 	return credit_card_id;
	 }  
	 
	 public void setCredit_card_id(Integer  credit_card_id) {
	 	this.credit_card_id = credit_card_id;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public CreditCardRequest getCredit_card() {
	 	return credit_card;
	 }  
	 
	 public void setCredit_card(CreditCardRequest  credit_card) {
	 	this.credit_card = credit_card;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Double getCurrent_ballance() {
	 	return current_ballance;
	 }  
	 
	 public void setCurrent_ballance(Double  current_ballance) {
	 	this.current_ballance = current_ballance;
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
	 public java.util.Date getStart_date() {
	 	return start_date;
	 }  
	 
	 public void setStart_date(java.util.Date  start_date) {
	 	this.start_date = start_date;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getCustomer_id() {
	 	return customer_id;
	 }  
	 
	 public void setCustomer_id(Integer  customer_id) {
	 	this.customer_id = customer_id;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public AddressRequest getBilling_address() {
	 	return billing_address;
	 }  
	 
	 public void setBilling_address(AddressRequest  billing_address) {
	 	this.billing_address = billing_address;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public List<SubscriptionItemRequest> getSubscription_items() {
	 	return subscription_items;
	 }  
	 
	 public void setSubscription_items(List<SubscriptionItemRequest>  subscription_items) {
	 	this.subscription_items = subscription_items;
	 }


}
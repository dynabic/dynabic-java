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
public class TransactionResponse extends Object {



    /**
     * 
     */
	 private String gateway_response_message ;


    /**
     * 
     */
	 private Integer subscription_id ;


    /**
     * 
     */
	 private String transaction_type ;


    /**
     * 
     */
	 private ServiceResult service_result ;


    /**
     * 
     */
	 private String gateway_raw_response ;


    /**
     * 
     */
	 private java.util.Date transaction_date ;


    /**
     * 
     */
	 private Integer settlement_attempts_count ;


    /**
     * 
     */
	 private String currency ;


    /**
     * 
     */
	 private String purchase_order_reference ;


    /**
     * 
     */
	 private Double amount ;


    /**
     * 
     */
	 private Integer id ;


    /**
     * 
     */
	 private java.util.Date last_settlement_attempt_date ;


    /**
     * 
     */
	 private String transaction_status ;


    /**
     * 
     */
	 private Double refunded ;


    /**
     * 
     */
	 private String details ;


    /**
     * 
     */
	 private Double subscription_balance ;


    /**
     * 
     */
	 private String gateway_raw_request ;


    /**
     * 
     */
	 private String gateway_transaction_id ;


    /**
     * 
     */
	 private String gateway_response_code ;


    /**
     * 
     */
	 private String gateway_response_description ;


    /**
     * 
     */
	 private String gateway_status ;


    /**
     * 
     */
	 private String gateway_ref_transaction_id ;


    /**
     * 
     */
	 private java.util.Date gateway_settle_date ;



	/**
	 * 
	 * 
	 * 
	 */
	 public String getGateway_response_message() {
	 	return gateway_response_message;
	 }  
	 
	 public void setGateway_response_message(String  gateway_response_message) {
	 	this.gateway_response_message = gateway_response_message;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getSubscription_id() {
	 	return subscription_id;
	 }  
	 
	 public void setSubscription_id(Integer  subscription_id) {
	 	this.subscription_id = subscription_id;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getTransaction_type() {
	 	return transaction_type;
	 }  
	 
	 public void setTransaction_type(String  transaction_type) {
	 	this.transaction_type = transaction_type;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public ServiceResult getService_result() {
	 	return service_result;
	 }  
	 
	 public void setService_result(ServiceResult  service_result) {
	 	this.service_result = service_result;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getGateway_raw_response() {
	 	return gateway_raw_response;
	 }  
	 
	 public void setGateway_raw_response(String  gateway_raw_response) {
	 	this.gateway_raw_response = gateway_raw_response;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public java.util.Date getTransaction_date() {
	 	return transaction_date;
	 }  
	 
	 public void setTransaction_date(java.util.Date  transaction_date) {
	 	this.transaction_date = transaction_date;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getSettlement_attempts_count() {
	 	return settlement_attempts_count;
	 }  
	 
	 public void setSettlement_attempts_count(Integer  settlement_attempts_count) {
	 	this.settlement_attempts_count = settlement_attempts_count;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getCurrency() {
	 	return currency;
	 }  
	 
	 public void setCurrency(String  currency) {
	 	this.currency = currency;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getPurchase_order_reference() {
	 	return purchase_order_reference;
	 }  
	 
	 public void setPurchase_order_reference(String  purchase_order_reference) {
	 	this.purchase_order_reference = purchase_order_reference;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Double getAmount() {
	 	return amount;
	 }  
	 
	 public void setAmount(Double  amount) {
	 	this.amount = amount;
	 }


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
	 public java.util.Date getLast_settlement_attempt_date() {
	 	return last_settlement_attempt_date;
	 }  
	 
	 public void setLast_settlement_attempt_date(java.util.Date  last_settlement_attempt_date) {
	 	this.last_settlement_attempt_date = last_settlement_attempt_date;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getTransaction_status() {
	 	return transaction_status;
	 }  
	 
	 public void setTransaction_status(String  transaction_status) {
	 	this.transaction_status = transaction_status;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Double getRefunded() {
	 	return refunded;
	 }  
	 
	 public void setRefunded(Double  refunded) {
	 	this.refunded = refunded;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getDetails() {
	 	return details;
	 }  
	 
	 public void setDetails(String  details) {
	 	this.details = details;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Double getSubscription_balance() {
	 	return subscription_balance;
	 }  
	 
	 public void setSubscription_balance(Double  subscription_balance) {
	 	this.subscription_balance = subscription_balance;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getGateway_raw_request() {
	 	return gateway_raw_request;
	 }  
	 
	 public void setGateway_raw_request(String  gateway_raw_request) {
	 	this.gateway_raw_request = gateway_raw_request;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getGateway_transaction_id() {
	 	return gateway_transaction_id;
	 }  
	 
	 public void setGateway_transaction_id(String  gateway_transaction_id) {
	 	this.gateway_transaction_id = gateway_transaction_id;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getGateway_response_code() {
	 	return gateway_response_code;
	 }  
	 
	 public void setGateway_response_code(String  gateway_response_code) {
	 	this.gateway_response_code = gateway_response_code;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getGateway_response_description() {
	 	return gateway_response_description;
	 }  
	 
	 public void setGateway_response_description(String  gateway_response_description) {
	 	this.gateway_response_description = gateway_response_description;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getGateway_status() {
	 	return gateway_status;
	 }  
	 
	 public void setGateway_status(String  gateway_status) {
	 	this.gateway_status = gateway_status;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getGateway_ref_transaction_id() {
	 	return gateway_ref_transaction_id;
	 }  
	 
	 public void setGateway_ref_transaction_id(String  gateway_ref_transaction_id) {
	 	this.gateway_ref_transaction_id = gateway_ref_transaction_id;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public java.util.Date getGateway_settle_date() {
	 	return gateway_settle_date;
	 }  
	 
	 public void setGateway_settle_date(java.util.Date  gateway_settle_date) {
	 	this.gateway_settle_date = gateway_settle_date;
	 }


}
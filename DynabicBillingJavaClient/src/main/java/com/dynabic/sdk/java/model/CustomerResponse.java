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
public class CustomerResponse extends Object {


    /**
     * 
     */
	 private AddressResponse shipping_address ;

    /**
     * 
     */
	 private Integer id ;

    /**
     * 
     */
	 private String first_name ;

    /**
     * 
     */
	 private String phone ;

    /**
     * 
     */
	 private String email ;

    /**
     * 
     */
	 private String company ;

    /**
     * 
     */
	 private Integer shipping_address_id ;

    /**
     * 
     */
	 private Boolean is_shipping_address_same_to_billing ;

    /**
     * 
     */
	 private String last_name ;

    /**
     * 
     */
	 private Date registration_date ;

    /**
     * 
     */
	 private Integer site_id ;

    /**
     * 
     */
	 private String reference ;


	/**
	 * 
	 * 
	 * 
	 */
	 public AddressResponse getShipping_address() {
	 	return shipping_address;
	 }  
	 
	 public void setShipping_address(AddressResponse  shipping_address) {
	 	this.shipping_address = shipping_address;
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
	 public String getFirst_name() {
	 	return first_name;
	 }  
	 
	 public void setFirst_name(String  first_name) {
	 	this.first_name = first_name;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public String getPhone() {
	 	return phone;
	 }  
	 
	 public void setPhone(String  phone) {
	 	this.phone = phone;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public String getEmail() {
	 	return email;
	 }  
	 
	 public void setEmail(String  email) {
	 	this.email = email;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public String getCompany() {
	 	return company;
	 }  
	 
	 public void setCompany(String  company) {
	 	this.company = company;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public Integer getShipping_address_id() {
	 	return shipping_address_id;
	 }  
	 
	 public void setShipping_address_id(Integer  shipping_address_id) {
	 	this.shipping_address_id = shipping_address_id;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public Boolean getIs_shipping_address_same_to_billing() {
	 	return is_shipping_address_same_to_billing;
	 }  
	 
	 public void setIs_shipping_address_same_to_billing(Boolean  is_shipping_address_same_to_billing) {
	 	this.is_shipping_address_same_to_billing = is_shipping_address_same_to_billing;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public String getLast_name() {
	 	return last_name;
	 }  
	 
	 public void setLast_name(String  last_name) {
	 	this.last_name = last_name;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public Date getRegistration_date() {
	 	return registration_date;
	 }  
	 
	 public void setRegistration_date(Date  registration_date) {
	 	this.registration_date = registration_date;
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
	 public String getReference() {
	 	return reference;
	 }  
	 
	 public void setReference(String  reference) {
	 	this.reference = reference;
	 }


}
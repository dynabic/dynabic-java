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
public class ProductItemResponse extends Object {



    /**
     * 
     */
	 private Integer id ;


    /**
     * 
     */
	 private Integer product_item_id ;


    /**
     * 
     */
	 private Boolean is_visible_on_hosted_page ;


    /**
     * 
     */
	 private String description ;


    /**
     * 
     */
	 private String charge_model ;


    /**
     * 
     */
	 private String name ;


    /**
     * 
     */
	 private List<ProductItemResponse> product_item_children  =  new ArrayList<ProductItemResponse>();


    /**
     * 
     */
	 private String unit_name ;


    /**
     * 
     */
	 private Integer pricing_plan_id ;


    /**
     * 
     */
	 private List<ProductMeteredPriceResponse> metered_prices  =  new ArrayList<ProductMeteredPriceResponse>();


    /**
     * 
     */
	 private String item_type ;



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
	 public Integer getProduct_item_id() {
	 	return product_item_id;
	 }  
	 
	 public void setProduct_item_id(Integer  product_item_id) {
	 	this.product_item_id = product_item_id;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public Boolean getIs_visible_on_hosted_page() {
	 	return is_visible_on_hosted_page;
	 }  
	 
	 public void setIs_visible_on_hosted_page(Boolean  is_visible_on_hosted_page) {
	 	this.is_visible_on_hosted_page = is_visible_on_hosted_page;
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
	 public String getCharge_model() {
	 	return charge_model;
	 }  
	 
	 public void setCharge_model(String  charge_model) {
	 	this.charge_model = charge_model;
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
	 public List<ProductItemResponse> getProduct_item_children() {
	 	return product_item_children;
	 }  
	 
	 public void setProduct_item_children(List<ProductItemResponse>  product_item_children) {
	 	this.product_item_children = product_item_children;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getUnit_name() {
	 	return unit_name;
	 }  
	 
	 public void setUnit_name(String  unit_name) {
	 	this.unit_name = unit_name;
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
	 public List<ProductMeteredPriceResponse> getMetered_prices() {
	 	return metered_prices;
	 }  
	 
	 public void setMetered_prices(List<ProductMeteredPriceResponse>  metered_prices) {
	 	this.metered_prices = metered_prices;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getItem_type() {
	 	return item_type;
	 }  
	 
	 public void setItem_type(String  item_type) {
	 	this.item_type = item_type;
	 }


}
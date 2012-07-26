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
public class ProductFamilyRequest extends Object {



    /**
     * 
     */
	 private String description ;


    /**
     * 
     */
	 private String name ;


    /**
     * 
     */
	 private Integer site_id ;


    /**
     * 
     */
	 private List<ProductRequest> products  =  new ArrayList<ProductRequest>();



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
	 public List<ProductRequest> getProducts() {
	 	return products;
	 }  
	 
	 public void setProducts(List<ProductRequest>  products) {
	 	this.products = products;
	 }


}
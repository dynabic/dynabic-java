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
public class ProductMeteredPriceRequest extends Object {


    /**
     * 
     */
	 private Integer id ;

    /**
     * 
     */
	 private Double end_quantity ;

    /**
     * 
     */
	 private Double start_quantity ;

    /**
     * 
     */
	 private String description ;

    /**
     * 
     */
	 private Double unit_price ;


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
	 public Double getEnd_quantity() {
	 	return end_quantity;
	 }  
	 
	 public void setEnd_quantity(Double  end_quantity) {
	 	this.end_quantity = end_quantity;
	 }

	/**
	 * 
	 * 
	 * 
	 */
	 public Double getStart_quantity() {
	 	return start_quantity;
	 }  
	 
	 public void setStart_quantity(Double  start_quantity) {
	 	this.start_quantity = start_quantity;
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
	 public Double getUnit_price() {
	 	return unit_price;
	 }  
	 
	 public void setUnit_price(Double  unit_price) {
	 	this.unit_price = unit_price;
	 }


}
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
 
package com.dynabic.sdk.java.platform.model;

import com.wordnik.swagger.runtime.annotations.*;
import java.util.List;


import java.util.List;

import java.util.ArrayList;

import java.util.Date;


/**
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program. Do not edit the class manually.
 *
 * @author ramesh
 *
 */
public class EventResponse extends Object {



    /**
     * 
     */
	 private Integer id ;


    /**
     * 
     */
	 private String event_type ;


    /**
     * 
     */
	 private Integer site_id ;


    /**
     * 
     */
	 private List<EventParam> parameters  =  new ArrayList<EventParam>();


    /**
     * 
     */
	 private String event_result ;


    /**
     * 
     */
	 private java.util.Date date ;



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
	 public String getEvent_type() {
	 	return event_type;
	 }  
	 
	 public void setEvent_type(String  event_type) {
	 	this.event_type = event_type;
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
	 public List<EventParam> getParameters() {
	 	return parameters;
	 }  
	 
	 public void setParameters(List<EventParam>  parameters) {
	 	this.parameters = parameters;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public String getEvent_result() {
	 	return event_result;
	 }  
	 
	 public void setEvent_result(String  event_result) {
	 	this.event_result = event_result;
	 }


	/**
	 * 
	 * 
	 * 
	 */
	 public java.util.Date getDate() {
	 	return date;
	 }  
	 
	 public void setDate(java.util.Date  date) {
	 	this.date = date;
	 }


}
/**
 * 
 */
package com.api.smongo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

import com.api.smongo.service.SMongoOperationalService;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author Soumya Bose
 *
 * Copyright 2017 Soumya Bose

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
public class SMongoOperationalServiceImpl implements SMongoOperationalService {
	
	private MongoClient mongoClient;
	private String db;
	private DB mongoDb;
	
	public SMongoOperationalServiceImpl(MongoClient mongoClient, String db) {
		this.mongoClient = mongoClient;
		this.db = db;
		mongoDb = mongoClient.getDB(db);
	}

	@Override
	public Map<String, Object> readEntityAsMap(String collection) {
		Map<String, Object> valueMap = new HashMap<>();
		
		DBCollection coll = mongoDb.getCollection(collection);
		DBObject dbObject = coll.findOne();
		
		valueMap = dbObject.toMap();
		
		return valueMap;
	}
	
	@Override
	public JSONObject readEntityAsJSOnObject(String collection) {
		
		Map<String, Object> valueMap = readEntityAsMap(collection);
		
		JSONObject valueJsonObj = new JSONObject(valueMap);
		
		return valueJsonObj;
	}
	
	public JSONObject filter(String collection, Set<String> fields, Map<String, Object> query) {
		
		JSONObject valueJsonObj = new JSONObject();
		
		return valueJsonObj;
		
	}

	/**
	 * @param mongoClient the mongoClient to set
	 */
	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	/**
	 * @param db the db to set
	 */
	public void setDb(String db) {
		this.db = db;
	}
}

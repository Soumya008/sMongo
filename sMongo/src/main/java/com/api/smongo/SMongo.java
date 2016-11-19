/**
 * 
 */
package com.api.smongo;

import java.util.Map;

import org.json.JSONObject;

import com.api.smongo.service.SMongoOperationalService;
import com.api.smongo.service.impl.SMongoOperationalServiceImpl;
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

public class SMongo {

	private MongoClient mongoClient;
	private String db;
	private SMongoOperationalService sMongoOperationalService;
	
	public SMongo(MongoClient mongoClient, String db) {
		this.mongoClient = mongoClient;
		this.db = db;
		this.sMongoOperationalService = new SMongoOperationalServiceImpl(mongoClient, db);
	}
	
	public Map<String, Object> readEntityAsMap(String collection) {
	
		return sMongoOperationalService.readEntityAsMap(collection);
	}
	
	public JSONObject readEntityAsJSOnObject(String collection) {
		
		return sMongoOperationalService.readEntityAsJSOnObject(collection);
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

/**
 * 
 */
package com.api.smongo;

import java.util.Map;

import org.json.JSONObject;

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
public class SMongoTest {

	public static void main(String args[]) {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		SMongo sMongo = new SMongo(mongoClient, "tenant_plavaga");
		
		Map<String, Object> users = sMongo.readEntityAsMap("users");
		System.out.println("users map :: " + users);
		
		JSONObject usersJsonObj = sMongo.readEntityAsJSOnObject("users");
		System.out.println("users json object :: " + usersJsonObj);
	}
}

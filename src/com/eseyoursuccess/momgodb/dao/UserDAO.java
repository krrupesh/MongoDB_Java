package com.eseyoursuccess.momgodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.eseyoursuccess.momgodb.converter.UserConverter;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import model.User;

public class UserDAO {

	private DBCollection coll;
	
	
	public UserDAO(MongoClient mongo) {
		this.coll = mongo.getDB("usersDB").getCollection("users");
	}
	
	public User createUser(User u){
		DBObject doc = UserConverter.toDBObject(u);
		this.coll.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		u.setId(id.toString());
		System.out.println("Converted to DB Object");
		return u;
	}
	
	public List<User> readAllUsers(){
		List<User> data = new ArrayList<User>();
		DBCursor cursor = coll.find();
		while(cursor.hasNext()){
			DBObject doc = cursor.next();
			User u = UserConverter.toUser(doc);
			data.add(u);
		}
		return data;
	}

	
}

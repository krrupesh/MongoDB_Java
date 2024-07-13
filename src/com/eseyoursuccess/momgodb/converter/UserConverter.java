package com.eseyoursuccess.momgodb.converter;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import model.User;

public class UserConverter {

	public static DBObject toDBObject(User u) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("name", u.getName())
				.append("email", u.getEmail())
				.append("password", u.getPassword());
		
		if(u.getId() != null)
			builder = builder.append("_id", new ObjectId(u.getId()));
		
		
		return builder.get();
	}

	public static User toUser(DBObject doc) {

		User u = new User();
		u.setName((String) doc.get("name"));
		u.setEmail((String) doc.get("email"));
		u.setPassword((String) doc.get("password"));
		ObjectId id = (ObjectId) doc.get("_id");
		u.setId(id.toString());
		
		return u;
	}

	
}

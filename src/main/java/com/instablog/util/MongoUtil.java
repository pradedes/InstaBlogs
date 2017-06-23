package com.instablog.util;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MongoUtil {
	
	public static Datastore initMongo(){
		System.out.println("MongoUtil.initMongo() test sfgf************************************");
		//MongoClient mongoClient = new MongoClient(":27017");
		MongoClient mongoClient = new MongoClient("35.188.58.122", 27017);
		Morphia morphia = new Morphia();
		String databaseName = "instablog";
		Datastore datastore = morphia.createDatastore(mongoClient, databaseName);
		System.out.println("MongoUtil.initMongo() " +datastore);
			return datastore;
	}

	
	public static void deInitMongo(MongoClient mongo){
		mongo.close();
	}
}

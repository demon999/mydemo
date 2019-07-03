package com.snow.mongodb;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created by richard.xue on 14-6-21.
 */
public class Test {
    public static void main(String[] arg) {
        test();
    }

    public static void demo() {
        try {
            Mongo mongo = new Mongo();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        try {

            Mongo mongo = new Mongo("localhost", 27017);

            DB db = mongo.getDB("company");

            DBCollection collection = db.getCollection("employees");

            BasicDBObject employee = new BasicDBObject();
            employee.put("name", "Hannah");
            employee.put("no", 2);

            collection.insert(employee);

            BasicDBObject searchEmployee = new BasicDBObject();
            searchEmployee.put("no", 2);

            DBCursor cursor = collection.find(searchEmployee);

            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

            System.out.println("The Search Query has Executed!");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }

    }
}

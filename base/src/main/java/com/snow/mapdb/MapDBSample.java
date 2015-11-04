package com.snow.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 11/04/2015
 * @description
 */
public class MapDBSample {
    public static void main(String[] args) {
        MapDBSample mapDBSample = new MapDBSample();
        mapDBSample.test();
    }

    public void test() {
        DB db = DBMaker.newMemoryDB().make();
        ConcurrentNavigableMap<String,String> treeMap = db.getTreeMap("map");
        treeMap.put("something", "here");
        db.commit();

        ConcurrentNavigableMap<String,String> treeMap2 = db.getTreeMap("map");
        System.out.println(treeMap2.get("something"));

        db.close();
    }

    public void test2() {
        // configure and open database using builder pattern.
        // all options are available with code auto-completion.
        DB db = DBMaker.newFileDB(new File("testdb"))
                .closeOnJvmShutdown()
                .encryptionEnable("password")
                .make();
        // open existing an collection (or create new)
        ConcurrentNavigableMap<Integer,String> map = db.getTreeMap("collectionName");
        map.put(1, "one");
        map.put(2, "two");
        // map.keySet() is now [1,2]
        db.commit();  //persist changes into disk
        map.put(3, "three");
        // map.keySet() is now [1,2,3]
        db.rollback(); //revert recent changes
        // map.keySet() is now [1,2]
        db.close();
    }

    public void test3() {
        DB db = DBMaker.newFileDB(new File("testdb"))
                .closeOnJvmShutdown()
                .encryptionEnable("password")
                .make();
        // open existing an collection (or create new)
        ConcurrentNavigableMap<Integer,String> map = db.getTreeMap("collectionName");
        System.out.println(map.get(1));
    }
}

package com.tesco.mewbase.doc.impl.lmdb;

import com.tesco.mewbase.bson.BsonObject;
import com.tesco.mewbase.client.QueryResult;
import com.tesco.mewbase.doc.DocManager;
import org.fusesource.lmdbjni.Database;
import org.fusesource.lmdbjni.Env;

import java.util.concurrent.CompletableFuture;

/**
 * Created by tim on 09/11/16.
 */
public class LmdbDocManager implements DocManager {

    @Override
    public CompletableFuture<BsonObject> findByID(String binderName, String id) {
        return null;
    }

    @Override
    public CompletableFuture<QueryResult> findMatching(String binderName, BsonObject matcher) {
        return null;
    }

    @Override
    public CompletableFuture<Void> save(String binder, String id, BsonObject doc) {
        return null;
    }

    public static void main(String[] args) {
        try {
            LmdbDocManager docManager = new LmdbDocManager("docsDir");
            docManager.start();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final String docsDir;
    private Database db;

    public LmdbDocManager(String docsDir) {
        this.docsDir = docsDir;
    }

    public void start() {
        Env env = new Env(docsDir);
        db = env.openDatabase();
    }

    public void stop() {
        db.close();
    }

}

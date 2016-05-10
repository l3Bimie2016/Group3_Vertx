package database;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.sql.UpdateResult;

import java.util.List;


/**
 * Created by Axel on 09/05/2016.
 */
public class DatabaseVertX {

    public static void setDevisHabitation(String sql, JsonArray params, Handler<AsyncResult<Integer>> callBack)  {


        Vertx.currentContext().owner().runOnContext(c -> {
            JsonObject mySQLClientConfig = new JsonObject().put("host", "localhost").put("port", 3306).put("maxPoolSize",
                    5).put("username", "root").put("password", "azeaze").put("database", "group3_vertx");
            AsyncSQLClient mySQLClient = MySQLClient.createShared(Vertx.currentContext().owner(), mySQLClientConfig);

            mySQLClient.getConnection(res -> {
                if (res.succeeded()) {
                    SQLConnection connection = res.result();
                    System.out.println("OK");
                    connection.updateWithParams(sql,params,x ->{
                        if (x.succeeded()){
                            callBack.handle(Future.succeededFuture(1));
                        } else {
                            callBack.handle(Future.failedFuture(x.cause()));
                        }
                    } );
                    // Got a connection
                } else {
                    callBack.handle(Future.failedFuture(res.cause()));
                    System.out.println("Error connection");
                }
            });
        });


    }

    public static void getDevisHabitations(String sql, JsonArray params, Handler<AsyncResult<List<JsonObject>>> callBack)  {


        Vertx.currentContext().owner().runOnContext(c -> {
            JsonObject mySQLClientConfig = new JsonObject().put("host", "localhost").put("port", 3306).put("maxPoolSize",
                    5).put("username", "root").put("password", "azeaze").put("database", "group3_vertx");
            AsyncSQLClient mySQLClient = MySQLClient.createShared(Vertx.currentContext().owner(), mySQLClientConfig);

            mySQLClient.getConnection(res -> {
                if (res.succeeded()) {
                    SQLConnection connection = res.result();
                    System.out.println("OK");
                    connection.query(sql,x ->{
                        if (x.succeeded()){
                            callBack.handle(Future.succeededFuture(x.result().getRows()));
                        } else {
                            System.out.println("failedFuture");
                            callBack.handle(Future.failedFuture(x.cause()));
                        }

                    } );
                    // Got a connection

                } else {
                    callBack.handle(Future.failedFuture(res.cause()));
                    System.out.println("Error connection");
                }
            });
        });


    }
}

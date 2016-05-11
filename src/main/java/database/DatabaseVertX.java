package database;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.sql.SQLConnection;
import model.DevisHabitation;
import model.DevisVehicule;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Axel on 09/05/2016.
 */
public class DatabaseVertX {

    public static void setDevisHabitationAndVehicule(String sql, JsonArray params, Handler<AsyncResult<Integer>> callBack) {


        Vertx.currentContext().owner().runOnContext(c -> {
            JsonObject mySQLClientConfig = new JsonObject().put("host", "localhost").put("port", 3306).put("maxPoolSize",
                    5).put("username", "root").put("password", "azeaze").put("database", "group3_vertx");
            AsyncSQLClient mySQLClient = MySQLClient.createShared(Vertx.currentContext().owner(), mySQLClientConfig);

            mySQLClient.getConnection(res -> {
                if (res.succeeded()) {
                    SQLConnection connection = res.result();
                    System.out.println("OK");
                    connection.updateWithParams(sql, params, x -> {
                        if (x.succeeded()) {
                            callBack.handle(Future.succeededFuture(1));
                        } else {
                            callBack.handle(Future.failedFuture(x.cause()));
                        }
                    });
                    // Got a connection
                } else {
                    callBack.handle(Future.failedFuture(res.cause()));
                    System.out.println("Error connection");
                }
            });
        });
    }

    public static void getDevisHabitations(String sql, Handler<AsyncResult<List<DevisHabitation>>> callBack) {

        Vertx.currentContext().owner().runOnContext(c -> {
            JsonObject mySQLClientConfig = new JsonObject().put("host", "localhost").put("port", 3306).put("maxPoolSize",
                    5).put("username", "root").put("password", "azeaze").put("database", "group3_vertx");
            AsyncSQLClient mySQLClient = MySQLClient.createShared(Vertx.currentContext().owner(), mySQLClientConfig);

            mySQLClient.getConnection(res -> {
                if (res.succeeded()) {
                    SQLConnection connection = res.result();
                    System.out.println("OK");
                    connection.query(sql, x -> {
                        if (x.succeeded()) {
                            List<DevisHabitation> devisHabitations = x.result().getRows().stream()
                                    .map(r -> Json.decodeValue(r.encode(),DevisHabitation.class))
                                    .collect(Collectors.toList());
                            callBack.handle(Future.succeededFuture(devisHabitations));
                        } else {
                            System.out.println("failedFuture");
                            callBack.handle(Future.failedFuture(x.cause()));
                        }
                    });
                    // Got a connection
                } else {
                    callBack.handle(Future.failedFuture(res.cause()));
                    System.out.println("Error connection");
                }
            });
        });
    }

    public static void getDevisVehicule(String sql, Handler<AsyncResult<List<DevisVehicule>>> callBack) {

        Vertx.currentContext().owner().runOnContext(c -> {
            JsonObject mySQLClientConfig = new JsonObject().put("host", "localhost").put("port", 3306).put("maxPoolSize",
                    5).put("username", "root").put("password", "azeaze").put("database", "group3_vertx");
            AsyncSQLClient mySQLClient = MySQLClient.createShared(Vertx.currentContext().owner(), mySQLClientConfig);

            mySQLClient.getConnection(res -> {
                if (res.succeeded()) {
                    SQLConnection connection = res.result();
                    System.out.println("OK");
                    connection.query(sql, x -> {
                        if (x.succeeded()) {
                            List<DevisVehicule> devisVehicules = x.result().getRows().stream()
                                    .map(r -> Json.decodeValue(r.encode(),DevisVehicule.class))
                                    .collect(Collectors.toList());
                            callBack.handle(Future.succeededFuture(devisVehicules));
                        } else {
                            System.out.println("failedFuture");
                            callBack.handle(Future.failedFuture(x.cause()));
                        }
                    });
                    // Got a connection
                } else {
                    callBack.handle(Future.failedFuture(res.cause()));
                    System.out.println("Error connection");
                }
            });
        });
    }
}

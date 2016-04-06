package database;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.sql.SQLConnection;

/**
 * Created by luffy on 05/04/16.
 */
public class MysqlConf extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        JsonObject mySQLClientConfig = new JsonObject().put("host", "localhost").put("port", 3306).put("maxPoolSize",
                5).put("username", "root").put("password", "aze").put("database", "group3_vertx");
        AsyncSQLClient mySQLClient = MySQLClient.createShared(vertx, mySQLClientConfig);

        mySQLClient.getConnection(res -> {
            if (res.succeeded()) {

                SQLConnection connection = res.result();
                System.out.println("OK");
                // Got a connection

            } else {
                System.out.println("Error");
            }
        });
    }
}

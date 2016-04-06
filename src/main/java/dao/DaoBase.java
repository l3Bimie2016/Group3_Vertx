package dao;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

/**
 * Created by luffy on 05/04/16.
 */
public class DaoBase extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        vertx.eventBus().consumer("users", (Message<JsonObject> objectMessage) -> {
            System.out.println(objectMessage.body().toString());
            objectMessage.reply(objectMessage.body().getString("firstName").toString());
        });

    }
}

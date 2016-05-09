package controller;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Created by luffy on 05/04/16.
 */
public class DevisController extends AbstractVerticle {

    @Override
    public void start() throws Exception {


        final Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        router.post("/devisHabitation")
                .handler(req -> {
                    req.getBodyAsJson();
                    vertx.eventBus().send("devisHabitation", req.getBodyAsJson(), result -> {

                        if(result.succeeded()) {
                            req.response().end(result.result().body().toString());
                        } else {
                            req.response().end("-1");
                        }
                    });
                });


        router.post("/devisVehicule")
                .handler(req -> {
                    req.getBodyAsJson();
                    vertx.eventBus().send("devisVehicule", req.getBodyAsJson(), result -> {

                        if(result.succeeded()) {
                            req.response().end(result.result().body().toString());
                        } else {
                            req.response().end("-1");
                        }
                    });
                });

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8080);
    }
}

package service;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Created by luffy on 05/04/16.
 */
public class Front extends AbstractVerticle {

    @Override
    public void start() throws Exception {


        final Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        router.post("/authentification/")
                .handler(req -> {
                    req.getBodyAsJson();
                    vertx.eventBus().send("users", req.getBodyAsJson(), result -> {
                        req.response().end(result.result().body().toString());
                    });
                });


        router.get("/byebye/")
                .handler(req -> req.response()
                        .end("<html><body><h1>Bye Bye World</h1></body></html>"));

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8080);
    }
}

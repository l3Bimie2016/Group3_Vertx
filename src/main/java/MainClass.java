import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

/**
 *
 * VertX main class
 * Created by axel on 05/04/16.
 */
public class MainClass extends AbstractVerticle {


    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(MainClass.class.getCanonicalName());
    }

    @Override
    public void start() throws Exception {

        vertx.deployVerticle("service.DevisService");
        vertx.deployVerticle("dao.DevisDao");
        vertx.deployVerticle("controller.DevisController");
    }
}

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

/**
 * Created by luffy on 05/04/16.
 */
public class Main extends AbstractVerticle {


    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(Main.class.getCanonicalName());
    }

    @Override
    public void start() throws Exception {

        vertx.deployVerticle("database.MysqlConf");
        vertx.deployVerticle("dao.DaoBase");
        vertx.deployVerticle("service.Front");
    }
}

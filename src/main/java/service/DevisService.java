package service;

import database.DatabaseVertX;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.json.JSONArray;

import java.util.Arrays;

/**
 * Created by Axel on 09/05/2016.
 */
public class DevisService  extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        vertx.eventBus().consumer("devisHabitation", (Message<JsonObject> objectMessage) -> {
            System.out.println(objectMessage.body().getString("nom"));

            String Sql = "SELECT * FROM group3_vertx.devis_habitations;INSERT INTO `group3_vertx`.`devis_habitations`\n" +
                    "(`nom`,\n" +
                    "`prenom`,\n" +
                    "`nom_devis`,\n" +
                    "`type_habitation`,\n" +
                    "`surface`,\n" +
                    "`nombre_piece`,\n" +
                    "`etage`,\n" +
                    "`nombre_salle_bain`,\n" +
                    "`garage`,\n" +
                    "`surface_terrain`,\n" +
                    "`surface_terasse`,\n" +
                    "`type_chauffage`,\n" +
                    "`resume`,\n" +
                    "`formule_1`,\n" +
                    "`formule_2`,\n" +
                    "`prix`)\n" +
                    "VALUES\n" +
                    "(nom= ?,\n" +
                    "prenom= ?,\n" +
                    "nom_devis= ?,\n" +
                    "type_habitation= ?,\n" +
                    "surface= ?,\n" +
                    "nombre_piece= ?,\n" +
                    "etage= ?,\n" +
                    "nombre_salle_bain= ?,\n" +
                    "garage= ?,\n" +
                    "surface_terrain= ?,\n" +
                    "surface_terasse= ?,\n" +
                    "type_chauffage= ?,\n" +
                    "resume= ?,\n" +
                    "formule_1= ?,\n" +
                    "formule_2= ?,\n" +
                    "prix= ?);\n";
            DatabaseVertX.start(Sql,r -> {
                objectMessage.reply(new JsonArray(Arrays.asList(r.result())));

            });

        });

        vertx.eventBus().consumer("devisVehicule", (Message<JsonObject> objectMessage) -> {
            System.out.println(objectMessage.body().getString("nom"));

            String Sql = "INSERT INTO `group3_vertx`.`devis_habitations`(nom)VALUES(\"Toto\")";
            DatabaseVertX.start(Sql,r -> {
                objectMessage.reply(new JsonArray(Arrays.asList(r.result())));

            });

        });

    }


}

package service;

import database.DatabaseVertX;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import model.DevisHabitation;

import java.util.Arrays;


/**
 * Created by Axel on 09/05/2016.
 */
public class DevisService  extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        vertx.eventBus().consumer("devisHabitation", (Message<JsonObject> objectMessage) -> {
            System.out.println(objectMessage.body().getString("nom"));
            DevisHabitation devisHabitation = Json.decodeValue(objectMessage.body().encode(), DevisHabitation.class);

            JsonArray params = new JsonArray();
            params.add(devisHabitation.getNom());
            params.add(devisHabitation.getPrenom());
            params.add(devisHabitation.getNomDevis());
            params.add(devisHabitation.getTypeHabitation());
            params.add(devisHabitation.getSurface());
            params.add(devisHabitation.getNombrePiece());
            params.add(devisHabitation.getEtage());
            params.add(devisHabitation.getNombreSalleBain());
            params.add(devisHabitation.getGarage());
            params.add(devisHabitation.getSurfaceTerrain());
            params.add(devisHabitation.getSurfaceTerasse());
            params.add(devisHabitation.getTypeChauffage());
            params.add(devisHabitation.getResume());
            params.add(devisHabitation.getFormule1());
            params.add(devisHabitation.getFormule2());
            params.add(devisHabitation.getPrix());

            String sql = "INSERT INTO `group3_vertx`.`devis_habitations`" +
                    "(`nom`," +
                    "`prenom`," +
                    "`nom_devis`," +
                    "`type_habitation`," +
                    "`surface`," +
                    "`nombre_piece`," +
                    "`etage`," +
                    "`nombre_salle_bain`," +
                    "`garage`," +
                    "`surface_terrain`," +
                    "`surface_terasse`," +
                    "`type_chauffage`," +
                    "`resume`," +
                    "`formule_1`," +
                    "`formule_2`," +
                    "`prix`)" +
                    "VALUES" +
                    "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            DatabaseVertX.setDevisHabitation(sql,params,r -> {
                objectMessage.reply(r.result());
//                objectMessage.reply(new JsonArray(Arrays.asList(r.result())));

            });

        });

//        vertx.eventBus().consumer("devisHabitation", (Message<JsonObject> objectMessage) -> {
//
//            String sql ="SELECT * FROM devis_habitations"
//
//            DatabaseVertX.getDevisHabitations(sql,r -> {
//                objectMessage.reply(
//                );
//
//            });
//
//        });
    }


}

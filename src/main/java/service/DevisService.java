package service;

import database.DatabaseVertX;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import model.DevisHabitation;
import model.DevisVehicule;

import javax.persistence.Transient;
import java.util.Arrays;


/**
 * Created by Axel on 09/05/2016.
 */
public class DevisService extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        vertx.eventBus().consumer("devisHabitationPost", (Message<JsonObject> objectMessage) -> {

            JsonArray params = new JsonArray();

            DevisHabitation devisHabitation = Json.decodeValue(objectMessage.body().encode(), DevisHabitation.class);
            Arrays.stream(DevisHabitation.class.getDeclaredFields()).forEach(x -> {
                try {
                    if (x.getAnnotation(Transient.class) == null) {
                        x.setAccessible(true);
                        Object object = x.get((devisHabitation));
                        if (object != null ) {
                            params.add(x.get(devisHabitation));
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
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
                    "`surface_terrasse`," +
                    "`type_chauffage`," +
                    "`formule`," +
                    "`prix`)" +
                    "VALUES" +
                    "(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            DatabaseVertX.setDevisHabitationAndVehicule(sql, params, r -> {
                objectMessage.reply(r.result());
            });
        });

        vertx.eventBus().consumer("devisHabitationGet", (Message<JsonObject> objectMessage) -> {

            String sql = "SELECT * FROM devis_habitations";

            DatabaseVertX.getDevisHabitations(sql, r -> {
                objectMessage.reply(Json.encode(r.result()));

            });
        });


        vertx.eventBus().consumer("devisVehiculePost", (Message<JsonObject> objectMessage) -> {

            JsonArray params = new JsonArray();

            DevisVehicule devisVehicule = Json.decodeValue(objectMessage.body().encode(), DevisVehicule.class);
            Arrays.stream(DevisVehicule.class.getDeclaredFields()).forEach(x -> {
                try {
                    if (x.getAnnotation(Transient.class) == null) {
                        x.setAccessible(true);
                        Object object = x.get((devisVehicule));
                        if (object != null ) {
                            params.add(x.get(devisVehicule));
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });

            String sql = "INSERT INTO `group3_vertx`.`devis_vehicule`" +
                    "(`nom`," +
                    "`prenom`," +
                    "`nom_devis`," +
                    "`marque`," +
                    "`modele`," +
                    "`carburant`," +
                    "`chevaux`," +
                    "`date_permis`," +
                    "`bonus_malus`," +
                    "`conducteur_principal`," +
                    "`conducteur_secondaire`," +
                    "`dors_garage`," +
                    "`adresse`," +
                    "`resume_devis`," +
                    "`tous_risques`," +
                    "`au_tier`)" +
                    "`montant_devis`)" +
                    "VALUES" +
                    "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            DatabaseVertX.setDevisHabitationAndVehicule(sql, params, r -> {
                objectMessage.reply(r.result());
            });
        });

        vertx.eventBus().consumer("devisVehiculeGet", (Message<JsonObject> objectMessage) -> {

            String sql = "SELECT * FROM devis_vehicule";

            DatabaseVertX.getDevisVehicule(sql, r -> {
                objectMessage.reply(Json.encode(r.result()));

            });
        });
    }
}

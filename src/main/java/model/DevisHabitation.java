package model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Created by Axel on 09/05/2016.
 */
public class DevisHabitation {

    @JsonProperty("id_devis_habitations")
    private Integer idDevisHabitations;
    @JsonProperty("id_user")
    private Integer idUser;
    private String nom;
    private String prenom;
    @JsonProperty("nom_devis")
    private String nomDevis;
    @JsonProperty("type_habitation")
    private String typeHabitation;
    private Integer surface;
    @JsonProperty("nombre_piece")
    private Integer nombrePiece;
    private Integer etage;
    @JsonProperty("nombre_salle_bain")
    private Integer nombreSalleBain;
    private Integer garage;
    @JsonProperty("surface_terrain")
    private Integer surfaceTerrain;
    @JsonProperty("surface_terrasse")
    private Integer surfaceTerrasse;
    @JsonProperty("type_chauffage")
    private String typeChauffage;
    private String formule;
    private Integer prix;


    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdDevisHabitations() {
        return idDevisHabitations;
    }

    public void setIdDevisHabitations(Integer idDevisHabitations) {
        this.idDevisHabitations = idDevisHabitations;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomDevis() {
        return nomDevis;
    }

    public void setNomDevis(String nomDevis) {
        this.nomDevis = nomDevis;
    }

    public String getTypeHabitation() {
        return typeHabitation;
    }

    public void setTypeHabitation(String typeHabitation) {
        this.typeHabitation = typeHabitation;
    }

    public Integer getSurface() {
        return surface;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    public Integer getNombrePiece() {
        return nombrePiece;
    }

    public void setNombrePiece(Integer nombrePiece) {
        this.nombrePiece = nombrePiece;
    }

    public Integer getEtage() {
        return etage;
    }

    public void setEtage(Integer etage) {
        this.etage = etage;
    }

    public Integer getNombreSalleBain() {
        return nombreSalleBain;
    }

    public void setNombreSalleBain(Integer nombreSalleBain) {
        this.nombreSalleBain = nombreSalleBain;
    }

    public Integer getGarage() {
        return garage;
    }

    public void setGarage(Integer garage) {
        this.garage = garage;
    }

    public Integer getSurfaceTerrain() {
        return surfaceTerrain;
    }

    public void setSurfaceTerrain(Integer surfaceTerrain) {
        this.surfaceTerrain = surfaceTerrain;
    }

    public Integer getSurfaceTerrasse() {
        return surfaceTerrasse;
    }

    public void setSurfaceTerrasse(Integer surfaceTerrasse) {
        this.surfaceTerrasse = surfaceTerrasse;
    }

    public String getTypeChauffage() {
        return typeChauffage;
    }

    public void setTypeChauffage(String typeChauffage) {
        this.typeChauffage = typeChauffage;
    }

    public String getFormule() {
        return formule;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }
}

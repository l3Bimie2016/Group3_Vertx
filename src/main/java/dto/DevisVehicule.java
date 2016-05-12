package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Devis vehicule Dto
 * Created by Axel on 11/05/2016.
 */
public class DevisVehicule {

    @JsonProperty("id_devis_vehicule")
    private Integer idDevisVehicule;
    private String nom;
    private String prenom;
    @JsonProperty("nom_devis")
    private String nomDevis;
    private String marque;
    private String modele;
    private String carburant;
    private Integer chevaux;
    @JsonProperty("date_permis")
    private Date datePermis;
    @JsonProperty("nombre_accident")
    private Integer nombreAccident;
    @JsonProperty("bonus_malus")
    private String bonusMalus;
    @JsonProperty("conducteur_principal")
    private String conducteurPrincipal;
    @JsonProperty("conducteur_secondaire")
    private String conducteurSecondaire;
    @JsonProperty("dors_garage")
    private Integer dorsGarage;
    private String adresse;
    @JsonProperty("resume_devis")
    private String resumeDevis;
    @JsonProperty("tous_risques")
    private String tousRisques;
    @JsonProperty("au_tier")
    private Integer auTier;
    @JsonProperty("montant_devis")
    private Integer montantDevis;

    public Integer getIdDevisVehicule() {
        return idDevisVehicule;
    }

    public void setIdDevisVehicule(Integer idDevisVehicule) {
        this.idDevisVehicule = idDevisVehicule;
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

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public Integer getChevaux() {
        return chevaux;
    }

    public void setChevaux(Integer chevaux) {
        this.chevaux = chevaux;
    }

    public Date getDatePermis() {
        return datePermis;
    }

    public void setDatePermis(Date datePermis) {
        this.datePermis = datePermis;
    }

    public Integer getNombreAccident() {
        return nombreAccident;
    }

    public void setNombreAccident(Integer nombreAccident) {
        this.nombreAccident = nombreAccident;
    }

    public String getBonusMalus() {
        return bonusMalus;
    }

    public void setBonusMalus(String bonusMalus) {
        this.bonusMalus = bonusMalus;
    }

    public String getConducteurPrincipal() {
        return conducteurPrincipal;
    }

    public void setConducteurPrincipal(String conducteurPrincipal) {
        this.conducteurPrincipal = conducteurPrincipal;
    }

    public String getConducteurSecondaire() {
        return conducteurSecondaire;
    }

    public void setConducteurSecondaire(String conducteurSecondaire) {
        this.conducteurSecondaire = conducteurSecondaire;
    }

    public Integer getDorsGarage() {
        return dorsGarage;
    }

    public void setDorsGarage(Integer dorsGarage) {
        this.dorsGarage = dorsGarage;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getResumeDevis() {
        return resumeDevis;
    }

    public void setResumeDevis(String resumeDevis) {
        this.resumeDevis = resumeDevis;
    }

    public String getTousRisques() {
        return tousRisques;
    }

    public void setTousRisques(String tousRisques) {
        this.tousRisques = tousRisques;
    }

    public Integer getAuTier() {
        return auTier;
    }

    public void setAuTier(Integer auTier) {
        this.auTier = auTier;
    }

    public Integer getMontantDevis() {
        return montantDevis;
    }

    public void setMontantDevis(Integer montantDevis) {
        this.montantDevis = montantDevis;
    }
}

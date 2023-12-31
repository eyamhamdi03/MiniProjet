package University ;
public class Matiere {
    private String nom;
    private String horaire;
    private String departement;

    public Matiere(String nom, String horaire, String department) {
        this.nom = nom;
        this.horaire = horaire;
        this.departement = department;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
    public void afficherDetailsMatiere() {
        System.out.println("Nom de la matière : " + getNom());
        System.out.println("Horaire : " + getHoraire());
        System.out.println("Département : " + getDepartement());
    }


}

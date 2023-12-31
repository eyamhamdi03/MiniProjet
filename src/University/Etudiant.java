package University;

public class Etudiant extends Personne {
    private Classe classe; 

    public Etudiant(String nom, String prenom, String adresse, String email, String numeroTelephone, String matricule) {
        super(nom, prenom, adresse, email, numeroTelephone, "étudiant", matricule); // Initialise le titre à "étudiant"
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    @Override
    public void afficherDetails() {
        System.out.println("Nom : " + getNom());
        System.out.println("Prénom : " + getPrenom());
        System.out.println("Adresse : " + getAdresse());
        System.out.println("Email : " + getEmail());
        System.out.println("Numéro de téléphone : " + getNumeroTelephone());
        System.out.println("Titre : " + getTitre());
        System.out.println("Matricule : " + getMatricule());
       
        if (classe != null) {
            System.out.println("Classe : " + classe.getClassName()); 
        }
    }
}
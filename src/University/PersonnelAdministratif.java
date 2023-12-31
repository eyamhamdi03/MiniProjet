package University;
import java.util.ArrayList;
import java.util.List;

public class PersonnelAdministratif extends Personne {
    private String departement;
    private String horaire;
    private List<Classe> classes;

    public PersonnelAdministratif(String nom, String prenom, String adresse, String email, String numeroTelephone,
                                  String matricule, String departement, String horaire) {
        super(nom, prenom, adresse, email, numeroTelephone, "personnel administratif", matricule);
        this.departement = departement;
        this.horaire = horaire;
        classes=new ArrayList<Classe>();
    }
    public Classe findClassByName(String className) {
        for (Classe classe : classes) {
            if (classe.getClassName().equals(className)) {
                return classe;
            }
        }
        System.out.println("Class not found");
        return null; // Retourne null si la classe n'est pas trouvée
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }
    public void addStudentToClass(Etudiant student, Classe classe) {
        boolean found = false;
        for (Classe existingClass : classes) {
            if (existingClass.equals(classe)) {
                found = true;
                existingClass.addStudentToClass(student);
                break;
            }
        }

        if (!found) {
            System.out.println("Class not found in the list.");
        }
    }


    public void addTeacherToMatiere(Enseignant teacher, Matiere matiere,Classe classe ) {
    	boolean found = false;
        for (Classe existingClass : classes) {
            if (existingClass.equals(classe)) {
                found = true;
                existingClass.addMatiereToClass(matiere, teacher);
               
                break;
            }
        }

        if (!found) {
            System.out.println("Class not found in the list.");
        }

    }
    
  
    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }
    public void afficherToutesLesClasses() {
        System.out.println("Liste de toutes les classes :");
        for (Classe classe : classes) {
            classe.displayClassDetails();
        }}

    @Override
    public void afficherDetails() {
        System.out.println("Nom : " + getNom());
        System.out.println("Prénom : " + getPrenom());
        System.out.println("Adresse : " + getAdresse());
        System.out.println("Email : " + getEmail());
        System.out.println("Numéro de téléphone : " + getNumeroTelephone());
        System.out.println("Titre : " + getTitre());
        System.out.println("Matricule : " + getMatricule());
        System.out.println("Département : " + departement);
        System.out.println("Horaire : " + horaire);
    }
}

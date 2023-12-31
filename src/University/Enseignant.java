package University;

import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Personne {
    private List<Classe> classesEnseignees;
    
    private String type; 
    private String horaireParSemaine; 
    private String bureau; 
    private String departement ;

    public Enseignant(String nom, String prenom, String adresse, String email, String numeroTelephone,String matricule, String type, String horaireParSemaine, String bureau, String departement) {
    		super(nom, prenom, adresse, email, numeroTelephone, "enseignant", matricule);
    		this.classesEnseignees = new ArrayList<>();
    		this.type = type;
    		
    		this.horaireParSemaine = horaireParSemaine;
    		this.bureau = bureau;
    		this.departement = departement;
}

    public List<Classe> getClassesEnseignees() {
        return classesEnseignees;
    }

    public void setClassesEnseignees(List<Classe> classesEnseignees) {
        this.classesEnseignees = classesEnseignees;
    }
    


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHoraireParSemaine() {
        return horaireParSemaine;
    }

    public void setHoraireParSemaine(String horaireParSemaine) {
        this.horaireParSemaine = horaireParSemaine;
    }

    public String getBureau() {
        return bureau;
    }

    public void setBureau(String bureau) {
        this.bureau = bureau;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
    public void addNoteToStudent(Classe classe, Etudiant student, double note,Matiere matiere) {
        boolean found = false;
        for (Classe existingClass : classesEnseignees) {
            if (existingClass.equals(classe)) {
                found = true;
                existingClass.addNoteForEtudiant(matiere, this, student,note);
                break;
            }
        }

        if (!found) {
            System.out.println("Class not found in the list of classes taught.");
        }
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
        System.out.println("Type : " + getType());
        System.out.println("Horaire par semaine : " + getHoraireParSemaine());
        System.out.println("Bureau : " + getBureau());
        System.out.println("Département : " + getDepartement()); 
        if (!classesEnseignees.isEmpty()) {
            System.out.println("Classes enseignées :");
            for (Classe classe : classesEnseignees) {
                System.out.println("- " + classe.getClassName());
            }
        } else {
            System.out.println("Pas de classe attribuée pour le moment.");
        }
    }
}

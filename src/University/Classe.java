
package University;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Classe {
    private String className;
    private List<Etudiant> students;
    private int maxStudents = 30;
    private Map<Matiere, Enseignant> matieres;
    private Map<Etudiant,Double> notes ;

    public List<Enseignant> getTeachers() {
        List<Enseignant> teachersList = new ArrayList<>();

        for (Enseignant teacher : matieres.values()) {
            if (!teachersList.contains(teacher)) {
                teachersList.add(teacher);
            }
        }

        return teachersList;
    }

    
    public void addNoteForEtudiant(Matiere matiere, Enseignant teacher, Etudiant student, double note) {
        boolean found = false;
        for (Map.Entry<Matiere, Enseignant> entry : matieres.entrySet()) {
            Matiere existingMatiere = entry.getKey();
            Enseignant existingTeacher = entry.getValue();

            if (existingMatiere.equals(matiere) && existingTeacher.equals(teacher)) {
                found = true;
                if (notes.containsKey(student)) {
                    notes.put(student, note);
                    System.out.println("Note for student " + student.getNom() + " updated to " + note + " for subject " + matiere.getNom() + " in class " + className);
                } else {
                    System.out.println("Student " + student.getNom() + " is not enrolled in class " + className);
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Subject " + matiere.getNom() + " not found in the class " + className + " taught by " + teacher.getNom());
        }
    }

    public void displayClassDetails() {
        System.out.println("Class name: " + className);
        
        // Displaying students' details
        System.out.println("List of students:");
        for (Etudiant student : students) {
            student.afficherDetails();
            System.out.println("----------------------");
        }
        
        // Displaying subjects and their respective teachers
        System.out.println("List of subjects and teachers:");
        for (Map.Entry<Matiere, Enseignant> entry : matieres.entrySet()) {
            Matiere subject = entry.getKey();
            Enseignant teacher = entry.getValue();
            
            subject.afficherDetailsMatiere();
            teacher.afficherDetails();
            System.out.println("----------------------");
        }
    }


    public void modifyNoteForEtudiant(Matiere matiere, Enseignant enseignant, Etudiant etudiant, double newNote) {
        // Check if the given enseignant is associated with the given matiere in this class
        if (matieres.containsKey(matiere) && matieres.get(matiere).equals(enseignant)) {
            // Check if the student is in the class
            if (students.contains(etudiant)) {
                if (notes.containsKey(etudiant)) {
                    notes.put(etudiant, newNote);
                    System.out.println("Modified note for student " + etudiant.getNom() + " in " + matiere.getNom() +
                            " to " + newNote);
                } else {
                    System.out.println("No previous note found for " + etudiant.getNom() + " in " + matiere.getNom());
                }
            } else {
                System.out.println(etudiant.getNom() + " is not part of the class.");
            }
        } else {
            System.out.println(enseignant.getNom() + " is not teaching " + matiere.getNom() + " in this class.");
        }
    }


    public Classe(String className) {
        this.className = className;
        this.students = new ArrayList<>();
        this.matieres = new HashMap<>();
        this.notes = new HashMap<>();

    }

    public void addStudentToClass(Etudiant student) {
        if (students.size() >= maxStudents) {
            System.out.println("Class is full. Cannot add more students.");
        } else {
            students.add(student);
            student.setClasse(this); // Ajout de la classe à l'étudiant
            System.out.println(student.getNom() + " added to " + className);
        }
    }


   
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Etudiant> getStudents() {
        return students;
    }

    public void setStudents(List<Etudiant> students) {
        this.students = students;
    }
    public void addMatiereToClass(Matiere matiere, Enseignant enseignant) {
        boolean subjectExists = matieres.keySet().stream()
                .anyMatch(existingMatiere -> existingMatiere.getNom().equals(matiere.getNom()));

        if (subjectExists) {
            System.out.println("A subject with the name '" + matiere.getNom() + "' already exists in the class.");
        } else {
            this.matieres.put(matiere, enseignant);
            System.out.println("Added " + matiere.getNom() + " to " + className + " taught by " + enseignant.getNom());
        }
    }

    public Matiere getMatiereByName(String matiereName) {
        for (Matiere matiere : matieres.keySet()) {
            if (matiere.getNom().equals(matiereName)) {
                return matiere;
            }
        }
        return null; // Return null if the Matiere is not found
    }

    
    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public Map<Matiere, Enseignant> getMatieres() {
        return matieres;
    }

    public void setMatieres(Map<Matiere, Enseignant> matieres) {
        this.matieres = matieres;
    }

}


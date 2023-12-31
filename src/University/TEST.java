package University ;
import java.util.Scanner;

public class TEST{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonnelAdministratif admin = new PersonnelAdministratif("John", "Doe", "123 Main St", "john@example.com", "1234567890", "ADM001", "Administration", "9 AM - 5 PM");

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addClass(scanner, admin);

                    break;
                case 2:
                	addStudent(scanner, admin);

                    break;
                case 3:
                	addTeacher(scanner, admin);

                    break;
                case 4:
                    addNote(scanner, admin);

                case 5:
                    admin.afficherToutesLesClasses();

                    break;
                case 6:
                	displayStudentDetails(admin);

                    break;
                case 7:
                	displayTeacherDetails(admin);

                    break;
                case 8:
                	admin.afficherDetails();

                    break;
                case 9:
                	 System.out.println("Exiting the program...");
                     scanner.close();
                     System.exit(0);
                     
                    break;
                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("University Menu:");
        System.out.println("1. Add Class");
        System.out.println("2. Assign Student to Class");
        System.out.println("3. Assign Teacher to Subject");
        System.out.println("4. Add Notes");
        System.out.println("5. Display Classes Details");
        System.out.println("6. Display Student Details");
        System.out.println("7. Display Teacher Details");
        System.out.println("8. Display administration details ");

        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent(Scanner scanner, PersonnelAdministratif admin) {
        System.out.println("Enter student details:");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Student ID: ");
        String studentID = scanner.nextLine();
        System.out.println("Student's Class:");
        String Sclass=scanner.nextLine();
        Classe c1 =admin.findClassByName(Sclass);
     // Create a student object with the provided details
        Etudiant student = new Etudiant(firstName, lastName, address, email, phoneNumber, studentID);
        
        if (c1!=null)
        	{c1.addStudentToClass(student);
            System.out.println("Student added successfully!");
        	
        	}
        else 
        	System.out.println("Quitting.....");
        

    }
    private static void addTeacher(Scanner scanner, PersonnelAdministratif admin) {
        System.out.println("Enter teacher details:");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Teacher ID: ");
        String teacherID = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Weekly Schedule: ");
        String weeklySchedule = scanner.nextLine();
        System.out.print("Office: ");
        String office = scanner.nextLine();
        System.out.print("Department: ");
        String department = scanner.nextLine();

        Enseignant teacher = new Enseignant(firstName, lastName, address, email, phoneNumber, teacherID, type, weeklySchedule, office, department);
        System.out.println("Teacher's Class:");
        String Sclass=scanner.nextLine();
        Classe c1 =admin.findClassByName(Sclass);
        if (c1!=null)
    	{
            System.out.println("Teacher's Course:");
            String Scourse=scanner.nextLine();
            System.out.println("Course Horaire:");

            String Hor=scanner.nextLine();
            System.out.println("Departement:");

            String Dep=scanner.nextLine();
            Matiere course = new Matiere (Scourse , Hor,Dep);
            admin.addTeacherToMatiere(teacher, course, c1);
            System.out.println("Teacher added successfully!");


    	}
    else 
    	System.out.println("Quitting.....");
        
    }

    private static void addClass(Scanner scanner, PersonnelAdministratif admin) {
        System.out.println("Enter class details:");
        System.out.print("Class Name: ");
        String className = scanner.nextLine();

        Classe newClass = new Classe(className);

        admin.getClasses().add(newClass);
        System.out.println("Class added successfully!");
    }


    
    private static void addNote(Scanner scanner, PersonnelAdministratif admin) {
        System.out.println("Enter the class name:");
        String className = scanner.nextLine();

        // Recherche de la classe par son nom
        Classe targetClass = admin.findClassByName(className);

        if (targetClass != null) {
            System.out.println("Enter the student's name:");
            String studentName = scanner.nextLine();

            System.out.println("Enter the teacher's name:");
            String teacherName = scanner.nextLine();

            System.out.println("Enter the subject:");
            String subjectName = scanner.nextLine();

            System.out.println("Enter the new note:");
            double newNote = scanner.nextDouble();

            scanner.nextLine(); // Pour consommer la nouvelle ligne restante

            // Récupérer l'étudiant et le professeur par leur nom
            Etudiant student = null;
            for (Etudiant s : targetClass.getStudents()) {
                if (s.getNom().equals(studentName)) {
                    student = s;
                    break;
                }
            }

            Enseignant teacher = null;
            for (Classe classe : admin.getClasses()) {
                for (Enseignant t : classe.getTeachers()) {
                    if (t.getNom().equals(teacherName)) {
                        teacher = t;
                        break;
                    }
                }
                if (teacher != null) {
                    break;
                }
            }

            if (student != null && teacher != null) {
                Matiere matiere = targetClass.getMatiereByName(subjectName);
                if (matiere != null) {
                    teacher.addNoteToStudent(targetClass, student, newNote, matiere);
                } else {
                    System.out.println("Subject not found in the class.");
                }
            } else {
                System.out.println("Student or teacher not found.");
            }
        } else {
            System.out.println("Class not found.");
        }
    }

    public static void displayStudentDetails(PersonnelAdministratif admin) {
        boolean found = false;
        Scanner scanner= new Scanner(System.in);
        System.out.print("Student name: ");
        String Sname = scanner.nextLine();
        System.out.print("Student last name: ");
        String Slast = scanner.nextLine();
        for (Classe classe : admin.getClasses()) {
            for (Etudiant student : classe.getStudents()) {
                if ((student.getNom().equalsIgnoreCase(Sname))&& (student.getPrenom().equalsIgnoreCase(Slast))){
                    student.afficherDetails();
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Student with the name '" + Sname+" "+Slast + "' not found.");
        }
    }
    public static void displayTeacherDetails(PersonnelAdministratif admin) {
        boolean found = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Teacher name: ");
        String Tname = scanner.nextLine();
        System.out.print("Teacher last name: ");
        String Tlast = scanner.nextLine();

        for (Classe classe : admin.getClasses()) {
            for (Enseignant teacher : classe.getTeachers()) {
                if ((teacher.getNom().equalsIgnoreCase(Tname)) && (teacher.getPrenom().equalsIgnoreCase(Tlast))) {
                    teacher.afficherDetails();
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Teacher with the name '" + Tname + " " + Tlast + "' not found.");
        }
    }

}

	

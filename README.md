# University Management System

The University Management System facilitates managing classes, students, teachers, and administrative details within a university setting.

## Features

- **Adding Class:**
  - Use option 1 to add a class.

- **Assigning Student to Class:**
  - Use option 2 to assign a student to a class.

- **Assigning Teacher to Subject:**
  - Use option 3 to assign a teacher to a subject.

- **Adding Notes:**
  - Use option 4 to add notes for students in specific classes and subjects.

- **Displaying Classes Details:**
  - Use option 5 to view detailed information about classes.

- **Displaying Student Details:**
  - Use option 6 to view detailed information about a specific student.

- **Displaying Teacher Details:**
  - Use option 7 to view detailed information about a specific teacher.

- **Displaying Administration Details:**
  - Use option 8 to view detailed administrative information.

- **Exiting the Program:**
  - Use option 9 to exit the program.

## Usage

- **Adding Class:**
  - Enter the class name to add a new class.

- **Assigning Student to Class:**
  - Provide student details (First Name, Last Name, Address, Email, Phone Number, Student ID, and Student's Class).

- **Assigning Teacher to Subject:**
  - Provide teacher details (First Name, Last Name, Address, Email, Phone Number, Teacher ID, Type, Weekly Schedule, Office, and Department), along with the teacher's course details.

- **Adding Notes:**
  - Enter the class name, student's name, teacher's name, subject, and the new note to add notes for a student.

- **Displaying Student Details:**
  - Enter the student's name and last name to view detailed information about the student.

- **Displaying Teacher Details:**
  - Enter the teacher's name and last name to view detailed information about the teacher.

- **Displaying Administration Details:**
  - View administrative details.

## Structure

The system is built on Object-Oriented Programming principles and uses the following classes:

- **Personnel:**
  - Represents a generic personnel entity.

- **Etudiant:**
  - Represents a student with details such as name, address, email, and student ID.

- **Enseignant:**
  - Represents a teacher with details such as name, contact information, teaching type, schedule, office, and department.

- **PersonnelAdministratif:**
  - Represents administrative personnel with details like department and working hours.

- **Matiere:**
  - Represents a subject/course with name, schedule, and department.

- **Classe:**
  - Represents a class/course with a list of students, teachers, and subjects.

## Implementation

The main file `TEST.java` serves as the entry point of the University Management System, handling user input and processing through various options available.

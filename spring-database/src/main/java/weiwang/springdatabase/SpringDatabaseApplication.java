package weiwang.springdatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import weiwang.springdatabase.dao.StudentDAO;
import weiwang.springdatabase.entity.Student;

import java.util.List;

@SpringBootApplication
public class SpringDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// creatMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudent(studentDAO);
			// queryForStudentByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleting row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on  the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		// change first name
		System.out.println("Updating student ...");
		myStudent.setFirstName("Wei");
		// update the student
		studentDAO.update(myStudent);
		// display the update student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Wang");
		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();
		//display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// creat a student object
		System.out.println("Creating new student object ... ");
		Student tempStudent = new Student("Linabell", "Fox", "linabell@ww.com");
		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Save student . Generated id: " + theId);
		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		// display student
		System.out.println("Found the student:" + myStudent);
	}

	private void creatMultipleStudents(StudentDAO studentDAO) {
		//create multiple student objects
		System.out.println("Creating 3 student objects ...");
		Student student1 = new Student("John", "Doe", "john@ww.com");
		Student student2 = new Student("Paopao", "Wang", "paopao@ww.com");
		Student student3 = new Student("Bubble", "Wang", "bubble@ww.com");
		//save the student objects
		System.out.println("Saving the students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//creat the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@ww.com");
		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("Save student. Generated id: " + tempStudent.getId());
	}

}

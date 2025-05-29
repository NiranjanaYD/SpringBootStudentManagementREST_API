package in.Niranjana.SpringBoot.StudentRestApi.Controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.Niranjana.SpringBoot.StudentRestApi.Repository.StudentRepository;
import in.Niranjana.SpringBoot.StudentRestApi.entity.StudentData;

@RestController
public class StudentController {
	
	
	@Autowired
	StudentRepository repo;
	
	//Get All The Students 
	//localhost:8080/students
	
	@GetMapping("/students")
	public List<StudentData> getAllStudents(){
		List<StudentData> students=repo.findAll();
		
		return students;
		
	}
	
	
	//localhost:8080/students1
	// We have to Get a student RollNumber
	
	@GetMapping("/students/{rollNo}")
	public StudentData getStudent(@PathVariable int rollNo) {
	StudentData student	=repo.findById(rollNo).get();
	
	return student;
	}
	
	//localhost:8080/students/Register
	// Create or Add  a New Student Detailes 
	@PostMapping("/students/Register")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void registerStudent(@RequestBody StudentData student) {
		repo.save(student);
		
	}
	
	@PutMapping("/students/Update/{rollNo}")
	public StudentData updateStudent(@PathVariable int rollNo ) {
		StudentData student = repo.findById(rollNo).get();
		student.setName("Pavanaa");
		student.setPercentage(89);
		student.setBranch("CyberSecurity");
		student.setEmail("pavana@gmail.com");
		student.setCourse("Be.Tech");
		repo.save(student);
		return student;
	}
	
	@DeleteMapping("/students/delete/{rollNo}")
	public void removeStudent(@PathVariable int rollNo) {
		StudentData student=repo.findById(rollNo).get();
		repo.delete(student);
	}
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	
	

}
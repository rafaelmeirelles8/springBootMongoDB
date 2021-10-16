package com.example.springmongodb;

import com.example.springmongodb.common.Gender;
import com.example.springmongodb.entity.Address.Address;
import com.example.springmongodb.entity.Student.Student;
import com.example.springmongodb.repository.address.AddressRepository;
import com.example.springmongodb.repository.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbApplication.class, args);
	}

	/*@Bean
	CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address(
				"England",
				"London",
				"V5R6C5"
			);

			String email = "rafaelM@gmail.com";
			Student student = new Student("Rafael",
					"Meirelles",
					email,
					Gender.MALE,
					address,
					List.of("Computer Science", "Computer Engineer"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);
			//usingMongoTemplateAndQuery(studentRepository, mongoTemplate, email, student);

			studentRepository.findStudentByEmailEquals(email)
					.ifPresentOrElse(s -> System.out.println(student + " already exist!"),
					() -> {
						System.out.println("Inserting student " + student);
						studentRepository.insert(student);
					});

		};

	}*/

	private void usingMongoTemplateAndQuery(StudentRepository studentRepository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<Student> students = mongoTemplate.find(query, Student.class);

		if(students.size() > 1){
			throw new IllegalStateException(String.format("Found many students with email %s", email));
		}

		if(students.isEmpty()){
			System.out.println("Inserting student " + student);
			studentRepository.insert(student);
		}
		else{
			System.out.println(student + " already exist!");
		}
	}

}

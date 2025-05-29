package in.Niranjana.SpringBoot.StudentRestApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.Niranjana.SpringBoot.StudentRestApi.entity.StudentData;

public interface StudentRepository extends JpaRepository<StudentData,Integer>{

}

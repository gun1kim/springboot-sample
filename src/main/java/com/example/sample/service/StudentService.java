package com.example.sample.service;

import com.example.sample.domain.Score;
import com.example.sample.domain.Student;
import com.example.sample.domain.StudentInquiryDto;
import com.example.sample.repository.ScoreJpaRepository;
import com.example.sample.repository.ScoreRepository;
import com.example.sample.repository.StudentJpaRepository;
import com.example.sample.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    private final StudentJpaRepository studentRepository;
    private final ScoreJpaRepository scoreRepository;

    public StudentService(StudentJpaRepository studentRepository, ScoreJpaRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Student getStudentInfo(int id){
        return studentRepository.findById(id).get();
    }

    public void updateStudent(int id){
        Student findStudent = studentRepository.findById(id).get();
        Score findScore = scoreRepository.findById(id).get();
        float resScore = (findStudent.getPoint() + findScore.getSPoint())/2.0f;
        findStudent.setPoint(resScore);
        studentRepository.save(findStudent);
    }

    public Student addNewStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
//
//    public List<Student> getStudentInquiry(StudentInquiryDto studentInquiryDto) {
//        return studentRepository.findByInquiryDto(studentInquiryDto);
//    }
}

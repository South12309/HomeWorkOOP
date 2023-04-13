package ru.gb.sobes.lesson_7_spring.services;

import org.springframework.stereotype.Service;
import ru.gb.sobes.lesson_7_spring.entityes.Student;
import ru.gb.sobes.lesson_7_spring.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(Student student) {
        return studentRepository.save(student);
    }
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public void delete(int id) {
        studentRepository.deleteById(id);
    }

    public Optional<Student> get(int id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}

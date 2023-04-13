package ru.gb.sobes.lesson_7_spring.controllers;

import org.springframework.web.bind.annotation.*;
import ru.gb.sobes.lesson_7_spring.convertors.StudentConvertor;
import ru.gb.sobes.lesson_7_spring.dtos.StudentDto;
import ru.gb.sobes.lesson_7_spring.entityes.Student;
import ru.gb.sobes.lesson_7_spring.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentConvertor studentConvertor;

    public StudentController(StudentService studentService, StudentConvertor studentConvertor) {
        this.studentService = studentService;
        this.studentConvertor = studentConvertor;
    }

    @GetMapping
    public List<Student> getALL() {
        return studentService.getAll();
    }
    @GetMapping("/{id}")
    public StudentDto getALL(@PathVariable int id) {
        return studentConvertor.entityToDto(studentService.get(id).orElseThrow());
    }
    @PostMapping()
    public StudentDto add(@RequestParam StudentDto studentDto) {
        return studentConvertor.entityToDto(studentService.add(studentConvertor.dtoToEntity(studentDto)));
    }
    @PostMapping()
    public StudentDto update(@RequestParam StudentDto studentDto) {
        return studentConvertor.entityToDto(studentService.add(studentConvertor.dtoToEntity(studentDto)));
    }

}

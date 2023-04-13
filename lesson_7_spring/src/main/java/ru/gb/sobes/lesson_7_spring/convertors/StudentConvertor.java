package ru.gb.sobes.lesson_7_spring.convertors;

import org.springframework.stereotype.Component;
import ru.gb.sobes.lesson_7_spring.dtos.StudentDto;
import ru.gb.sobes.lesson_7_spring.entityes.Student;
@Component
public class StudentConvertor {
    public Student dtoToEntity(StudentDto studentDto){
        return new Student(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getAge()
        );
    }

    public StudentDto entityToDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getAge()
        );
    }
}

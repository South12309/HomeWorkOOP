package ru.gb.sobes.lesson_7_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.sobes.lesson_7_spring.entityes.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}

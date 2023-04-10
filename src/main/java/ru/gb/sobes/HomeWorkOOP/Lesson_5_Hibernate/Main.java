package ru.gb.sobes.HomeWorkOOP.Lesson_5_Hibernate;

import org.hibernate.Session;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO(SessionFactoryUtil.getSessionFactory());
        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.setName("Student " + i);
            student.setMark((int) (Math.random() * 100));
            studentDAO.add(student);
        }
        Student studentForDelete = studentDAO.getById(10);
        System.out.println("get student with id " + studentForDelete.getId());
        studentDAO.delete(studentForDelete);
        System.out.println("Delete student in DB with id " + studentForDelete.getId());
        Student studentForUpdate = studentDAO.getById(11);
        System.out.println("get student for update with id " + studentForUpdate.getId());
        studentForUpdate.setName("UpdateStudent");
        System.out.println("Update student with id " + studentForUpdate.getId());
        studentDAO.update(studentForUpdate);
        System.out.println("Update student in DB with id " + studentForUpdate.getId());
        List<Student> studentList = studentDAO.getAll();
        for (Student student : studentList) {
            System.out.println(student);
        }

    }


}

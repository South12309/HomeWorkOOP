package ru.gb.sobes.HomeWorkOOP.Lesson_5_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;


import java.util.List;

public class StudentDAO {
    private final SessionFactory sessionFactory;

    public StudentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Student getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student=null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            student = (Student) session.get(Student.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> students = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            students = session.createQuery("FROM Student").list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return students;
    }
}

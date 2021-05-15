package com.example.studentapi;

public interface StudentRepository {

    void save(Student student);
    Student get(String id) throws Exception;
    Student remove(String id) throws Exception;
    void update(Student student, String id) throws Exception;
}

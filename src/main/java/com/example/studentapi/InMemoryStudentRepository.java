package com.example.studentapi;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStudentRepository implements StudentRepository {

    Map<String,Student> database = new HashMap<>();

    @Override
    public void save(Student student) {
        database.put(student.id, student);

    }

    @Override
    public Student get(String id) throws Exception{

        return database.get(id);
    }

    @Override
    public Student remove(String id) throws Exception {
        return database.remove(id);
    }

    @Override
    public void update(Student student ,String id) throws Exception {
        database.get(id).setName(student.getName());
        database.get(id).setAge(student.getAge());
        database.get(id).setTeL(student.getTel());
    }
}

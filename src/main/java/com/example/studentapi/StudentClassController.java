package com.example.studentapi;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentClassController {

    StudentRepository repository  = new InMemoryStudentRepository();
//add
    @PostMapping("/student")
    public void createStudent(@RequestBody Student student){

        repository.save(student);

        System.out.println("name :" + student.getName());
        System.out.println("age  :" + student.getAge());
        System.out.println("telephone number :" + student.getTel());
    }
//get
    @GetMapping("/student/{id}")
    public  Student getStudent(@PathVariable String id){

        try {
        Student student =  repository.get(id);
        System.out.println("got name :" + student.getName());
        System.out.println("got age  :" + student.getAge());
        System.out.println("got telephone number :" + student.getTel());
        return student;
        }catch (NullPointerException e){

            System.out.println("No student available by this id");

        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

//    delete
    @DeleteMapping("/student/remove/{id}")
    public  Student removeStudent(@PathVariable String id){


        try {
            Student student =  repository.remove(id);
            System.out.println("Remove name :" + student.getName());
            System.out.println("Remove age  :" + student.getAge());
            System.out.println("Remove telephone number :" + student.getTel());
            return student;

        }catch (NullPointerException e){
            System.out.println("No student available by this id");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

//    update

    @PostMapping("/student/update")
    public void updateStudent(@RequestBody Student student){



        try {


            repository.update(student, student.getId());

            System.out.println("updated :" + student.getName());
            System.out.println("updated Age  :" + student.getAge());
            System.out.println("updated number :" + student.getTel());

        }catch (NullPointerException e){
            System.out.println("No student available by this id");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

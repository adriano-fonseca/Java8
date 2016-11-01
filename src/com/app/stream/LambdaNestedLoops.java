package com.app.stream;

import java.util.ArrayList;
import java.util.List;

import com.app.model.GroupClass;
import com.app.model.Student;

public class LambdaNestedLoops {

  public static void main(String[] args) {
    
    Student a1 = new Student("Adriano");
    a1.getGrades().add(10);
    a1.getGrades().add(10);
    a1.getGrades().add(10);
    
    Student a2 = new Student("Antonio");
    a2.getGrades().add(5);
    a2.getGrades().add(5);
    a2.getGrades().add(5);
    
    Student a3 = new Student("Marcelo");
    a2.getGrades().add(6);
    a2.getGrades().add(6);
    a2.getGrades().add(6);
    
    List<Student> list = new ArrayList<Student>();
    list.add(a2);
    list.add(a1);
    
    List<Student> list2 = new ArrayList<Student>();
    list2.add(a2);
    list2.add(a3);
    
    GroupClass g1 = new GroupClass();
    g1.setName("C1");
    g1.setStudents(list);
    
    GroupClass g2 = new GroupClass();
    g2.setName("C2");
    g2.setStudents(list2);
    
    List<GroupClass> listGroups = new ArrayList<GroupClass>();
    listGroups.add(g1);
    listGroups.add(g2);
    printInfo(listGroups);
  }

  public static void printInfo(List<GroupClass> listGroup){
    listGroup.stream().forEach(group -> {
      group.getStudents().stream().forEach(student -> {
      student.getGrades().stream().filter(nota -> nota <= 10).forEach(nota -> {
        System.out.printf("student %-20s group %-20s grade %-20s\n", student.getName(), group.getName(), nota);
        });
    });
  });
  }

}

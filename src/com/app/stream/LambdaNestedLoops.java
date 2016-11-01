package com.app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    Student a3 = new Student("Marcelo");
    a3.getGrades().add(6);
    a3.getGrades().add(6);

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
    returnGroupsFilter(listGroups);
  }

  public static void printInfo(List<GroupClass> listGroup) {
    listGroup.stream().forEach(group -> {
      group.getStudents().stream().filter(student -> student.getGrades().size() == 2).forEach(student -> {
        student.getGrades().stream().filter(nota -> nota <= 6).forEach(nota -> {
          System.out.printf("The student %-20s group %-20s total grade %-20s\n", student.getName(), group.getName(), nota);
        });
      });
    });
  }
  
  public static void returnGroupsFilter(List<GroupClass> listGroup){
    List<GroupClass> groups = listGroup.stream().filter(group -> group.getStudents().size()>=2).collect(Collectors.toList());
    
    //Filtering Group rest 2 groups each one with 2 Students, it was needed to to flatmap to collect these students
    List<Student> studentsList = listGroup.stream().filter(group -> group.getStudents().size()>=2)
        .map(group -> group.getStudents())
        .flatMap(student -> student.stream()).collect(Collectors.toList());
    
    System.out.println(groups.size());
    System.out.println(studentsList.size());
  }

}

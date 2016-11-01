package com.app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.app.model.Student;

public class LambdaMapFlatMapTest {

  public static void main(String args[]) {
    Student a1 = new Student("Adriano");
    a1.getGrades().add(10);
    a1.getGrades().add(10);
    a1.getGrades().add(10);
    
    Student a2 = new Student("Adriano");
    a2.getGrades().add(5);
    a2.getGrades().add(5);
    a2.getGrades().add(5);
    
    List<Student> list = new ArrayList<Student>();
    list.add(a2);
    list.add(a1);
    retornaNotasTodosAlunos(list);
    
  }
  
  static List<Integer> retornaNotasTodosAlunos(List<Student> lista) {
    List<Integer> listaNotasTodosAluno = lista.stream().map(aluno -> aluno.getGrades()). flatMap(notas -> notas.stream()). collect(Collectors.toList());
    System.out.println(listaNotasTodosAluno.stream().reduce(0, (x,y) -> x+y));
    return listaNotasTodosAluno;
  }
}

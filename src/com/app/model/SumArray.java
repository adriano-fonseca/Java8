package com.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumArray {
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
//    retornaNotasTodosAlunos(list);
    System.out.println(sumNotas2(a2));
  }

  static int sumNotas(Student a) {
    int sum = a.getGrades().stream().filter(i -> {
      if(i > 5){
        return true;
      }else{
        return false;
      }
    }).reduce(0, (c, e) -> c + e)/a.getGrades().size();
    
    return sum;
  }
  
  static int sumNotas2(Student a) {
    Function<Integer, Integer> bonus = new Function<Integer, Integer>() {

      @Override
      public Integer apply(Integer t) {
        if(t <= 5){
          t=t+2;
        }
        return t;
      }
    };
    
    int sum = a.getGrades().parallelStream().map(bonus).reduce(0, (c,e) -> c + e);
    
    return sum;
  }
  
  static List<Integer> retornaNotasTodosAlunos(List<Student> lista) {
    List<Integer> listaNotasTodosAluno = lista.stream().map(aluno -> aluno.getGrades()).flatMap(notas -> notas.stream()). collect(Collectors.toList());
    System.out.println(listaNotasTodosAluno.stream().reduce(0, (x,y) -> x+y));
    return listaNotasTodosAluno;
  }
}



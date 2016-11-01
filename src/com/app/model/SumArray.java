package com.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumArray {
  public static void main(String args[]) {
    Aluno a1 = new Aluno("Adriano");
    a1.getNotas().add(10);
    a1.getNotas().add(10);
    a1.getNotas().add(10);
    
    Aluno a2 = new Aluno("Adriano");
    a2.getNotas().add(5);
    a2.getNotas().add(5);
    a2.getNotas().add(5);
    
    List<Aluno> list = new ArrayList<Aluno>();
    list.add(a2);
    list.add(a1);
//    retornaNotasTodosAlunos(list);
    System.out.println(sumNotas2(a2));
  }

  static int sumNotas(Aluno a) {
    int sum = a.getNotas().stream().filter(i -> {
      if(i > 5){
        return true;
      }else{
        return false;
      }
    }).reduce(0, (c, e) -> c + e)/a.getNotas().size();
    
    return sum;
  }
  
  static int sumNotas2(Aluno a) {
    Function<Integer, Integer> bonus = new Function<Integer, Integer>() {

      @Override
      public Integer apply(Integer t) {
        if(t <= 5){
          t=t+2;
        }
        return t;
      }
    };
    
    int sum = a.getNotas().parallelStream().map(bonus).reduce(0, (c,e) -> c + e);
    
    return sum;
  }
  
  static List<Integer> retornaNotasTodosAlunos(List<Aluno> lista) {
    List<Integer> listaNotasTodosAluno = lista.stream().map(aluno -> aluno.getNotas()).flatMap(notas -> notas.stream()). collect(Collectors.toList());
    System.out.println(listaNotasTodosAluno.stream().reduce(0, (x,y) -> x+y));
    return listaNotasTodosAluno;
  }
}



package com.app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.app.model.Aluno;

public class LambdaMapFlatMapTest {

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
    retornaNotasTodosAlunos(list);
    
  }
  
  static List<Integer> retornaNotasTodosAlunos(List<Aluno> lista) {
    List<Integer> listaNotasTodosAluno = lista.stream().map(aluno -> aluno.getNotas()). flatMap(notas -> notas.stream()). collect(Collectors.toList());
    System.out.println(listaNotasTodosAluno.stream().reduce(0, (x,y) -> x+y));
    return listaNotasTodosAluno;
  }
}

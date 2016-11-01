package com.app.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

  public Aluno(String nome) {
    super();
    this.nome = nome;
  }

  private String nome;

  private List<Integer> notas = new ArrayList<Integer>();

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Integer> getNotas() {
    return notas;
  }

  public void setNotas(List<Integer> notas) {
    this.notas = notas;
  }
}
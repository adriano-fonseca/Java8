package com.app.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

  public Student(String nome) {
    super();
    this.name = nome;
  }

  private String name;

  private List<Integer> grades = new ArrayList<Integer>();

  public String getName() {
    return name;
  }

  public void setName(String nome) {
    this.name = nome;
  }

  public List<Integer> getGrades() {
    return grades;
  }

  public void setGrades(List<Integer> notas) {
    this.grades = notas;
  }
}
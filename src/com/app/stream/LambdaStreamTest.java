package com.app.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaStreamTest {
  
  public static void main(String[] args){
  List<Integer> lista = new ArrayList<>();
  
  //Create a list 0 to 4
  for(int x=0; x<5; x++){
    lista.add(x);
  }
  
  //Create a list 0 to 5 with array function
  List<Integer> listaLambda = Arrays.asList(0,1,2,3,4);
  
  
  //Using Stream 
  System.out.println("Lista");
  Stream<Integer> s = lista.stream();
  //Creating a strem from data
  s.forEach(System.out::println);

//  System.out.println("Lista Second");
//  s.forEach(System.out::println); // Exeption is thrown
//  You cannot use the stream multiple times

//  Your data its preserved in Lista you can create another strem to it
//  The stream goal is data manipulation
  

//  It does not work because filter it is a intermediate function 
//  listaLambda.stream().filter(i -> {
//        System.out.println(i);
//        return true;
//        });
  System.out.println("Filter First");
  lista.stream().filter(i -> {
            System.out.println("The first is "+i);
            return true;
            }).findFirst();

  
  //Using multi-threading distributed by cores
  System.out.println("Paralel Stream");
  lista.parallelStream().forEach(System.out::println);
  }

}

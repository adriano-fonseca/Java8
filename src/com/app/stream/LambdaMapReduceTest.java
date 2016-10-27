package com.app.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import com.app.lambda.FunctionSquareRoot;

public class LambdaMapReduceTest {
  
  public static void main(String[] args){
    List<Integer> listaNumber = Arrays.asList(1,2,3,4,5,6);
    List<Integer> listaToReduce = Arrays.asList(1,2,3,4);
    
//    listaNumber.stream().map(i -> i*i).forEach(i -> System.out.println(i));
    
    
    //Defining map function
     FunctionSquareRoot function = new FunctionSquareRoot(); 
     
     BinaryOperator<Integer> bo = new BinaryOperator<Integer>() {
      @Override
      public Integer apply(Integer t, Integer u) {
        return t+u;
      }
    };
    
    
//    listaNumber.stream().map(i -> i*i).forEach(i -> System.out.println(i));
//      listaNumber.stream().map(function).forEach(i -> System.out.println(i));
    
    //function contains definition to squareRoot
    Stream ds = listaNumber.stream().map(function);
//    ds.forEach(System.out::println);
    Integer sum = listaToReduce.stream().map(function).reduce(0,bo);
    System.out.println(sum);
  }


  //Without Lamda
  //listaNumber.stream().map(i -> i*i).forEach(i -> System.out.println(i));
  private static void printSquareRoot(List<Integer> listaNumber) {
    for(Integer i : listaNumber){
      System.out.println(i*i);
    }
  }

}

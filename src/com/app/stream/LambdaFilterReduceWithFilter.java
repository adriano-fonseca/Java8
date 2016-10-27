package com.app.stream;

import java.util.Arrays;
import java.util.List;

public class LambdaFilterReduceWithFilter {
  
  public static void main(String args[]){
    List<Integer> listaNumber = Arrays.asList(5,10,3,4,5,20); //sum of divisible by 5 is 40
    
    //Usind the predicated by lambda
    Integer result = listaNumber.parallelStream()
        .filter(i -> i%5 == 0)
        .reduce(0, (c,e) -> c+e);
    System.out.println(result);
    
    //Usind the predicated define above
    Integer result2 = listaNumber.parallelStream()
        .filter(LambdaFilterReduceWithFilter::divisibleByFive).
        reduce(0, (c,e) -> c+e);
    System.out.println(result2);
    
    //Using Filter and map reduce
    Integer result3 = listaNumber.parallelStream()
        .filter(i -> i%5 == 0)
        .map(i -> i * 2)
        .reduce(0, (c,e) -> c+e);
    System.out.println(result3);
    
    Integer result4 = listaNumber.parallelStream()
        .filter(LambdaFilterReduceWithFilter::divisibleByFive)
        .map(LambdaFilterReduceWithFilter::mapDouble)
        .findFirst()
        .orElse(0);
    System.out.println("The first is "+result4);
  }
  
  public static Integer mapDouble(Integer i){
    return i * 2;
  }
  
  public  static boolean divisibleByFive(Integer i){
    return i%5==0;
  }
  
}

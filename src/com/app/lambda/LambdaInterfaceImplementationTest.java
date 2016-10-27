package com.app.lambda;

public class LambdaInterfaceImplementationTest {
  
  public static void main(String[] args){
    
    //Anonymous Inner Class
//    Printer p = new Printer() {
//      public void print(String msg){
//        System.out.println(msg);
//      }
//    };
//    p.print("Hey You");
//  }
  
 //Anonymous Inner Class and Lambda Expression are quite Similar
  // Removing 
 //     new Printer() {
 //  public void print
 //  And adding after Parameter passing
 //   ->
    
//  Printer pw = (String msg) -> {
//      System.out.println(msg);
//  };
    
    //Anonymous Inner Class and Lambda Expression are quite Similar
    Printer pw = (String name) -> System.out.println("Hello "+name);
//    { just one line dont required curly brackets
//      System.out.println(msg);
//    }
    
    //As shorter as possible
    //Because void print(String msg) has the type definition
    Printer pw2 = name -> System.out.println("Hello "+name); //Lambda Expression
    
    //name -> System.out.println("Hello "+name) (its Always a implementarion 
    //from some interface. The consumer Interface
    
    
    pw.print("Adriano");
    pw2.print("Fonseca");
  }

  
  
}

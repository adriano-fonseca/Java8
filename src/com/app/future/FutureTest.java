package com.app.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class FutureTest {

    private static final ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void teste(long start) throws InterruptedException, ExecutionException{
      
      CompletableFuture<String> f1 =  CompletableFuture.supplyAsync(new Supplier<String>() {
        @Override
        public String get(){
          //...long running... 
          try {
            System.out.println("passou f1 em "+ System.nanoTime()/1.0E9);
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          return "10";
        }
      }, pool); 
      
      CompletableFuture<String> f2 =  CompletableFuture.supplyAsync(new Supplier<String>() {
        @Override
        public String get(){
          //...long running... 
          try {
            dormeBebe();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          return "10";
        }

      private void dormeBebe() throws InterruptedException {
        System.out.println("passou f2 em " + System.nanoTime()/1.0E9);
        Thread.sleep(2000);
      }
      }, pool);
      
      CompletableFuture<String> f3 =  CompletableFuture.supplyAsync(new Supplier<String>() {
        @Override
        public String get(){
          //...long running... 
          try {
            dormeBebe();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          return "10";
        }

      private void dormeBebe() throws InterruptedException {
        System.out.println("passou f3 em " + System.nanoTime()/1.0E9);
        Thread.sleep(2000);
      }
      }, pool);
      
      CompletableFuture<String> f4 =  CompletableFuture.supplyAsync(new Supplier<String>() {
        @Override
        public String get(){
          //...long running... 
          try {
            dormeBebe();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          return "10";
        }

      private void dormeBebe() throws InterruptedException {
        System.out.println("passou f4 em " + System.nanoTime()/1.0E9);
        Thread.sleep(2000);
      }
      }, pool);
      
      CompletableFuture<String> f5 =  CompletableFuture.supplyAsync(new Supplier<String>() {
        @Override
        public String get(){
          //...long running... 
          try {
            dormeBebe();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          return "10";
        }

      private void dormeBebe() throws InterruptedException {
        System.out.println("passou f5 em " + System.nanoTime()/1.0E9);
        Thread.sleep(2000);
      }
      }, pool);
    

      CompletableFuture<Integer> fx1 = f1.thenApply(Integer::parseInt);
      CompletableFuture<Integer> fx2 = f2.thenApply(Integer::parseInt);
      CompletableFuture<Integer> fx3 = f3.thenApply(Integer::parseInt);
      CompletableFuture<Integer> fx4 = f4.thenApply(Integer::parseInt);
      CompletableFuture<Integer> fx5 = f5.thenApply(Integer::parseInt);
      
      
//      CompletableFuture<Integer> f5 = f3.thenApply(r -> r + 10);
      //    getData(0, 5000);
      //Future<String> result = pool.submit((Callable<T>) f3);
//      System.out.println(fx3.get());
      
      pool.shutdown();
    }
    
    
    public static void main(String[] args) throws InterruptedException, ExecutionException, Exception {
      long start = System.nanoTime();
      teste(start);
      long end = System.nanoTime();
      System.out.println("Tempo decorrido (segundos) = " + ((end - start)/1.0E9));
    }
}
package com.app.lambda;

import java.util.function.Function;

public class FunctionSquareRoot implements Function<Integer, Integer> {
  public Integer apply(Integer t) {
    t = t * t;
    return t;
  }

}

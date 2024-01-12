package com.lucas.generic;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-06-04 16:40
 */
public class Food {
  public String idFood;

  public Food() {
  }

  public Food(String idFood) {
    this.idFood = idFood;
  }

  @Override
  public String toString() {
    return "Food{" +
        "id='" + idFood + '\'' +
        '}';
  }
}

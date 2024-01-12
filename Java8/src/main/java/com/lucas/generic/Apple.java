package com.lucas.generic;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-06-04 16:41
 */
public class Apple extends Fruit {
  public String idApple;

  public Apple() {
  }

  public Apple(String idApple) {
    this.idApple = idApple;
  }

  @Override
  public String toString() {
    return "Apple{" +
        "idApple='" + idApple + '\'' +
        '}';
  }
}

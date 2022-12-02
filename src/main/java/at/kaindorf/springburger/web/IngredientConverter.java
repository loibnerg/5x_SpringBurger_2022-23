package at.kaindorf.springburger.web;

import at.kaindorf.springburger.pojos.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: SpringBurgerDemo
 * Created by: SF
 * Date: 01.12.2022
 * Time: 11:43
 */
@Component
public class IngredientConverter implements Converter<String[], List<Ingredient>> {

  @Override
  public List<Ingredient> convert(String[] source) {
    List<Ingredient> ingredientList = new ArrayList<>();
    for (String ingAsStr : (String[]) source) {
      Ingredient ingredient = BurgerController.getIngredientMap().values().stream()
          .flatMap(l -> l.stream())
          .filter(i -> i.getName().equals(ingAsStr))
          .findFirst()
          .get();
      ingredientList.add(ingredient);
    }
    return ingredientList;
  }
}

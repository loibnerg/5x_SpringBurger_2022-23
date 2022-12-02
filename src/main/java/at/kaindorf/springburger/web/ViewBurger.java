package at.kaindorf.springburger.web;

import at.kaindorf.springburger.pojos.Burger;
import at.kaindorf.springburger.pojos.Ingredient;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewBurger {

  private String name;
  private List<String> ingredients;

  public Burger createBurger(List<Ingredient> ingredientList){
    Burger b = new Burger();
    b.setName(this.name);
    b.setIngredients(
        ingredients.stream().map( name ->
            ingredientList.stream().filter(ing -> ing.getName().equals(name)).findFirst().get()
        ).collect(Collectors.toList())
    );
    return b;
  }

}

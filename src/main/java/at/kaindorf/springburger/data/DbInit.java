package at.kaindorf.springburger.data;

import at.kaindorf.springburger.pojos.Ingredient;
import at.kaindorf.springburger.pojos.IngredientType;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DbInit {

  private final IngredientRepository ingredientRepository;

  @PostConstruct
  public void createInitialData(){
    final List<Ingredient> ingredients = List.of(
        new Ingredient("160g Ground Beef", IngredientType.PATTY),
        new Ingredient("180g Turkey",IngredientType.PATTY),
        new Ingredient("Beyond Meat",IngredientType.PATTY),
        new Ingredient("Tomatoes",IngredientType.VEGGIE),
        new Ingredient("Salad",IngredientType.VEGGIE),
        new Ingredient("Onions",IngredientType.VEGGIE),
        new Ingredient("Cheddar",IngredientType.CHEESE),
        new Ingredient("Mozzarella",IngredientType.CHEESE)
    );
    ingredientRepository.saveAllAndFlush(ingredients);
  }

}

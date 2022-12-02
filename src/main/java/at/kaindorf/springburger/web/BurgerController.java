package at.kaindorf.springburger.web;

import at.kaindorf.springburger.pojos.Ingredient;
import at.kaindorf.springburger.pojos.IngredientType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/burger")
public class BurgerController {

  private static final Map<IngredientType, List<Ingredient>> ingredientMap = new HashMap<>();
  private static final List<Ingredient> ingredients = List.of(
      new Ingredient("160g Ground Beef",IngredientType.PATTY),
      new Ingredient("180g Turkey",IngredientType.PATTY),
      new Ingredient("Beyond Meat",IngredientType.PATTY),
      new Ingredient("Tomatoes",IngredientType.VEGGIE),
      new Ingredient("Salad",IngredientType.VEGGIE),
      new Ingredient("Onions",IngredientType.VEGGIE),
      new Ingredient("Cheddar",IngredientType.CHEESE),
      new Ingredient("Mozzarella",IngredientType.CHEESE)
  );
  static {
    Arrays.stream(IngredientType.values()).forEach(
        it -> ingredientMap.put(it, ingredients.stream()
            .filter(i -> i.getIngredientType().equals(it))
            .toList()));
  }

  @ModelAttribute
  public void setAttributes(Model model) {
    model.addAttribute("ingredientMap",ingredientMap);
  }

  @GetMapping
  public String showDesignBurgerForm() {
    return "designForm";
  }

}

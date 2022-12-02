package at.kaindorf.springburger.web;

import at.kaindorf.springburger.data.IngredientRepository;
import at.kaindorf.springburger.pojos.Burger;
import at.kaindorf.springburger.pojos.Ingredient;
import at.kaindorf.springburger.pojos.IngredientType;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/burger")
@RequiredArgsConstructor
public class BurgerController {

//  private static final Map<IngredientType, List<Ingredient>> ingredientMap = new HashMap<>();
//  private static final List<Ingredient> ingredients = List.of(
//      new Ingredient("160g Ground Beef",IngredientType.PATTY),
//      new Ingredient("180g Turkey",IngredientType.PATTY),
//      new Ingredient("Beyond Meat",IngredientType.PATTY),
//      new Ingredient("Tomatoes",IngredientType.VEGGIE),
//      new Ingredient("Salad",IngredientType.VEGGIE),
//      new Ingredient("Onions",IngredientType.VEGGIE),
//      new Ingredient("Cheddar",IngredientType.CHEESE),
//      new Ingredient("Mozzarella",IngredientType.CHEESE)
//  );
//  static {
//    Arrays.stream(IngredientType.values()).forEach(
//        it -> ingredientMap.put(it, ingredients.stream()
//            .filter(i -> i.getIngredientType().equals(it))
//            .toList()));
//  }

  private final IngredientRepository ingredientRepository;

  private static final Map<IngredientType, List<Ingredient>> ingredientMap = new HashMap<>();

  public static Map<IngredientType, List<Ingredient>> getIngredientMap() {
    return ingredientMap;
  }

  @PostConstruct
  public void postConst(){
    log.info("BurgerController post construct");

    List<Ingredient> ingredients = ingredientRepository.findAll();

    Arrays.stream(IngredientType.values()).forEach(
        it -> ingredientMap.put(it, ingredients.stream()
            .filter(i -> i.getIngredientType().equals(it))
            .toList()));
  }

  @ModelAttribute
  public void setAttributes(Model model) {


    model.addAttribute("ingredientMap",ingredientMap);
    //model.addAttribute("designBurger", new ViewBurger());
    log.info("Set Design Burger Attribute");
    model.addAttribute("designBurger", new Burger());
  }

  @GetMapping
  public String showDesignBurgerForm() {
    return "designForm";
  }

  @PostMapping
  public RedirectView createBurger(
      RedirectAttributes attributes,
      Burger fromDesignForm){

    log.info("Create Burger");
    log.info(fromDesignForm.toString());

    //Burger b = fromDesignForm.createBurger(ingredients);
    //log.info(b.toString());
    attributes.addFlashAttribute("designBurger", fromDesignForm);
    return new RedirectView("/burger");
  }

}

package at.kaindorf.springburger.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ingredient {
  @Id
  @GeneratedValue
  private long id;
  private String name;
  private IngredientType ingredientType;

  public Ingredient(String name, IngredientType ingredientType) {
    this.name = name;
    this.ingredientType = ingredientType;
  }
}

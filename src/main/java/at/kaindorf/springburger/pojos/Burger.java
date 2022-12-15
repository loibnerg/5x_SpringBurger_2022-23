package at.kaindorf.springburger.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Burger {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  @Size(min = 4, message = "Burger name minimum length is 4")
  @Size(max = 12, message = "Burger name maximum length is 12")
  private String name;

  @Size(min = 2, message = "Minimum number of ingredients is 2")
  @ManyToMany
  @JoinTable(
      name = "burger_ingredient",
      joinColumns = {
          @JoinColumn(name = "bid")
      },
      inverseJoinColumns = {
          @JoinColumn(name = "iid")
      }
  )
  private List<Ingredient> ingredients = new ArrayList<>();
}

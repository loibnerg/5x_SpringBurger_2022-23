package at.kaindorf.springburger.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Burger {

  private String name;
  private List<Ingredient> ingredients = new ArrayList<>();
}

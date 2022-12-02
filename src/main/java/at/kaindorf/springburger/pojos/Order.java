package at.kaindorf.springburger.pojos;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
  private String fullname;
  private String street;
  private String city;
  private List<Burger> burgerList = new ArrayList<>();
}

package at.kaindorf.springburger.pojos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Burger_Order")
public class Order {
  @Id
  @GeneratedValue
  private Long id;
  private String fullname;
  private String street;
  private String city;

  @OneToMany
  @JoinColumn(name = "order_id")
  private List<Burger> burgerList = new ArrayList<>();

  public void addBurger(Burger burger) {
    burgerList.add(burger);
  }
}

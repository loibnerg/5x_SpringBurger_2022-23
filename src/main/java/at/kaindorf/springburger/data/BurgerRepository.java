package at.kaindorf.springburger.data;

import at.kaindorf.springburger.pojos.Burger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurgerRepository extends JpaRepository<Burger, Long> {

}

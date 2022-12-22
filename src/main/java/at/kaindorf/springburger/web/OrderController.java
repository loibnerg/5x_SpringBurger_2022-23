package at.kaindorf.springburger.web;

import at.kaindorf.springburger.data.BurgerRepository;
import at.kaindorf.springburger.data.OrderRepository;
import at.kaindorf.springburger.pojos.Burger;
import at.kaindorf.springburger.pojos.Order;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/order")
@Slf4j
@RequiredArgsConstructor
@SessionAttributes({"designBurger", "order"})
public class OrderController {

  private final OrderRepository orderRepo;
  //private final BurgerRepository burgerRepo;

  @GetMapping
  public String showOrderForm(@SessionAttribute("designBurger") Burger burger,
      @SessionAttribute("order") Order order){

    order.addBurger(burger);

    return "orderForm";
  }

  @PostMapping
  public RedirectView placeOrder(Model model, Order order){

    //order.getBurgerList().forEach(burgerRepo::save);
    orderRepo.save(order);

    // reset order after successful save
    model.addAttribute("order", new Order());

    return new RedirectView("/burger");
  }

}

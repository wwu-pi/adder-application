package de.wwu.pi.acse.adder.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.wwu.pi.acse.adder.businesslogic.AdderService;
import de.wwu.pi.acse.adder.model.MyNumber;
import de.wwu.pi.acse.adder.model.SumRequest;

@Controller
@RequestMapping("/")
public class AdderController {
  @Autowired
  AdderService adderService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("sumRequest", new SumRequest());
    return "adder/index";
  }

  @PostMapping("/sum")
  public String sumPost(SumRequest sumRequest, Model model) {
    MyNumber result = adderService.add(sumRequest.getA(), sumRequest.getB());
    model.addAttribute("sum", result);
    return "adder/sum";
  }

  @GetMapping("/sum")
  public String sumGet(@RequestParam("a.number") int i,
                       @RequestParam("b.number") int j,
                       Model model) {
    MyNumber a = new MyNumber();
    MyNumber b = new MyNumber();
    a.setNumber(i);
    b.setNumber(j);
    MyNumber result = adderService.add(a, b);
    model.addAttribute("sum", result);
    return "adder/sum";
  }
}

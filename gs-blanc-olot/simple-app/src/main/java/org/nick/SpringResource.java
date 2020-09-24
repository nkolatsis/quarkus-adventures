package org.nick;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/spring")
@RestController
public class SpringResource {

  @GetMapping
  public String helloSpring() {
    return "Hello Spring endpoint";
  }
  
}
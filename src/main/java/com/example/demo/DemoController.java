package com.example.demo;

import com.example.dao.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class DemoController {

    private final ApplicationEventPublisher mPublsher;
    private final Random mRandom = new Random();

    @Autowired
    public DemoController(final ApplicationEventPublisher publisher) {
        this.mPublsher = publisher;
    }

    @GetMapping("/")
    public String index(final Model model) {
        model.addAttribute("command",
                new Command(Integer.toString(mRandom.nextInt(9000000) + 1000000), ""));
        return "index";
    }

    @PostMapping("/command")
    public ModelAndView submitCommand(@ModelAttribute(value="command") Command command) {
        mPublsher.publishEvent(command);
        return new ModelAndView("redirect:id/" + command.getId());
    }
}

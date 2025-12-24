package com.example.demo;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @GetMapping("/")
    public String showHomepage(){
        return "index";
    }

    @PostMapping ("/Calculate")
    public String calculateTime(@RequestParam int startDates,
                             @RequestParam int startMonths,
                             @RequestParam int startYears,
                             @RequestParam int endDates,
                             @RequestParam int endMonths,
                             @RequestParam int endYears,
                             Model model){
        DateCalculator myCalculator = new DateCalculator(startDates, startMonths, startYears, endDates, endMonths, endYears);
        int passedDays = Math.toIntExact(myCalculator.finalTotalTime());
        model.addAttribute("result", passedDays);
        return "index";
    }


}

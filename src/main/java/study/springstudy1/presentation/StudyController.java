package study.springstudy1.presentation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/study")
public class StudyController {
    @GetMapping("/hello-api")
    @ResponseBody
    public String helloApi(@RequestParam("name") String name) {
        return "hello " + name;
    }
}

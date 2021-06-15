package com.axsos.anbousi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coding")
public class CodingController {



@RequestMapping("")
public String hello() { // 3
    return "Hello Coding Dojo!";
}

@RequestMapping("python")
public String python() { // 3
    return "Python/Django was awesome!";
}

@RequestMapping("java")
public String java() { // 3
    return "Java/Spring is better!";
}
}


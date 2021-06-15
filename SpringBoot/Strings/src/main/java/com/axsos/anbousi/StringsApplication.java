package com.axsos.anbousi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
@RequestMapping("/")
// 3. Method that maps to the request route above
public String Client() { // 3
        return "Hello Client!, How are you doing?";
}

@RequestMapping("/random")
//3. Method that maps to the request route above
public String Spring() { // 3
     return "Spring  boot is great! So easy to just respond with strings";
}

}

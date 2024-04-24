package com.vishnu.spring.apple.mobile;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileController {

    @GetMapping
    public List<String> getMobiles() {
        return List.of("Apple", "Mobiles");
    }
}

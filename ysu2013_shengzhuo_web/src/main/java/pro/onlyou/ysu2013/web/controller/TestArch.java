package pro.onlyou.ysu2013.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TestArch {

    @RequestMapping
    public String index(){
        return "login";
    }


}

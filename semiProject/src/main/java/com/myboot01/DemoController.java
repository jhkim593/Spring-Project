package com.myboot01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping("/")
	public String home() {
		return "index.html";
	}

	@RequestMapping("/hello.do")

	public String hello(Model model) {
		System.out.println("hello()호출됨");
		model.addAttribute("msg", "여기는 hello.html입니다");
		return "html/hello.html";
	}
}

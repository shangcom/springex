package com.green.springex.controller;

import com.green.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hi1")
    public void hello(){
        log.info("hello");
    }

    //리턴타입이 스트링이면 hi2 요청 후 aaa.jsp
    @GetMapping("/hi2")
    public String hello2(){
        log.info("hello2");
        return "aaa";
    }

//    @GetMapping("/ex4")
//    public ModelAndView hello3(){
//        log.info("ex4");
//        model.addAttribute("message", "nice");
//    }

    //이렇게 하기 불편해서 아래 방식으로 한다.
    @GetMapping("/todoModel")
    public void todoModel(TodoDTO todoDTO, Model model){
        todoDTO.setTno(6L);
        todoDTO.setDueDate(LocalDate.parse("2024-04-20"));
        todoDTO.setFinished(false);
        todoDTO.setTitle("글제목1");
        todoDTO.setWriter("바보");
        log.info("todoDTO");
        model.addAttribute("todoDTO3", todoDTO);
    }

    @GetMapping("/todoModelAttribute")
    public void todo(@ModelAttribute("dto") TodoDTO todoDTO){
        todoDTO.setTno(7L);
        todoDTO.setDueDate(LocalDate.parse("2024-04-21"));
        todoDTO.setFinished(false);
        todoDTO.setTitle("글제목7");
        todoDTO.setWriter("멍청이");
        log.info(todoDTO);        log.info("todoDTO");
    }

//    @GetMapping("/ex5")
//    public String exs(){
//        return "ex5";
//    }

    //ex5로 요청하고 ex6으로 가기 : redirect 사용. prg 패턴.
//    @GetMapping("/ex5")
//    public String exs(RedirectAttributes redirectAttributes){
//        log.info("ex5");
//        return "redirect:/ex6"; // 꼭 '/' 넣어야 한다.
//    }
//
//    @GetMapping("/ex6")
//    public void ex6(){
//        log.info("ex6");
//    }

    @GetMapping("/ex5")
    public String exs(RedirectAttributes redirectAttributes){
        log.info("ex5");
        //addAttribute(키, 값) : 리다이렉트할 때 쿼리 스트링이 되는 값을 지정.
        redirectAttributes.addAttribute("name","hong");
        //addFlashAttribute(키, 값) : 일회용으로만 데이터를 전달하고 삭제되는 값을 지정.
        redirectAttributes.addFlashAttribute("menu","짜장");
        return "redirect:/ex6";
    }

    // 처음에 /ex5로 요청했을 때는 "ex6 짜장" 출력되고, 그 상태에서 새로고침 하면 짜장 없어지고  ex6만 출력됨.
    // ex5에서 addFlashAttribute로 했기 때문.
    @GetMapping("/ex6")
    public void ex6(){
        log.info("ex6");
    }

}

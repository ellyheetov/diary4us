package org.diary4us.controller;

import org.diary4us.dto.BoardInform;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ComponentScan(basePackages = {"org.diary4us.controller"})
public class WriteDiaryController {

    @RequestMapping(path="/writeDiaryForm", method = RequestMethod.GET)
    public String writeForm(){ return "/index.html";}

    @RequestMapping(path="/writeDiary", method= RequestMethod.POST)
    public String writeDiary(@RequestParam(name="diaryTitle", required = true) String diaryTitle,
                             @RequestParam(name="diaryPw", required = true) String diaryPw,
                             @RequestParam(name="diaryContent", required = true) String diaryContent){
        System.out.println("WriteDiary Controller 호출 ");
        System.out.println(boardInform);
        return "/board/boardList.jsp";
    }
}

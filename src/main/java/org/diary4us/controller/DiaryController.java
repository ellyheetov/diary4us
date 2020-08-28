package org.diary4us.controller;

import org.diary4us.dto.BoardInform;
import org.diary4us.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;


@Controller
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @GetMapping(path = "/writeDiaryForm")
    public String writeForm() {
        return "index";
    }

    @PostMapping(path = "/writeDiary")
    public String writeDiary(BoardInform boardInform) {

       /* @RequestParam(name = "diaryTitle", required = true) String diaryTitle,
        @RequestParam(name = "diaryPw", required = true) String diaryPw,
        @RequestParam(name = "diaryContent", required = true) String diaryContent)*/

//        diaryService.addDiary(boardInform);

        return "/board/boardList";
    }
}

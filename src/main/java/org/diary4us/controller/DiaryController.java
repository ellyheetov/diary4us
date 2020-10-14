package org.diary4us.controller;

import org.diary4us.dto.BoardInform;
import org.diary4us.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class DiaryController {

    @Autowired
    BoardService boardService;

    @PostMapping(path = "/writeDiary")
    public String writeDiary(@RequestParam(name="diaryTitle",required = true) String diaryTitle,
                             @RequestParam(name="diaryContent", required = true)String content) {
        BoardInform boardInform = new BoardInform();

        boardInform.setTitle(diaryTitle);
        boardInform.setContent(content);
        boardInform.setRegdate(new Date());

        System.out.println(boardInform);
        boardService.addBoard(boardInform);
        return "/board/boardList";
    }
}

package org.diary4us.web.diary.controller;

import io.swagger.annotations.ApiOperation;
import org.diary4us.web.diary.dto.DiaryBoard;
import org.diary4us.web.diary.service.DiaryBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="/diary")
public class DiaryApiController {

    @Autowired
    DiaryBoardService diaryBoardService;

    @ApiOperation(value="게시글 생성")
    @PostMapping(value="")
    public DiaryBoard insertBoard(@RequestBody DiaryBoard diaryBoard){
        DiaryBoard resultBoard = diaryBoardService.insertBoard(diaryBoard);
        return resultBoard;
    }

    @ApiOperation(value = "해당 게시글 조회")
    @GetMapping(value="/{id}")
    public @ResponseBody
    DiaryBoard selectBoard(@PathVariable("id") Integer id){
        return diaryBoardService.getBoard(id);
    }

    @ApiOperation(value = "전체 게시글 조회")
    @GetMapping(value="/diarys")
    @ResponseBody
    public Map<String, Object> selectSome(@RequestParam(name="start",required = false, defaultValue = "0")int start){
        List<DiaryBoard> list = diaryBoardService.getBoards(start);

        int count = diaryBoardService.getCount();
        int pageCount = count/ diaryBoardService.LIMIT;

        List<Integer> pageStartList = new ArrayList<Integer>();

        for(int i =0;i< pageCount; i++) {
            pageStartList.add(i * diaryBoardService.LIMIT);
        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("list",list);
        map.put("count",count);
        map.put("pageStartList",pageStartList);
        return map;
    }
    @ApiOperation(value ="해당 게시글 수정")
    @PatchMapping(value="/{id}")
    public DiaryBoard updateBoard(DiaryBoard diaryBoard){
        DiaryBoard resultBoard = diaryBoardService.updateBoard(diaryBoard);
        return resultBoard;
    }

    @ApiOperation(value = "해당 게시글 삭제")
    @DeleteMapping(value="/{id}")
    public Map<String,String> deleteBoard(@PathVariable("id") Integer id){
        int deleteCount = diaryBoardService.deleteBoard(id);
        return Collections.singletonMap("success",deleteCount > 0 ? "true" : "false");
    }
}

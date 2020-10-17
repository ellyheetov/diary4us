package org.diary4us.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.diary4us.dto.BoardInform;
import org.diary4us.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="/board")
public class DiaryApiController {

    @Autowired
    BoardService boardService;

    @ApiOperation(value="게시글 생성")
    @PostMapping(value="")
    public BoardInform insertBoard(@RequestBody BoardInform boardInform){
        BoardInform resultBoard = boardService.insertBoard(boardInform);
        return resultBoard;
    }

    @ApiOperation(value = "해당 게시글 조회")
    @GetMapping(value="/{id}")
    public @ResponseBody BoardInform selectBoard(@PathVariable("id") Long id){
        return boardService.getBoard(id);
    }

    @ApiOperation(value = "전체 게시글 조회")
    @GetMapping(value="/boards")
    @ResponseBody
    public Map<String, Object> selectSome(@RequestParam(name="start",required = false, defaultValue = "0")int start){
        List<BoardInform> list = boardService.getBoards(start);

        int count = boardService.getCount();
        int pageCount = count/boardService.LIMIT;

        List<Integer> pageStartList = new ArrayList<Integer>();

        for(int i =0;i< pageCount; i++) {
            pageStartList.add(i * boardService.LIMIT);
        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("list",list);
        map.put("count",count);
        map.put("pageStartList",pageStartList);
        return map;
    }
    @ApiOperation(value ="해당 게시글 수정")
    @PatchMapping(value="/{id}")
    public BoardInform updateBoard(BoardInform boardInform){
        BoardInform resultBoard = boardService.updateBoard(boardInform);
        return resultBoard;
    }

    @ApiOperation(value = "해당 게시글 삭제")
    @DeleteMapping(value="/{id}")
    public Map<String,String> deleteBoard(@PathVariable("id") Long id){
        int deleteCount = boardService.deleteBoard(id);
        return Collections.singletonMap("success",deleteCount > 0 ? "true" : "false");
    }
}

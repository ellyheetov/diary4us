package org.diary4us.web.diary.service;

import org.diary4us.web.diary.dto.DiaryBoard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiaryBoardService {

    public static final Integer LIMIT = 5;
    DiaryBoard getBoard(Integer id);
    List<DiaryBoard> getBoards(Integer start);
    Integer deleteBoard(Integer id);
    DiaryBoard insertBoard(DiaryBoard diaryBoard);
    DiaryBoard updateBoard(DiaryBoard diaryBoard);
    Integer getCount();
}

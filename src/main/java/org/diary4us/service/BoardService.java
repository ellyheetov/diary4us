package org.diary4us.service;

import org.diary4us.dto.BoardInform;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {

    public static final Integer LIMIT = 5;
    BoardInform getBoard(Long id);
    List<BoardInform> getBoards(Integer start);
    int deleteBoard(Long id);
    BoardInform insertBoard(BoardInform boardInform);
    BoardInform updateBoard(BoardInform boardInform);
    int getCount();
}

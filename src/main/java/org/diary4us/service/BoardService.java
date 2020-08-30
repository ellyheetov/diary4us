package org.diary4us.service;

import org.diary4us.dto.BoardInform;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {

    public static final Integer LIMIT = 5;
    public List<BoardInform> getBoards(Integer start);
    public int deleteBoard(Long id);
    public BoardInform addBoard(BoardInform boardInform);
    public int getCount();

}

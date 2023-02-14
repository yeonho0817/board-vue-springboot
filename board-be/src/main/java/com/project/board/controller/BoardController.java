package com.project.board.controller;

import com.project.board.dto.BoardDTO;
import com.project.board.dto.PageDTO;
import com.project.board.dto.response.ResponseData;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    // 게시판 목록
    @GetMapping("/list")
    public ResponseData<BoardDTO.BoardListData> getBoardList(@ModelAttribute PageDTO pageDTO) {
        return boardService.getBoardList(pageDTO);
    }

    // 게시판 상세 정보
    @GetMapping("/detail")
    public ResponseData<BoardDTO.BoardListData> getBoardDetail(@Param("boardId") Long boardId) {
        return boardService.getBoardDetail(boardId);
    }
}

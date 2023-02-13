package com.project.board.controller;

import com.project.board.dto.BoardDTO;
import com.project.board.dto.PageDTO;
import com.project.board.dto.response.ResponseData;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    // 게시판 목록
    @GetMapping("/list")
    public ResponseData<List<BoardDTO.BoardData>> getBoardList(@ModelAttribute PageDTO pageDTO) {
        return boardService.getBoardList(pageDTO);
    }
}

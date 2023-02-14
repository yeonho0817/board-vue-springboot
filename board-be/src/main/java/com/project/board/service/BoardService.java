package com.project.board.service;


import com.project.board.dto.BoardDTO;
import com.project.board.dto.PageDTO;
import com.project.board.dto.response.ResponseData;
import com.project.board.dto.response.Status;
import com.project.board.repository.custom.BoardCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardCustomRepository boardCustomRepository;

    // 게시판 목록
    public ResponseData<BoardDTO.BoardListData> getBoardList(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPageNumber(), pageDTO.getPageSize());

        Page<BoardDTO.BoardData> boardDatas = boardCustomRepository.findAll(pageable);

        return new ResponseData<>(
                Status.SUCCESS_READ_BOARD_LIST,
                Status.SUCCESS_READ_BOARD_LIST.getDescription(),
                BoardDTO.BoardListData.builder()
                        .boardDatas(boardDatas.stream().collect(Collectors.toList()))
                        .totalCount(boardDatas.getTotalElements())
                        .build());
    }

    // 게시판 상세 정보
    public ResponseData getBoardDetail(Long boardId) {

        return new ResponseData<>(
            Status.SUCCESS_READ_BOARD_LIST,
            Status.SUCCESS_READ_BOARD_LIST.getDescription(),
            null
        );
    }
}

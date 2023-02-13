package com.project.board.repository.custom;

import com.project.board.dto.BoardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardCustomRepository {
    Page<BoardDTO.BoardData> findAll(Pageable pageable);
}

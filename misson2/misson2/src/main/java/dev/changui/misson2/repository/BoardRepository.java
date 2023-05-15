package dev.changui.misson2.repository;


import dev.changui.misson2.model.BoardDto;
import org.springframework.stereotype.Repository;

import java.util.Collection;


public interface BoardRepository {
    BoardDto create(BoardDto dto);
    BoardDto read(Long id);
    Collection<BoardDto> readAll();
    boolean update(Long id, BoardDto dto);
    boolean delete(Long id);
}

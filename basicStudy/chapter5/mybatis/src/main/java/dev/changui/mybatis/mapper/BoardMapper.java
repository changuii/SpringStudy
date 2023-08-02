package dev.changui.mybatis.mapper;

import dev.changui.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}

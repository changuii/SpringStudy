package dev.changui.misson2.repository;

import dev.changui.misson2.model.BoardDto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class inMemoryBoardRepository implements  BoardRepository{
    private Long lastIndex = 0L;
    private final Map<Long, BoardDto> memory = new HashMap<>() ;

    @Override
    public BoardDto create(BoardDto dto) {
        lastIndex++;
        dto.setId(lastIndex);
        memory.put(lastIndex, dto);
        return memory.get(lastIndex);
    }

    @Override
    public BoardDto read(Long id) {
        return memory.getOrDefault(id, null);
    }

    @Override
    public Collection<BoardDto> readAll() {
        Set<Long> keySet = memory.keySet();
        Iterator<Long> key = keySet.iterator();
        Collection<BoardDto> mem = new LinkedList<>();
        while(key.hasNext()){
            mem.add(this.memory.get(key.next()));
        }
        return mem;

    }

    @Override
    public boolean update(Long id, BoardDto dto) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if(!memory.containsKey(id))
            return false;
        memory.remove(id);
        return true;
    }
}

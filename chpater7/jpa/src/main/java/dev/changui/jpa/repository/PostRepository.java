package dev.changui.jpa.repository;

import dev.changui.jpa.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByWriter(String writer);  // where writer = ?
    List<PostEntity> findAllByWriterContaining(String wirter); // where
}

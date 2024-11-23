package com.example.studentbot.data;

import com.example.studentbot.data.entity.ChatEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatsCrudRepository extends CrudRepository<ChatEntity, Long> {
    Iterable<ChatEntity> findByChatId(Long chat_id);
}

package com.example.studentbot.data;

import com.example.studentbot.data.entity.VisitsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitsCrudRepository extends CrudRepository<VisitsEntity, Long> {
    Iterable<VisitsEntity> findAllByChatId(Long chat_id);
}

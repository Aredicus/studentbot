package com.example.studentbot.data;

import com.example.studentbot.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends CrudRepository<UserEntity, Long> {
    Iterable<UserEntity> findByUserId(Long chat_id);
}

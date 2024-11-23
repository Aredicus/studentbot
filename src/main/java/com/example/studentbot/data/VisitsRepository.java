package com.example.studentbot.data;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VisitsRepository {
    private final VisitsCrudRepository visitsCrudRepository;
    private final UserCrudRepository userCrudRepository;
    private final ChatsCrudRepository chatsCrudRepository;
}

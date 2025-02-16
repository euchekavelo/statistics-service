package ru.skillbox.statisticsservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.skillbox.statisticsservice.model.Event;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

    List<Event> findAllByObjectId(String objectId);
}

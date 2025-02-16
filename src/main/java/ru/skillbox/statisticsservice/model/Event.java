package ru.skillbox.statisticsservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.skillbox.statisticsservice.model.enums.ObjectType;

import java.time.LocalDateTime;

@Document(collection = "events")
@Data
public class Event {

    @Id
    private String uuid;

    private LocalDateTime dateTime;

    private ObjectType objectType;

    private String objectId;

    private String initiatorUserId;
}

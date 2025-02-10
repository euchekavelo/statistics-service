package ru.skillbox.statisticsservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.skillbox.statisticsservice.model.enums.ObjectType;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "events")
@Data
public class Event {

    @Id
    private UUID uuid;

    private LocalDateTime dateTime;

    private ObjectType objectType;

    private UUID objectId;

    private UUID initiatorUserId;
}

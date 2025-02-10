package ru.skillbox.statisticsservice.dto.response;

import lombok.Data;
import ru.skillbox.statisticsservice.model.enums.ObjectType;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EventResponseDto {

    private UUID uuid;
    private LocalDateTime dateTime;
    private ObjectType objectType;
    private UUID objectId;
    private UUID initiatorUserId;
}

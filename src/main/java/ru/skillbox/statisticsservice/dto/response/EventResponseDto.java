package ru.skillbox.statisticsservice.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import ru.skillbox.statisticsservice.model.enums.ObjectType;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventResponseDto {

    @Id
    private UUID uuid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    private ObjectType objectType;

    private UUID objectId;

    private UUID initiatorUserId;
}

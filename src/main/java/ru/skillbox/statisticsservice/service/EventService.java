package ru.skillbox.statisticsservice.service;

import ru.skillbox.statisticsservice.dto.response.EventResponseDto;
import ru.skillbox.statisticsservice.exception.EventNotFoundException;

import java.util.List;

public interface EventService {

   EventResponseDto getEventById(String eventId) throws EventNotFoundException;

   List<EventResponseDto> getEventsByObjectId(String objectId);
}
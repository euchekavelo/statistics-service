package ru.skillbox.statisticsservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.skillbox.statisticsservice.model.Event;
import ru.skillbox.statisticsservice.dto.response.EventResponseDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    EventResponseDto eventToEventResponseDto(Event event);

    List<EventResponseDto> eventListToEventResponseDtoList(List<Event> events);
}

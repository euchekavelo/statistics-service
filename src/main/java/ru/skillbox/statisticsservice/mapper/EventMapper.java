package ru.skillbox.statisticsservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.skillbox.statisticsservice.model.Event;
import ru.skillbox.statisticsservice.dto.response.EventResponseDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    EventResponseDto eventToEventResponseDto(Event event);
}

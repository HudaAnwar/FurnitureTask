package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.TimesOfWeek
import com.huda.furnituretask.domain.util.DomainMapper


class TimesOfWeekDtoMapper : DomainMapper<TimesOfWeekDto, TimesOfWeek> {

    override fun mapToDomainModel(model: TimesOfWeekDto): TimesOfWeek {
        with(model) {
            return TimesOfWeek(
                day = day,
                from = from,
                to = to
            )
        }
    }

    override fun mapFromDomainModel(domainModel: TimesOfWeek): TimesOfWeekDto {
        with(domainModel) {
            return TimesOfWeekDto(
                day = day,
                from = from,
                to = to
            )
        }
    }

}
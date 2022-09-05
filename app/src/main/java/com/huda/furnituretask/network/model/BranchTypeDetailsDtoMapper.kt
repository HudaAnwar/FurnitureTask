package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.BranchTypeDetails
import com.huda.furnituretask.domain.model.TimesOfWeek
import com.huda.furnituretask.domain.util.DomainMapper
import javax.inject.Inject

class BranchTypeDetailsDtoMapper @Inject constructor(
    private val timesOfWeekDtoMapper: TimesOfWeekDtoMapper
) : DomainMapper<BranchTypeDetailsDto, BranchTypeDetails> {
    override fun mapToDomainModel(model: BranchTypeDetailsDto): BranchTypeDetails {
        with(model) {
            return BranchTypeDetails(
                id = id,
                name = name,
                address = address,
                phone = phone,
                email = email,
                branchId = branchId,
                timesOfWeek = timesOfWeek?.let { timesOfWeekDtoMapper.toDomainList(it) } as ArrayList<TimesOfWeek>?
            )
        }
    }

    override fun mapFromDomainModel(domainModel: BranchTypeDetails): BranchTypeDetailsDto {
        with(domainModel) {
            return BranchTypeDetailsDto(
                id = id,
                name = name,
                address = address,
                phone = phone,
                email = email,
                branchId = branchId,
                timesOfWeek = timesOfWeek?.let { timesOfWeekDtoMapper.fromDomainList(it) } as ArrayList<TimesOfWeekDto>?
            )
        }
    }


}
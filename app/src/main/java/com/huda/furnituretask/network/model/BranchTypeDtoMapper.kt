package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.BranchType
import com.huda.furnituretask.domain.util.DomainMapper

class BranchTypeDtoMapper : DomainMapper<BranchTypeDto, BranchType> {
    override fun mapToDomainModel(model: BranchTypeDto): BranchType {
        with(model) {
            return BranchType(
                id = id,
                image = image,
                name = name,
                count = count,
                branchTypeId = branchTypeId
            )
        }
    }

    override fun mapFromDomainModel(domainModel: BranchType): BranchTypeDto {
        with(domainModel) {
            return BranchTypeDto(
                branchTypeId = branchTypeId,
                id = id,
                image = image,
                name = name,
                count = count
            )
        }
    }


}
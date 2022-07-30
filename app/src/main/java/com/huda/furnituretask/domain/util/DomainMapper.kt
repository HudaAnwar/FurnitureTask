package com.huda.furnituretask.domain.util


interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(model: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel): T

    fun toDomainList(initial: List<T>): List<DomainModel> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<DomainModel>): List<T> {
        return initial.map { mapFromDomainModel(it) }
    }
}
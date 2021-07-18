package dev.alexandreyoshmatsu.servicepessoa.service.extension

import dev.alexandreyoshmatsu.servicepessoa.controller.extension.mapToResponse
import dev.alexandreyoshmatsu.servicepessoa.gateway.model.PessoaModel
import dev.alexandreyoshmatsu.servicepessoa.service.entity.PessoaEntity

fun List<PessoaModel>.mapToEntity(): List<PessoaEntity> {
    return this.map { p -> p.mapToEntity() }
}

fun PessoaModel.mapToEntity(): PessoaEntity {
    return PessoaEntity(this.id, this.username, this.nome, this.tipoSanguineo)
}
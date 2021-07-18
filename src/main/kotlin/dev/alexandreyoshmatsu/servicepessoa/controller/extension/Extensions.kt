package dev.alexandreyoshmatsu.servicepessoa.controller.extension

import dev.alexandreyoshmatsu.servicepessoa.controller.dto.PessoaResponse
import dev.alexandreyoshmatsu.servicepessoa.service.entity.PessoaEntity

fun List<PessoaEntity>.mapToResponse(): List<PessoaResponse> {
    return this.map { p -> p.mapToResponse() }
}

fun PessoaEntity.mapToResponse(): PessoaResponse {
    return PessoaResponse(this.id, this.username, this.nome, this.tipoSanguineo)
}
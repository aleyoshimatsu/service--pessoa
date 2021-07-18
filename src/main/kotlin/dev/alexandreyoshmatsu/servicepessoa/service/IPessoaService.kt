package dev.alexandreyoshmatsu.servicepessoa.service

import dev.alexandreyoshmatsu.servicepessoa.service.entity.PessoaEntity

interface IPessoaService {

    fun findAll(): List<PessoaEntity>
    fun findById(id: String): PessoaEntity
    fun findByNome(nome: String): List<PessoaEntity>

}
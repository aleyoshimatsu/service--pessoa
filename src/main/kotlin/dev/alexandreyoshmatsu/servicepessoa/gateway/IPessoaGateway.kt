package dev.alexandreyoshmatsu.servicepessoa.gateway

import dev.alexandreyoshmatsu.servicepessoa.gateway.model.PessoaModel

interface IPessoaGateway {

    fun findAll(): List<PessoaModel>
    fun findById(id: String): PessoaModel
    fun findByNome(nome: String): List<PessoaModel>

}
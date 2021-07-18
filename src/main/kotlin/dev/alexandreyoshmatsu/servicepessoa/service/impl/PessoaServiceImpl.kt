package dev.alexandreyoshmatsu.servicepessoa.service.impl

import dev.alexandreyoshmatsu.servicepessoa.gateway.IPessoaGateway
import dev.alexandreyoshmatsu.servicepessoa.gateway.model.PessoaModel
import dev.alexandreyoshmatsu.servicepessoa.service.IPessoaService
import dev.alexandreyoshmatsu.servicepessoa.service.entity.PessoaEntity
import dev.alexandreyoshmatsu.servicepessoa.service.extension.mapToEntity
import org.springframework.stereotype.Service

@Service
class PessoaServiceImpl(private val pessoaGateway: IPessoaGateway): IPessoaService {

    override fun findAll(): List<PessoaEntity> {
        val pessoasModel: List<PessoaModel> = pessoaGateway.findAll()
        return pessoasModel.mapToEntity()
    }

    override fun findById(id: String): PessoaEntity {
        val pessoaModel: PessoaModel = pessoaGateway.findById(id)
        return pessoaModel.mapToEntity()
    }

    override fun findByNome(nome: String): List<PessoaEntity> {
        val pessoasModel: List<PessoaModel> = pessoaGateway.findByNome(nome)
        return pessoasModel.mapToEntity()
    }

}

package dev.alexandreyoshmatsu.servicepessoa.gateway.mock

import com.github.javafaker.Faker
import dev.alexandreyoshmatsu.servicepessoa.gateway.IPessoaGateway
import dev.alexandreyoshmatsu.servicepessoa.gateway.model.PessoaModel
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.ArrayList

@Component
class PessoaMockImpl(private var pessoas: List<PessoaModel> = ArrayList()) : IPessoaGateway {

    init {
        val faker = Faker(Locale("pt-BR"))

        repeat(100) {
            val name = faker.name()
            pessoas += PessoaModel(UUID.randomUUID().toString(), name.username(), name.fullName(), name.bloodGroup())
        }
    }

    override fun findAll(): List<PessoaModel> = pessoas

    override fun findById(id: String): PessoaModel {
        return pessoas.filter { p -> p.id == id }.first()
    }

    override fun findByNome(nome: String): List<PessoaModel> {
        return pessoas.filter { p -> p.nome.startsWith(nome, true) }
    }

}
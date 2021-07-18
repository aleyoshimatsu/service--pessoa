package dev.alexandreyoshmatsu.servicepessoa.controller

import dev.alexandreyoshmatsu.servicepessoa.controller.dto.PessoaResponse
import dev.alexandreyoshmatsu.servicepessoa.controller.extension.mapToResponse
import dev.alexandreyoshmatsu.servicepessoa.service.IPessoaService
import dev.alexandreyoshmatsu.servicepessoa.service.entity.PessoaEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/pessoas")
class PessoaController(private val pessoaService: IPessoaService) {

    @GetMapping("/")
    fun findAll(): ResponseEntity<List<PessoaResponse>> {
        val pessoasEntity: List<PessoaEntity> = pessoaService.findAll()
        return ResponseEntity(pessoasEntity.mapToResponse(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable(name = "id") id: String): ResponseEntity<PessoaResponse> {
        val pessoaEntity: PessoaEntity = pessoaService.findById(id)
        return ResponseEntity(pessoaEntity.mapToResponse(), HttpStatus.OK)
    }

    @GetMapping("/startsWith")
    fun findByNome(@RequestParam("nome", required = false) nome: String): ResponseEntity<List<PessoaResponse>> {
        val pessoasEntity: List<PessoaEntity> = pessoaService.findByNome(nome)
        return ResponseEntity(pessoasEntity.mapToResponse(), HttpStatus.OK)
    }

}

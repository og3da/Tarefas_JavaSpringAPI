/*
Este código é um controlador de API para gerenciar tarefas.
Ele tem vários métodos que permitem criar, atualizar, obter e deletar tarefas.
Cada método é mapeado para um tipo de solicitação HTTP (POST, PUT, GET, DELETE) e um caminho específico.
O controlador usa uma instância de TarefasFacade para realizar as operações e retorna os resultados em formato JSON.
 */

package com.hdi.tarefas.tarefas.api;

import com.hdi.tarefas.tarefas.dto.TarefaDTO;
import com.hdi.tarefas.tarefas.facade.TarefasFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
@Controller // Indica que esta classe é um controlador
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE) // Mapeia as solicitações para este controlador para o caminho "/tarefas" e define que o tipo de mídia produzido é JSON
public class TarefasAPI {
    @Autowired // Injeta automaticamente uma instância de TarefasFacade nesta variável
    private TarefasFacade tarefasFacade;

    @PostMapping // Mapeia solicitações POST para este método
    @ResponseBody // Indica que o retorno deste método deve ser incluído no corpo da resposta
    public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO) { // Recebe um objeto TarefaDTO no corpo da solicitação e retorna um objeto TarefaDTO
        return tarefasFacade.criar(tarefaDTO); // Chama o método criar do objeto tarefasFacade e retorna o resultado
    }

    @PutMapping("/{tarefaId}") // Mapeia solicitações PUT para este método com um parâmetro de caminho "tarefaId"
    @ResponseBody // Indica que o retorno deste método deve ser incluído no corpo da resposta
    public TarefaDTO atualizar(@PathVariable("tarefaId") Long tarefaId, // Recebe o parâmetro de caminho "tarefaId" como um Long
                               @RequestBody TarefaDTO tarefaDTO) { // Recebe um objeto TarefaDTO no corpo da solicitação e retorna um objeto TarefaDTO
        return tarefasFacade.atualizar(tarefaDTO, tarefaId); // Chama o método atualizar do objeto tarefasFacade com os parâmetros recebidos e retorna o resultado
    }

    @GetMapping // Mapeia solicitações GET para este método
    @ResponseBody // Indica que o retorno deste método deve ser incluído no corpo da resposta
    public List<TarefaDTO> getAll() { // Retorna uma lista de objetos TarefaDTO
        return tarefasFacade.getAll(); // Chama o método getAll do objeto tarefasFacade e retorna o resultado
    }

    @GetMapping("/{tarefaId}") // Mapeia solicitações GET para este método
    @ResponseBody // Indica que o retorno deste método deve ser incluído no corpo da resposta
    public TarefaDTO getById(@PathVariable("tarefaId") Long tarefaId) {
        return tarefasFacade.getById(tarefaId);
    }

    @DeleteMapping("/{tarefaId}") // Mapeia solicitações DELETE para este método com um parâmetro de caminho "tarefaId"
    @ResponseBody // Indica que o retorno deste método deve ser incluído no corpo da resposta
    public String deletar(@PathVariable("tarefaId") Long tarefaId) { // Recebe o parâmetro de caminho "tarefaId" como um Long e retorna uma String
        return tarefasFacade.delete(tarefaId); // Chama o método delete do objeto tarefasFacade com o parâmetro recebido e retorna o resultado
    }
}

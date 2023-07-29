/*
Este código define uma classe Java chamada TarefasFacade que atua como um serviço para gerenciar tarefas.
A classe possui um campo privado estático chamado tarefas, que é um Map que armazena tarefas usando seus IDs como chaves.

---A classe possui vários métodos para gerenciar tarefas:
criar: Este método recebe um objeto TarefaDTO como parâmetro e cria uma nova tarefa. Ele calcula o próximo ID para a tarefa, define o ID no objeto TarefaDTO, adiciona a tarefa ao mapa tarefas e retorna a tarefa criada.
atualizar: Este método recebe um objeto TarefaDTO e um ID de tarefa como parâmetros e atualiza uma tarefa existente. Ele atualiza a tarefa no mapa tarefas e retorna a tarefa atualizada.
getById: Este método recebe um ID de tarefa como parâmetro e retorna a tarefa correspondente do mapa tarefas.
getAll: Este método retorna uma lista de todas as tarefas no mapa tarefas.
delete: Este método recebe um ID de tarefa como parâmetro, remove a tarefa correspondente do mapa tarefas e retorna uma mensagem indicando que a tarefa foi excluída.
 */

package com.hdi.tarefas.tarefas.facade;

import com.hdi.tarefas.tarefas.dto.TarefaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // Indica que esta classe é um serviço
public class TarefasFacade {
    private static final Map<Long, TarefaDTO> tarefas = new HashMap<>(); // Cria um mapa para armazenar as tarefas

    public TarefaDTO criar(TarefaDTO tarefaDTO) { // Método para criar uma nova tarefa
        Long proximoId = tarefas.keySet().size() +1L; // Calcula o próximo ID para a tarefa
        tarefaDTO.setId(proximoId); // Define o ID da tarefa
        tarefas.put(proximoId, tarefaDTO); // Adiciona a tarefa ao mapa
        return tarefaDTO; // Retorna a tarefa criada
    }

    public TarefaDTO atualizar(TarefaDTO tarefaDTO, Long tarefaId) { // Método para atualizar uma tarefa existente
        tarefas.put(tarefaId, tarefaDTO); // Atualiza a tarefa no mapa
        return tarefaDTO; // Retorna a tarefa atualizada
    }

    public TarefaDTO getById(Long tarefaId) { // Método para obter uma tarefa pelo ID
        return tarefas.get(tarefaId); // Retorna a tarefa do mapa pelo ID
    }

    public List<TarefaDTO> getAll() { // Método para obter todas as tarefas
        return new ArrayList<>(tarefas.values()); // Retorna uma lista com todas as tarefas do mapa
    }

    public  String delete(Long tarefaId) { // Método para deletar uma tarefa pelo ID
        tarefas.remove(tarefaId); // Remove a tarefa do mapa pelo ID
        return "DELETED"; // Retorna uma mensagem indicando que a tarefa foi deletada
    }
}


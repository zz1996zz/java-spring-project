package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    // todo 리스트 목록에 아이템을 추가하는 메서드
    public TodoEntity add(TodoRequest request){
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());

        return this.todoRepository.save(todoEntity);
    }

    // todo 리스트 목록에서 특정 항목을 조회하는 메서드
    public TodoEntity searchById(Long id){
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // todo 리스트 목록 전체를 조회하는 메서드
    public List<TodoEntity> searchAll(){
        return this.todoRepository.findAll();
    }

    // todo 리스트 목록에서 특정 항목을 수정하고 반영하는 메서드
    public TodoEntity updateById(Long id, TodoRequest request){
        TodoEntity todoEntity = this.searchById(id);
        if (request.getTitle() != null) {
            todoEntity.setTitle(request.getTitle());
        }
        if (request.getOrder() != null) {
            todoEntity.setOrder(request.getOrder());
        }
        if (request.getCompleted() != null) {
            todoEntity.setCompleted(request.getCompleted());
        }
        return this.todoRepository.save(todoEntity);
    }

    // todo 리스트 목록에서 특정 항목을 삭제하는 메서드
    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }

    // todo 리스트 목록 전체를 삭제하는 메서드
    public void deleteAll(){
        this.todoRepository.deleteAll();
    }
}

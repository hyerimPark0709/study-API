package org.zerock.api.service;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.api.dto.PageRequestDTO;
import org.zerock.api.dto.PageResponseDTO;
import org.zerock.api.dto.TodoDTO;

@Transactional
public interface TodoService {

    Long register(TodoDTO todoDTO);
    TodoDTO read(Long tno);
    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);
    void remove(Long tno);
    void modify(TodoDTO todoDTO);
}

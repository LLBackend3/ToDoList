package com.springboot.teamproject.Repository;

import com.springboot.teamproject.Entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ToDoListRepository extends JpaRepository<ToDo,Long> {
    List<ToDo> findByUserName(String userName); //사용자 이름으로 할 일 목록 조회
}

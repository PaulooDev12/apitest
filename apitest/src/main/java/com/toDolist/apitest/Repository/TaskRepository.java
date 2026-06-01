package com.toDolist.apitest.Repository;

import com.toDolist.apitest.Model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel,Long> {
   List<TaskModel> findByNomeContaining(String nome);
   List<TaskModel> findByDescricaoContainingIgnoreCase(String descricao);
   }

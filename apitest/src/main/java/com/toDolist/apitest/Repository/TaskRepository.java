package com.toDolist.apitest.Repository;


import com.toDolist.apitest.Model.TaskModel;
import com.toDolist.apitest.Dto.TaskReqDto;



import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel,Long> {
}

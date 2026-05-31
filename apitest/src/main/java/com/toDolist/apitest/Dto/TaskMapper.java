package com.toDolist.apitest.Dto;

import com.toDolist.apitest.Model.TaskModel;

public class TaskMapper {
    public static TaskResDto toDto(TaskModel taskModel) {
        return new  TaskResDto(
                taskModel.getNome(),
                taskModel.getDescricao());
    }
}
package com.toDolist.apitest.Service;

import com.toDolist.apitest.Dto.FuncionarioMapper;
import com.toDolist.apitest.Dto.FuncionarioReqDto;
import com.toDolist.apitest.Dto.FuncionarioResDto;
import com.toDolist.apitest.Model.FuncionarioModel;
import com.toDolist.apitest.Repository.FuncionarioRepository;

import org.springframework.stereotype.Service;



import java.util.List;
import java.util.stream.Collectors;

@Service
public class FunctionaryService {
    private FuncionarioRepository fRepository;
    public FunctionaryService(FuncionarioRepository fRepository) {
        this.fRepository = fRepository;

    }
    public FuncionarioModel salvar(FuncionarioReqDto Fdto){
        FuncionarioModel fModel = new FuncionarioModel();
        fModel.setNome(Fdto.getNome());
        fModel.setCurso(Fdto.getCurso());
        return fRepository.save(fModel);
    }
    public List<FuncionarioResDto> listar(){
        List<FuncionarioModel> lista = fRepository.findAll();
        return lista.stream()
                .map(FuncionarioMapper::pDto)
                .collect(Collectors.toList());
    }
}

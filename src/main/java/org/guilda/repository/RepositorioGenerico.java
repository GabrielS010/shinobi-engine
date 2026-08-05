package org.guilda.repository;

import java.util.ArrayList;
import java.util.List;

public class RepositorioGenerico <T>{
    private List<T> dados = new ArrayList<>();

    public void salvar(T item){
        this.dados.add(item);
    }

    public List<T> buscarTodos(){
        return dados;
    }

}

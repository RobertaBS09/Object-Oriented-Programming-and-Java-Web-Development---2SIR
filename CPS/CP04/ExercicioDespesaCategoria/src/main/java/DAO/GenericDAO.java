package DAO;

import java.util.List;

public interface GenericDAO <T,ID>{
    public void inserir (T entidade);
    public List<T>listar();
    public void atualizar(T entidade);
    public void excluir (ID id);
}

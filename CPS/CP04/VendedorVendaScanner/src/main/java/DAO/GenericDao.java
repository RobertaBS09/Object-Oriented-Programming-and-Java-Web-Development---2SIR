package DAO;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, ID> {
    void inserir(T entidade);

    List<T> listar();

    Optional atualizar(T entidade);

    void remover(ID id);
}

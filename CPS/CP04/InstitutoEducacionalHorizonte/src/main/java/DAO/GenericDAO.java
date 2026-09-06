package DAO;

import java.util.List;

public interface GenericDAO  <T,ID>{
    void inserir (T var1); //oq é esse var? variável?
    List<T> listar();
    T buscarPorId(ID var1);

}

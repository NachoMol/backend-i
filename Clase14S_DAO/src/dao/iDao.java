package dao;

public interface iDao<T> {
    //guardar, eliminar, actualizar
    T guardar(T t);
    T buscar(Integer id);

}

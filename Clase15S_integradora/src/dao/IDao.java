package dao;

import java.util.List;

public interface IDao <T> {

T guardar(T t);
T buscar (int i);
void eliminar (int i);
T modificar (T t);
List<T> listar ();

}

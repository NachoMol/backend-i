package dao;

import model.Domicilio;

import java.util.List;

public interface IDao <T> {

T guardar(T t);
T buscar (int id);
void eliminar (int id);
void modificar (T t);
List<T> listar ();

}

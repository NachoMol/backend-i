package service;

import dao.iDao;
import model.Medicamento;

public class MedicamentoService {
    private iDao<Medicamento> medicamentoiDao;

    public MedicamentoService(iDao<Medicamento> medicamentoiDao) {
        this.medicamentoiDao = medicamentoiDao;
    }
    //necesito los metodos que vana  funcionar con el DAO
    public Medicamento guardarMedicamento(Medicamento medicamento){
        //quien va a encargarse de guardar un medicamento?
        return medicamentoiDao.guardar(medicamento);

    }

    public Medicamento buscarMedicamento(Integer id){
        return medicamentoiDao.buscar(id);
    }
}

package dataBaseHandler.service;

import dataBaseHandler.DAO.ResultDaoImpl;
import dataBaseHandler.ResultEntity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;

@ManagedBean()
@ApplicationScoped
public class resultServiceImpl implements resultService, Serializable {

    ResultDaoImpl resultDao = new ResultDaoImpl();

    @Override
    public void addResult(ResultEntity result) {
        resultDao.save(result);
    }

    @Override
    public void cleanResults() {
        resultDao.cleanAll();
    }


    @Override
    public void getAllResults() {
        resultDao.showAll();
    }

    @Override
    public void deleteResult(ResultEntity result) {
        resultDao.delete(result);
    }
}

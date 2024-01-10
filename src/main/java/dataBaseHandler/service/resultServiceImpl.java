package dataBaseHandler.service;

import dataBaseHandler.DAO.ResultDaoImpl;
import dataBaseHandler.ResultEntity;


public class resultServiceImpl implements resultService{
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

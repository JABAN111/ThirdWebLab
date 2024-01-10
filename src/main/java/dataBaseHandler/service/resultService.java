package dataBaseHandler.service;

import dataBaseHandler.ResultEntity;

public interface resultService {

    void addResult(ResultEntity result);
    void cleanResults();
    void getAllResults();
    void deleteResult(ResultEntity result);

}

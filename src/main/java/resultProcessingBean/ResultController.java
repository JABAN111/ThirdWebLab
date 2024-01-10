package resultProcessingBean;

import dataBaseHandler.ResultEntity;
import dataBaseHandler.service.resultService;
import dataBaseHandler.service.resultServiceImpl;
import lombok.NoArgsConstructor;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.System.exit;

@ManagedBean(name = "Controller")
@RequestScoped
@NoArgsConstructor
public class ResultController implements Serializable {

    private resultServiceImpl resultService = new resultServiceImpl();

    public void addResult(Integer x, Double y, Float R){
//        if(x != null && y != null && R != null){
            Date date = new Date();
            ResultEntity result = new ResultEntity(x,y,R,date,true);
            resultService.addResult(result);
//        }
    }
}

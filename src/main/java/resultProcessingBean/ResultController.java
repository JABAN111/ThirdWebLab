package resultProcessingBean;

import coordinateProcessing.AreaProcessing;
import dataBaseHandler.ResultEntity;
import dataBaseHandler.service.resultServiceImpl;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ManagedBean(name = "Controller", eager = true)
@ApplicationScoped
public class ResultController implements Serializable {
    @Getter
    @Setter
    private volatile List<ResultEntity> results;
    private final AreaProcessing areaProcessing = new AreaProcessing();
    private final resultServiceImpl resultService = new resultServiceImpl();
    @Getter
    @Setter
    private Integer xtest;
    @Getter
    @Setter
    private Double ytest;
    @Getter
    @Setter
    private Float rtest;
    @Getter
    @Setter
    private boolean hitStatus;
    public ResultController(){
        if(results == null)
            results = new ArrayList<>();
        getAllResults();
    }

    private void saveResultLocal(ResultEntity entity){
        if(results == null)
            results = new ArrayList<>();
        results.add(entity);
    }
    private void saveRes(Integer x, Double y, Float R){
        this.xtest = x;
        this.ytest=y;
        this.rtest=R;
    }
    private void getAllResults(){
        results = resultService.getAllResults();
    }
    public void addResult(Integer x, String y_value, Float R){
        if(y_value == null){
            System.err.println("y_value is null");
            return;
        }
        Double y = Double.parseDouble(y_value);
        System.out.println("Got data");
        System.out.println("x = " + x + " y = " + y + " R = " +R);
        if(x != null && R != null){
            saveRes(x,y,R);
            Date date = new Date();
            hitStatus = areaProcessing.areaCheck(x,y,R);
            ResultEntity result = new ResultEntity(x,y,R,date, hitStatus);
            saveResultLocal(result);
            resultService.addResult(result);
        }
        else
            System.err.println("Some info is null");

    }

    public void cleanResults(){
        if(results != null)
            results.clear();
        resultService.cleanResults();
    }
}

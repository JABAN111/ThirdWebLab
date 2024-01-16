package resultProcessingBean;

import coordinateProcessing.AreaProcessing;
import dataBaseHandler.ResultEntity;
import dataBaseHandler.service.resultServiceImpl;
import lombok.Getter;
import lombok.Setter;
import utils.DotTransformer;

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
    private void getAllResults(){
        results = resultService.getAllResults();
    }
    public void addResult(Integer x, Double y, Float R){
        if(x != null && y != null && R != null){
            Date date = new Date();
            boolean isHit = areaProcessing.areaCheck(x,DotTransformer.dotTransform(y),DotTransformer.dotTransform(R));
            ResultEntity result = new ResultEntity(x,DotTransformer.dotTransform(y),DotTransformer.dotTransform(R),date,isHit);
            saveResultLocal(result);
            resultService.addResult(result);
        }
    }
    public void cleanResults(){
        if(results != null)
            results.clear();
        resultService.cleanResults();
    }
}

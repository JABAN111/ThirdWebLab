package resultProcessingBean;

import dataBaseHandler.ResultEntity;
import dataBaseHandler.service.resultServiceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ManagedBean(name = "Controller")
@ApplicationScoped
@NoArgsConstructor
public class ResultController implements Serializable {
    @Getter
    @Setter
    private List<ResultEntity> results;
    private final resultServiceImpl resultService = new resultServiceImpl();

    /**
     * Метод для сохранения сущности внутри контроллера
     * @param entity будет передаваться при добавлении нового результата
     */
    private void saveResult(ResultEntity entity){
        if(results == null)
            results = new ArrayList<>();
        results.add(entity);
    }
    public void addResult(Integer x, Double y, Float R){
        if(x != null && y != null && R != null){
            Date date = new Date();
            //true надо заменить на отдельный класс с методом для валидации)
            ResultEntity result = new ResultEntity(x,y,R,date,true);
            saveResult(result);
            resultService.addResult(result);
        }
    }
    public void cleanResults(){
        results.clear();
        resultService.cleanResults();
    }
}

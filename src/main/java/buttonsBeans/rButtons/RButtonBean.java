package buttonsBeans.rButtons;

import lombok.Getter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@ManagedBean(name="RButton")
@SessionScoped
public class RButtonBean implements Serializable {

    private final List<RValue> availableValues;

    public RButtonBean() {
        availableValues = new ArrayList<>();
        availableValues.add(new RValue(1f,false));
        availableValues.add(new RValue(1.5f, false));
        availableValues.add(new RValue(2f,false));
        availableValues.add(new RValue(2.5f ,false));
        availableValues.add(new RValue(3f,false));
    }
    public int getCountCheckedButtons(){
        int cnt = 0;
        for(RValue value : availableValues){
            if(value.isValue())
                cnt++;
        }
        return cnt;
    }
    public Float getPickedR(){
        //придумать бы ошибочный вывод для ошибки:D
        if(getCountCheckedButtons() != 1 || getCountCheckedButtons() == 0){
            return null;
        }
        for (RValue value : availableValues){
            if(value.isValue()){
                return value.getLabel();
            }
        }
        return null;
    }
}

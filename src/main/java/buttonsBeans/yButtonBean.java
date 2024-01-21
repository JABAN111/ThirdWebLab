package buttonsBeans;


import lombok.Getter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

import static utils.DotTransformer.*;

@Getter
@RequestScoped
@ManagedBean(name = "yButton", eager = true)
public class yButtonBean implements Serializable {
    private String data;
    public void setData (String data){
        this.data = dotTransform(data) + "";
    }
}

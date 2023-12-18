package buttonsBeans;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@Data
@ManagedBean(name="rButton", eager = true)
@RequestScoped
public class rButtonBean implements Serializable {
    private boolean value1;
    private boolean value2;
    private boolean value3;
    private boolean value4;
    private boolean value5;

}

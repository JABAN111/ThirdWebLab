package buttonsBeans;


import lombok.Data;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "xButton", eager = true)
@SessionScoped
@Data
public class xButtonBean implements Serializable {
    public int data;

//    resultKeeper resultKeeper = new resultKeeper();
//    resultKeeper.addResult();

}
package dataBaseHandler;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Results")
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer x;
    private Double y;
    private Float R;
    private Date date;
    private boolean status;
    public ResultEntity(){}

}

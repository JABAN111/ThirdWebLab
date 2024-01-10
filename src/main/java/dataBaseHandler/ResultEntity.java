package dataBaseHandler;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "Results")
@NoArgsConstructor
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer x;
    private Double y;
    private Float R;
    private Date date;
    private boolean status;

    public ResultEntity(Integer x, Double y, Float r, Date date, boolean status) {
        this.x = x;
        this.y = y;
        this.R = r;
        this.date = date;
        this.status = status;
    }
}

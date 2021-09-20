package by.tunyakin.model;

import by.tunyakin.model.enums.PositionEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "positions")
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private PositionEnum position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public void setPosition(PositionEnum position) {
        this.position = position;
    }
}

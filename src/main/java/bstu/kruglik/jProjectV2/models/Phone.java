package bstu.kruglik.jProjectV2.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "laptop")
@Data
@Getter
@Setter
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Date orderDate;

    @Column
    private int cost;

    public Phone(){}

    public Phone(String name, String description, int cost, Date date)
    {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.orderDate = date;
    }

}

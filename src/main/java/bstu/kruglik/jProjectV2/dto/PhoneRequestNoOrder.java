package bstu.kruglik.jProjectV2.dto;

import lombok.Data;
import lombok.Getter;

import java.util.Date;
@Data
@Getter
public class PhoneRequestNoOrder {
    private long id;
    private String name;
    private String description;
    private int cost;
    private Date orderDate;
}

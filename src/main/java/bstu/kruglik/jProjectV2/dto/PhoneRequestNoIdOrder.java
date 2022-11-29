package bstu.kruglik.jProjectV2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PhoneRequestNoIdOrder {
    private String name;
    private String description;
    private int cost;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}

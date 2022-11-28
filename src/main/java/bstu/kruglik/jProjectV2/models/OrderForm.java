package bstu.kruglik.jProjectV2.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "user_purchases")
@Data
@Getter
@Setter
public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String userName;

    @Column
    private String userSurname;

    @ManyToOne
    @JoinColumn(name = "Phone_id")
    private Phone phone;

    @Column
    private boolean rent;

    public OrderForm(){}
    public OrderForm(User user, String userName, String userSurname, Phone phone)
    {
        this.user = user;
        this.userName = userName;
        this.userSurname = userSurname;
        this.phone = phone;
    }
}

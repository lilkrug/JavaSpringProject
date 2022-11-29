package bstu.kruglik.jProjectV2.dto;

import bstu.kruglik.jProjectV2.models.Phone;
import bstu.kruglik.jProjectV2.models.User;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Getter
public class UserOrderRequestNoId {
    @NotNull
    private User user;
    @NotNull
    @Size(min = 4 , message = "name from 4 ")
    private String name;
    @NotNull
    @Size(min = 4 , message = "surname from 4 ")
    private String surname;
    @NotNull
    private Phone Phone;
}

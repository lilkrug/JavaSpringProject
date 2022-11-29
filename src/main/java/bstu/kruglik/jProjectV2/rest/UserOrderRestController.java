package bstu.kruglik.jProjectV2.rest;

import bstu.kruglik.jProjectV2.dto.DateRequest;
import bstu.kruglik.jProjectV2.dto.IdOrderRequest;
import bstu.kruglik.jProjectV2.dto.UserOrderRequestNoId;
import bstu.kruglik.jProjectV2.models.OrderForm;
import bstu.kruglik.jProjectV2.service.UserOrderFormService;
import bstu.kruglik.jProjectV2.exception.ControllerException;
import bstu.kruglik.jProjectV2.exception.ServiceException;
import bstu.kruglik.jProjectV2.repository.UserOrderRepository;
import bstu.kruglik.jProjectV2.validator.RentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserOrderRestController {
    @Autowired
    private UserOrderFormService userOrderFormService;
    @Autowired
    private UserOrderRepository rentFormRepository;
    @Autowired
    private bstu.kruglik.jProjectV2.service.PhoneService PhoneService;
    @Autowired
    private RentValidator rentValidator;

    @PostMapping("/admin/getAllPhones")
    public ResponseEntity<?> getAllPhones(@RequestBody DateRequest dateRequest) throws ControllerException {
        try {
            return new ResponseEntity<>(userOrderFormService.getAllPhones(dateRequest.getDate()), HttpStatus.FOUND);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }

    }
    @DeleteMapping("/admin/deleteByUserIdAndScooterId")
    public ResponseEntity<?> deleteByUserIdAndScooterId() {
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PutMapping("/admin/setUserRentFormById")
    public ResponseEntity<?> setUserRentFormById(@RequestBody IdOrderRequest idOrderRequest)throws ControllerException {
        try {
            OrderForm man = userOrderFormService.getById(idOrderRequest.getId());
            userOrderFormService.setUserRentFormById(idOrderRequest.getId(), idOrderRequest.isRent());
            return new ResponseEntity<>(man, HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }

    }
//    @GetMapping("/user/getAllByUserId/{id}")
//    public ResponseEntity<?> getAllByUserId(@PathVariable(name = "id")Long id) throws ControllerException{
//        try {
//            return new ResponseEntity<>(userRentFormService.getAllByUserId(id),HttpStatus.OK);
//        } catch (ServiceException e) {
//            throw new ControllerException(e);
//        }
//    }
//    @GetMapping("/admin/getAllByRent/{data}")
//    public ResponseEntity<?> getAllByRent(@PathVariable(name = "data")boolean data) throws ControllerException{
//
//        try {
//            return new ResponseEntity<>(userRentFormService.getAllByRent(data),HttpStatus.OK);
//        } catch (ServiceException e) {
//            throw new ControllerException(e);
//        }
//    }
//    @PostMapping("/admin/isUserRentExistByScooterId")
//    public ResponseEntity<?> isUserRentExistByScooterId(@RequestBody IdRequest idRequest) throws ControllerException{
//        try {
//            if(userRentFormService.existsByScooterId(idRequest.getId())) {
//                return new ResponseEntity<>(HttpStatus.OK);
//            }
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (ServiceException e) {
//            throw new ControllerException(e);
//        }
//    }
//    @PostMapping("/user/isUserRentExistByUserId")
//    public ResponseEntity<?> isUserRentExistByUserId(@RequestBody IdRequest idRequest) throws ControllerException{
//        try {
//            if(!rentFormRepository.existsByUserId(idRequest.getId())){
//                return  new ResponseEntity<>(HttpStatus.OK);
//            }
//            return new ResponseEntity<>(HttpStatus.FOUND);
//        } catch (RepositoryException e) {
//            throw new ControllerException(e);
//        }
//    }
    @PostMapping("/user/createUserOrder")
    public ResponseEntity<?> createUserOrder(@RequestBody @Validated UserOrderRequestNoId userOrderRequestNoId, BindingResult bindingResult)throws ControllerException {
        if(!bindingResult.hasErrors()) {
            OrderForm userOrderForm = new OrderForm(
                    userOrderRequestNoId.getUser(),
                    userOrderRequestNoId.getName(),
                    userOrderRequestNoId.getSurname(),
                    userOrderRequestNoId.getPhone()
            );
            try {
                OrderForm test = new OrderForm();
                test.setId(15L);
                rentValidator.validate(test,bindingResult);
                if(bindingResult.hasErrors()) throw new ControllerException("not correct data");
                userOrderFormService.create(userOrderForm);
                return new ResponseEntity<>(userOrderForm, HttpStatus.OK);
            } catch (Exception e) {
                throw new ControllerException(e);
            }
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

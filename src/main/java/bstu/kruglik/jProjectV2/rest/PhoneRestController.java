package bstu.kruglik.jProjectV2.rest;

import bstu.kruglik.jProjectV2.dto.PhoneRequestNoIdOrder;
import bstu.kruglik.jProjectV2.dto.PhoneRequestNoOrder;
import bstu.kruglik.jProjectV2.dto.NameRequest;
import bstu.kruglik.jProjectV2.models.Phone;
import bstu.kruglik.jProjectV2.service.PhoneService;
import bstu.kruglik.jProjectV2.service.UserOrderFormService;
import bstu.kruglik.jProjectV2.exception.ControllerException;
import bstu.kruglik.jProjectV2.exception.RepositoryException;
import bstu.kruglik.jProjectV2.exception.ServiceException;
import bstu.kruglik.jProjectV2.repository.UserOrderRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class PhoneRestController {
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private UserOrderFormService userOrderFormService;
    @Autowired
    private UserOrderRepository userOrderRepository;

    private static final Logger logger = Logger.getLogger(PhoneRestController.class);

    @PostMapping("/admin/createPhone")
    public ResponseEntity<?> createPhone(@RequestBody PhoneRequestNoIdOrder phoneRequestNoIdOrder) throws ControllerException {
        Phone stuff = new Phone(
                phoneRequestNoIdOrder.getName(),
                phoneRequestNoIdOrder.getDescription(),
                phoneRequestNoIdOrder.getCost(),
                phoneRequestNoIdOrder.getOrderDate()
        );
        try {
            phoneService.create(stuff);
            return new ResponseEntity<>(stuff, HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    @DeleteMapping("/admin/deletePhoneByNameA")
    public ResponseEntity<?> deletePhoneByNameA(@RequestBody NameRequest nameRequest) throws ControllerException {
        try {
            Phone man = phoneService.getByName(nameRequest.getName());
            phoneService.deleteByName(nameRequest.getName());
            return new ResponseEntity<>(man, HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    @PutMapping("/admin/updatePhone")
    public ResponseEntity<?> updatePhone(@RequestBody PhoneRequestNoOrder PhoneRequestNoOrder)throws ControllerException {
        try {
            Phone man = phoneService.getById( PhoneRequestNoOrder.getId());
            phoneService.updatePhoneById(
                    PhoneRequestNoOrder.getId(),
                    PhoneRequestNoOrder.getName(),
                    PhoneRequestNoOrder.getDescription(),
                    PhoneRequestNoOrder.getCost()
            );
            return new ResponseEntity<>(man, HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);

        }
    }
    @DeleteMapping("/user/deletePhoneByNameU")
    public ResponseEntity<?> deletePhoneByNameU(@RequestBody NameRequest nameRequest)throws ControllerException {

        try {
            Phone man = phoneService.getByName(nameRequest.getName());
            userOrderRepository.deleteByUserName(nameRequest.getName());
            return new ResponseEntity<>(man, HttpStatus.OK);
        } catch (ServiceException | RepositoryException e ) {
            throw new ControllerException(e);

        }


    }
    @GetMapping("/admin/getAllPhonesForAdmin")
    public ResponseEntity<?> getAllPhonesForAdmin() throws ControllerException{
        try {
            return new ResponseEntity<>(phoneService.getAll(),HttpStatus.OK);
        } catch (ServiceException e) {

            throw new ControllerException(e);

        }
    }
    @PostMapping("/admin/isPhoneExistByName")
    public ResponseEntity<?> isPhoneExistByName(@RequestBody NameRequest nameRequest) throws ControllerException{
        try {
            if(!phoneService.existsByName(nameRequest.getName())){
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.FOUND);
            }
        } catch (ServiceException e) {
            throw new ControllerException(e);

        }

    }
    @GetMapping("/user/userGetPhoneByName/{name}")
    public ResponseEntity<?> userGetPhoneByName(@PathVariable(name = "name")String name)throws ControllerException {
        Phone stuff = null;
        try {
            stuff = phoneService.getByName(name);
            return new ResponseEntity<>(stuff,HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    @GetMapping("admin/adminGetPhoneByName/{name}")
    public ResponseEntity<?> adminGetPhoneByName(@PathVariable(name = "name")String name) throws ParseException, ControllerException {
        Phone stuff = null;
        try {
            stuff = phoneService.getByName(name);
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String date = simpleDateFormat.format(stuff.getOrderDate());
            System.out.println(date);
            stuff.setOrderDate(simpleDateFormat.parse(date));
            return new ResponseEntity<>(stuff,HttpStatus.OK);
        } catch (ServiceException e) {
            logger.error("Error occured");
            throw new ControllerException(e);

        }

    }
    @GetMapping("/user/getAllPhonesForUser")
    public ResponseEntity<?> getAllPhonesForUser()throws ControllerException {
        try {
            return new ResponseEntity<>(phoneService.getAll(),HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);

        }
    }
}

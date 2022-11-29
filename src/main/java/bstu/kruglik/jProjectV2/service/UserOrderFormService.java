package bstu.kruglik.jProjectV2.service;

import bstu.kruglik.jProjectV2.models.OrderForm;
import bstu.kruglik.jProjectV2.service.interfaces.IUserOrderFormService;
import bstu.kruglik.jProjectV2.exception.RepositoryException;
import bstu.kruglik.jProjectV2.exception.ServiceException;
import bstu.kruglik.jProjectV2.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserOrderFormService implements IUserOrderFormService {
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Override
    public void deleteById(Long id) {
        userOrderRepository.deleteById(id);
    }

    @Override
    public void deleteByUserIdAndScooterId(Long user_id, Long computerStuff_id) throws ServiceException {
        try {
            userOrderRepository.deleteByUserIdAndPhoneId(user_id, computerStuff_id);
        } catch (RepositoryException e) {

            throw new ServiceException(e);
        }
    }

    @Override
    public OrderForm create(OrderForm userOrderForm){
        return userOrderRepository.save(userOrderForm);
    }

    @Override
    public boolean existsByScooterId(Long computerStuff_id) throws ServiceException {
        try {
            return userOrderRepository.existsByPhoneId(computerStuff_id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public OrderForm getById(Long id)throws ServiceException {
        return userOrderRepository.getById(id);
    }

    @Override
    public List<OrderForm> getAllByUserId(Long user_id)throws ServiceException {
        try {
            return userOrderRepository.getAllByUserId(user_id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }

    @Override
    public List<OrderForm> getAllByRent(boolean rent)throws ServiceException {
        try {
            return userOrderRepository.getAllByRent(rent);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }

    @Override
    public List<OrderForm> getAllPhones(Date computerStuff_orderDate) throws ServiceException{
        try {
            return userOrderRepository.getAllByPhoneOrderDateLessThan(computerStuff_orderDate);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void setUserRentFormById(Long id, boolean rent) throws ServiceException{
        try {
            userOrderRepository.setUserRentFormById(id, rent);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }
}

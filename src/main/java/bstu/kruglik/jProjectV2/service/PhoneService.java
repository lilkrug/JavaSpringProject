package bstu.kruglik.jProjectV2.service;

import bstu.kruglik.jProjectV2.models.Phone;
import bstu.kruglik.jProjectV2.exception.RepositoryException;
import bstu.kruglik.jProjectV2.exception.ServiceException;
import bstu.kruglik.jProjectV2.repository.PhoneRepository;
import bstu.kruglik.jProjectV2.service.interfaces.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService implements IPhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public void deleteById(Long id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public Phone create(Phone Phone)throws ServiceException {
        return phoneRepository.save(Phone);
    }

    @Override
    public boolean existsByName(String name) throws ServiceException {
        try {
            return phoneRepository.existsByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Phone> getAll()throws ServiceException {
        return phoneRepository.findAll();
    }

    @Override
    public void deleteByName(String name)throws ServiceException {
        try {
            phoneRepository.deleteByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }

    @Override
    public Phone getById(Long id)throws ServiceException {
        try {
            return phoneRepository.getById(id);
        } catch (Exception e) {
            throw new ServiceException(e);

        }
    }

    @Override
    public Phone getByName(String name)throws ServiceException {
        try {
            return phoneRepository.getByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }

    @Override
    public void updatePhoneById(Long id, String name, String description, int cost ) throws ServiceException{
        try {
            phoneRepository.updatePhoneById(id, name, description, cost);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }
}

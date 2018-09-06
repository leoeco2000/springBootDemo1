package config.springsecurity.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import config.springsecurity.dao.SUserRepository;
import config.springsecurity.entity.SUser;

@Service
public class SUserService {
  @Autowired
  private SUserRepository suserRepository;// code10

  public List<SUser> findAll() {
    return suserRepository.findAll();
  }

  public SUser create(SUser user) {
    return suserRepository.save(user);
  }

  public Optional<SUser> findUserById(int id) {
    return suserRepository.findById(id);
  }

  public SUser login(String email, String password) {
    return suserRepository.findByEmailAndPassword(email, password);
  }

  public SUser update(SUser user) {
    return suserRepository.save(user);
  }

  public void deleteUser(int id) {
    suserRepository.deleteById(id);
  }

  public SUser findUserByEmail(String email) {
    return suserRepository.findUserByEmail(email);
  }


}

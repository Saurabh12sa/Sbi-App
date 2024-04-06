package in.saurabhit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.saurabhit.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	public Optional<User> findByEmailAndPassword(String email, String password);

    public Optional<User> findByEmail(String email);
  

	

	

	public Optional<User> findById(Integer userId);
   
    

}

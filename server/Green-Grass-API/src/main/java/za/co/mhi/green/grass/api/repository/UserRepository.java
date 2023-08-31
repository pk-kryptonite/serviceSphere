package za.co.mhi.green.grass.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.mhi.green.grass.api.domain.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

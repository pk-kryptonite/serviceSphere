package za.co.mhi.green.grass.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mhi.green.grass.api.domain.model.service.ServiceProvider;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

}

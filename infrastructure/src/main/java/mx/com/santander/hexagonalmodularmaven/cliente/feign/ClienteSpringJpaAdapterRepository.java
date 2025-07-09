package mx.com.santander.hexagonalmodularmaven.cliente.feign;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.cliente.adapter.entity.ClienteEntity;

@Repository
public interface ClienteSpringJpaAdapterRepository extends JpaRepository<ClienteEntity, Long> {

}
package mx.com.santander.hexagonalmodularmaven.compra.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.compra.adapter.entity.CompraEntity;

@Repository
public interface CompraSpringJpaAdapterRepository extends JpaRepository<CompraEntity,Long>{

}

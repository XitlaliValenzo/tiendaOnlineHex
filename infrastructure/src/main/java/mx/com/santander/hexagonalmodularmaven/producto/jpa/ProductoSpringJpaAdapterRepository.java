package mx.com.santander.hexagonalmodularmaven.producto.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.producto.adapter.entity.ProductoEntity;

@Repository
public interface ProductoSpringJpaAdapterRepository extends JpaRepository<ProductoEntity, Long>{

}

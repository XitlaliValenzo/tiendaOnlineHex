package mx.com.santander.hexagonalmodularmaven.productosCompra.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.productosCompra.adapter.entity.ProductosCompraEntity;

@Repository
public interface ProductosComprasSpringJpaAdapterRepository extends JpaRepository<ProductosCompraEntity, Long>{

}

package mx.com.santander.hexagonalmodularmaven.productosCompra.adapter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.com.santander.hexagonalmodularmaven.compra.adapter.entity.CompraEntity;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.entity.ProductoEntity;

@Entity
@Table(name = "productos_compra")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductosCompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoEntity producto;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private CompraEntity compra;

}

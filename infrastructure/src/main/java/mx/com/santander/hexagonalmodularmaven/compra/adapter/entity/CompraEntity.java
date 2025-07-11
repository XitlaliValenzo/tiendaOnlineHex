package mx.com.santander.hexagonalmodularmaven.compra.adapter.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.com.santander.hexagonalmodularmaven.productosCompra.adapter.entity.ProductosCompraEntity;

@Entity
@Table(name = "compra")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ProductosCompraEntity> productos;

    private BigDecimal precioTotal;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;

}

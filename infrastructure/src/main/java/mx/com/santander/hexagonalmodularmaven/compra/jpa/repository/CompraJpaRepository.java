package mx.com.santander.hexagonalmodularmaven.compra.jpa.repository;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.compra.adapter.mapper.CompraDBMapper;
import mx.com.santander.hexagonalmodularmaven.compra.jpa.CompraSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.compra.model.entity.Compra;
import mx.com.santander.hexagonalmodularmaven.compra.port.repository.CompraRepository;

@Repository
@Transactional
@RequiredArgsConstructor
public class CompraJpaRepository implements CompraRepository{

    private final CompraSpringJpaAdapterRepository compraSpringJpaAdapterRepository;
    private final CompraDBMapper compraDBMapper;

    @Override
    public Compra create(Compra compra){
        var compraToSave = compraDBMapper.toDboCreate(compra);
        var compraSaved = compraSpringJpaAdapterRepository.save(compraToSave);
        return compraDBMapper.toDomain(compraSaved);
    }

}

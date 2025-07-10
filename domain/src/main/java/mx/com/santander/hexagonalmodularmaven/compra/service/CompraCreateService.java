package mx.com.santander.hexagonalmodularmaven.compra.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.compra.model.dto.command.CompraCreateCommand;
import mx.com.santander.hexagonalmodularmaven.compra.model.entity.Compra;
import mx.com.santander.hexagonalmodularmaven.compra.port.repository.CompraRepository;

@RequiredArgsConstructor
public class CompraCreateService {

    private final CompraRepository compraRepository;

    public Compra execute(CompraCreateCommand compraCreateCommand){
        Compra compraTocreate = new Compra().requestToCreate(compraCreateCommand);
        return compraRepository.create(compraTocreate);
    }

}

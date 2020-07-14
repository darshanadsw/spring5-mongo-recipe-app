package dw.springframework.services;

import dw.springframework.commands.UnitOfMeasureCommand;
import reactor.core.publisher.Flux;

import java.util.Set;


public interface UnitOfMeasureService {

    Flux<UnitOfMeasureCommand> listAllUoms();
}

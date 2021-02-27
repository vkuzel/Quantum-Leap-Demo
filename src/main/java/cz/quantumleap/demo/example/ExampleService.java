package cz.quantumleap.demo.example;

import cz.quantumleap.core.business.ServiceStub;
import cz.quantumleap.demo.example.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class ExampleService extends ServiceStub<Example> {

    public ExampleService(ExampleDao exampleDao) {
        super(Example.class, exampleDao, exampleDao, exampleDao);
    }
}

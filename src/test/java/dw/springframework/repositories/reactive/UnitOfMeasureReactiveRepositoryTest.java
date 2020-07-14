package dw.springframework.repositories.reactive;

import dw.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureReactiveRepositoryTest {

    @Autowired
    private UnitOfMeasureReactiveRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.deleteAll().block();
    }

    @Test
    public void testCount() {
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setDescription("Desc");

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setDescription("Desc2");

        repository.saveAll(List.of(uom1,uom2)).subscribe();

        assertEquals(2,repository.findAll().count().block().longValue());

    }
}
package dw.springframework.repositories.reactive;

import dw.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest {

    @Autowired
    private CategoryReactiveRepository repository;

    @Before
    public void setUp(){
        repository.deleteAll().block();
    }

    @Test
    public void testFindAllCategories() {
        Category category = new Category();
        category.setDescription("Test");

        repository.save(category).block();

        long count = repository.count().block().longValue();
        assertEquals(1,count);
    }

    @Test
    public void findByDescription() {
        Category category = new Category();
        category.setDescription("Test");
        repository.save(category).block();

        String description = repository
                .findByDescription("Test")
                .block().getDescription();

        assertEquals("Test",description);
    }
}
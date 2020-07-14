package dw.springframework.repositories.reactive;

import dw.springframework.domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RecipeReactiveRepositoryTest {

    @Autowired
    private RecipeReactiveRepository repository;

    @Before
    public void setUp(){
        repository.deleteAll().block();
    }

    @Test
    public void testRecipeSave() {

        Recipe recipe = new Recipe();
        recipe.setDescription("Test");
        recipe.setId(UUID.randomUUID().toString());

        repository.save(recipe).block();

        long count = repository.count().block().longValue();
        assertEquals(1,count);

    }

}
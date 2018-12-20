package com.vasidzius.learnmongo.mflix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = MflixApplicationContextConfig.class)
public class MflixApplicationTests {

	@Autowired
	private MongoDbFactory mongoDbFactory;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMongoDbClient(){
			assertEquals(mongoDbFactory.getDb().getName(), "mflix");
	}

	@Test
	public void getSomething(){
		assertTrue(mongoTemplate.collectionExists("movie_initial"));
		assertFalse(mongoTemplate.collectionExists("not exist"));
	}

}


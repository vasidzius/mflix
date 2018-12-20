package com.vasidzius.learnmongo.mflix;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CitibikesApplicationContextConfig.class)
public class CitibikesApplicationTests {

	@Autowired
	private MongoDbFactory mongoDbFactory;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMongoDbClient(){
			assertEquals(mongoDbFactory.getDb().getName(), "citibike");
	}

	@Test
	public void getSomething(){
		assertTrue(mongoTemplate.collectionExists("trips"));
		assertFalse(mongoTemplate.collectionExists("not exist"));
	}

	@Test
	public void testWeek1QuizConnectingToAtlas(){
		MongoCollection<Document> trips = mongoDbFactory.getDb().getCollection("trips");
		AtomicInteger count = new AtomicInteger();
		trips.find(and(eq("start station id", 216), and(gte("tripduration", 5000), lt("tripduration", 10000)))).forEach((Consumer<Document>) document -> count.incrementAndGet());

		assertEquals(11, count.get());
	}

}


package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") // Indicates it's a test profile, so will not run the DataLoader.
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;
	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskiesByYear(){
		List<Whisky> found = whiskyRepository.findByYear(2020);
		assertTrue(found.size()>0);
	}


	@Test
	public void canGetDistilleryByRegion(){
		List<Distillery> found = distilleryRepository.findByRegion("Island");
		assertTrue(found.size()>0);
	}


	@Test
	public void canFindNameAndAgeByDistillery(){
		Distillery foundDistillery = distilleryRepository.getById(1L);
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryAndAge(foundDistillery, 15);
		assertEquals(1,foundWhiskies.size());
	}


}

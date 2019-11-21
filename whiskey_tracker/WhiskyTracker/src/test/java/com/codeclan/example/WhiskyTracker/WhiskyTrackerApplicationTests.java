package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
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
	public void findWhiskyByYear() {
		List<Whisky> found = whiskyRepository.findWhiskeyByYear(1995);
		assertEquals(25, found.get(0).getAge());
		assertEquals(12, found.get(1).getAge());
	}

	@Test
	public void findDistilleryByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Speyside");
		assertEquals("Macallan", found.get(0).getName());
		assertEquals("Balvenie", found.get(1).getName());
		assertEquals("TestName", found.get(2).getName());
	}

	@Test
	public void findSpecificWhiskyFromSpecificDistillery() {
		List<Whisky> found = whiskyRepository.findSpecificWhiskyFromSpecificDistillery("TestName", 12);
		assertEquals("TestWhisky", found.get(0).getName());
	}

	@Test
	public void findEveryWhiskyInSpecificRegion() {
		List<Whisky> found = whiskyRepository.findEveryWhiskyInSpecificRegion("TestRegion");
		assertEquals("TestWhiskyTest", found.get(0).getName());
		assertEquals("WhiskyWhisky", found.get(1).getName());
	}

	@Test
	public void findDistilleryHasWhiskyOld() {
		List<Distillery> found = distilleryRepository.findDistilleryHasWhiskyOld(12);
		assertEquals("Rosebank", found.get(0).getName());
		assertEquals("Glendronach", found.get(1).getName());
		assertEquals("TestName", found.get(2).getName());
	}

}

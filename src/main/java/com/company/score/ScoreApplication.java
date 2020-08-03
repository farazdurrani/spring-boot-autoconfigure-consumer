package com.company.score;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.company.score.autoconfigure.Score;
import com.company.score.autoconfigure.ScoreService;

@SpringBootApplication
public class ScoreApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ScoreApplication.class);

    public static void main(String[] args) {
	SpringApplication.run(ScoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
	LOG.info("Score App runnings...");
	if (Objects.nonNull(scoreService)) {
	    LOG.info("Score is: ");
	    scoreService.findScores().forEach((name, score) -> {
		LOG.info("Name: {}, Score: {}", name, score);
	    });
	    long totalScore = scoreService.findScores().values().stream().mapToLong(x -> x)
	        .sum();
	    LOG.info("Total Score: {}", totalScore);
	}
    }

    @Autowired(required = false)
    private Score scoreService;

//    For Demo
//    @Bean 
    public Score newScoreService() {
	ScoreService score = new ScoreService() {
	    public Map<String, Integer> findScores() throws IOException {
		Map<String, Integer> scoresMap = new HashMap<>();
		scoresMap.put("Faraz", 12);
		return scoresMap;
	    }
	};
	return score;
    }

}

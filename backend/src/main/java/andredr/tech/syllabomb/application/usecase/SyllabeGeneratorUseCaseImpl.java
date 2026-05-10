package andredr.tech.syllabomb.application.usecase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import andredr.tech.syllabomb.domain.port.in.SyllabeGeneratorUseCase;
import jakarta.annotation.PostConstruct;

@Service
public class SyllabeGeneratorUseCaseImpl implements SyllabeGeneratorUseCase {

    private List<String> syllabes = new ArrayList<>();

    @PostConstruct
    private void loadSyllabes() throws Exception {
        ClassPathResource resource = new ClassPathResource("syllabes.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) syllabes.add(line.trim());
            }
        }
        if (syllabes.isEmpty()) throw new IllegalStateException("syllabes.txt is empty or missing");
    }
    
    @Override
    public String generate() {
        return syllabes.get(ThreadLocalRandom.current().nextInt(syllabes.size()));
    }
    
}

package andredr.tech.syllabomb.application.usecase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import andredr.tech.syllabomb.domain.port.in.WordValidationUseCase;
import jakarta.annotation.PostConstruct;

@Service
public class WordValidationUseCaseImpl implements WordValidationUseCase {
    
    private Set<String> words = new HashSet<>();

    @PostConstruct
    private void loadWords() throws Exception {
        ClassPathResource resource = new ClassPathResource("mots-fr.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) words.add(line.trim().toLowerCase());
            }
        }
        if (words.isEmpty()) throw new IllegalStateException("mots-fr.txt is empty or missing"); 
    }

    @Override
    public boolean isValid(String word, String syllabe) {
        if(word == null || word.isBlank() || syllabe == null || syllabe.isBlank()) return false;
        String normalized = word.trim().toLowerCase();
        return normalized.contains(syllabe.toLowerCase()) && words.contains(normalized);
    }
    
}

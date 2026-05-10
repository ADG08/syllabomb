package andredr.tech.syllabomb.domain.port.in;

public interface WordValidationUseCase {
    boolean isValid(String word, String syllabe);
}

package by.training.task02.restorer;

import by.training.task02.composite.Component;
import by.training.task02.composite.Particle;

public class LexemeRestorer extends AbstractRestorer {
    @Override
    public String restore(Component element) {
        Particle lexeme = (Particle) element;
        String restoredLexeme;

            restoredLexeme = lexeme.getValue();

        return restoredLexeme;
    }
}

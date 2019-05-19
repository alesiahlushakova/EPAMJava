package by.training.task02.parser;

import by.training.task02.composite.Component;
import by.training.task02.composite.Particle;

public class LexemeParser extends AbstractParser{
    private static final String EXPRESSION_PATTERN = "^[a-z0-9_-]$";

    @Override
    public Component parse(String text) {
        Component lexeme;
        boolean isExpression = text.matches(EXPRESSION_PATTERN);
            lexeme = Particle.word(text);
        return lexeme;
    }
}

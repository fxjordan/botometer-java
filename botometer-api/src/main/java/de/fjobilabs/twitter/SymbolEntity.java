package de.fjobilabs.twitter;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface SymbolEntity extends Entity {
    
    @Override
    int getStartIndex();
    
    @Override
    int getEndIndex();
    
    /**
     * Returns the name of the symbol without $.
     *
     * @return The text of the symbol.
     */
    @Override
    String getText();
}

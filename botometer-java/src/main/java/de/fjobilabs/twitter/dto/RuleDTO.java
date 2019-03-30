package de.fjobilabs.twitter.dto;

import de.fjobilabs.twitter.Rule;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
//TODO Add ignoreUnknown=true
public class RuleDTO implements Rule {
    
    private String tag;
    private long id;
    private String idStr;
    
    public RuleDTO(Rule rule) {
        this.tag = rule.getTag();
        this.id = rule.getId();
        this.idStr = Long.toString(rule.getId());
    }
    
    @Override
    public String getTag() {
        return tag;
    }
    
    @Override
    public long getId() {
        return id;
    }
    
    /* Not a property of 'Rule' */
    public String getIdStr() {
        return idStr;
    }
}

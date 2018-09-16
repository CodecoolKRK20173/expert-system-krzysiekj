package com.codecool.expertsystem.model.parsers;

import com.codecool.expertsystem.model.containers.RuleRepository;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {
    private RuleRepository ruleRepository;
    private NodeList nodeList;

    public RuleParser(String xmlPath) {
        this.ruleRepository = new RuleRepository();
        loadXmlDocument(xmlPath);
        addRulesToRepository();        
    }

    public RuleRepository getRulesRepository() {        
        return this.ruleRepository;
    }

    private addRulesToRepository() {
        this.nodeList = document.getElementsByTagName("Rule");
        if (document.hasChildNodes()) {
            document.getChildNodes();
        }
    }
    
}
package com.codecool.expertsystem.model.parsers;

import com.codecool.expertsystem.model.containers.Answer;
import com.codecool.expertsystem.model.containers.RuleRepository;
import com.codecool.expertsystem.model.containers.Question;
import com.codecool.expertsystem.model.containers.MultipleValue;
import com.codecool.expertsystem.model.containers.SingleValue;
import com.codecool.expertsystem.model.containers.Value;

import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class RuleParser extends XMLParser {
    private RuleRepository ruleRepository;
    private NodeList nodeList;

    public RuleParser(String xmlPath) {
        loadXmlDocument(xmlPath);
        this.ruleRepository = new RuleRepository();
        this.nodeList = document.getElementsByTagName("Rule");        
        addRulesToRepository();
    }

    public RuleRepository getRuleRepository() {
        return this.ruleRepository;
    }

    private void addRulesToRepository() {

        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);

            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                Element tempElement = (Element) tempNode;

                String id = tempElement.getAttribute("id");
                String questionContent = tempElement.getElementsByTagName("Question")
                                                    .item(0).getTextContent();
                Answer answer = getAnswers(tempElement);

                Question newQuestion = new Question(id, questionContent, answer);
                this.ruleRepository.addQuestion(newQuestion);
            }
        }
    }

    private Answer getAnswers(Element tempElement) {
        Answer answer = new Answer();
        NodeList answersList = tempElement.getElementsByTagName("Selection");

        for (int count = 0; count < answersList.getLength(); count++) {
            Node answerNode = answersList.item(count);

            if (answerNode.getNodeType() == Node.ELEMENT_NODE) {
                Element answerElement = (Element) answerNode;
                Element valueNode = (Element) answerNode.getChildNodes().item(1);

                boolean answerType = Boolean.valueOf(answerElement.getAttribute("value"));                
                Value value;
                
                if (valueNode.getNodeName().equals("SingleValue")) {
                    String param = valueNode.getAttribute("value");
                    value = new SingleValue(param, answerType);    
                } else {
                    List<String> params = Arrays.asList(valueNode.getAttribute("value").split(","));
                    value = new MultipleValue(params, answerType);
                }
                answer.addValue(value);
            }
        }
        return answer;
    }
    
}
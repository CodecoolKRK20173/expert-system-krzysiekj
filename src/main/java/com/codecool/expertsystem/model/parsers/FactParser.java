package com.codecool.expertsystem.model.parsers;

import com.codecool.expertsystem.model.containers.FactRepository;
import com.codecool.expertsystem.model.containers.Fact;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class FactParser extends XMLParser {
    private FactRepository factRepository;
    private NodeList nodeList;

    public FactParser(String xmlPath) {
        loadXmlDocument(xmlPath);
        this.factRepository = new FactRepository();
        this.nodeList = document.getElementsByTagName("Fact");                
        addFactsToRepository();
    }

    public FactRepository getFactRepository() {
        return this.factRepository;
    }

    private void addFactsToRepository() {

        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);

            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                Element tempElement = (Element) tempNode;

                String id = tempElement.getAttribute("id");
                String description = tempElement.getElementsByTagName("Description")
                                                    .item(0).getTextContent();

                Fact fact = new Fact(id, description);
                setFactEvaluations(fact, tempElement);
                
                this.factRepository.addFact(fact);
            }
        }
    }

    private void setFactEvaluations(Fact fact, Element tempElement) {
        Element evaluationNode = (Element) tempElement.getElementsByTagName("Evals")
                                                      .item(0);
        NodeList evaluations = evaluationNode.getElementsByTagName("Eval");

        for (int count = 0; count < evaluations.getLength(); count++) {

            Element evaluation = (Element) evaluations.item(count);
            String id = evaluation.getAttribute("id");
            String value = evaluation.getTextContent();
            fact.setFactValueById(id, Boolean.valueOf(value));
        }
    }

}
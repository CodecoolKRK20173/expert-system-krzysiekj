package com.codecool.expertsystem.model.parsers;

import com.codecool.expertsystem.model.containers.RuleRepository;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class RuleParser extends XMLParser {
    private RuleRepository ruleRepository;
    private NodeList nodeList;

    public RuleParser(String xmlPath) {
        this.ruleRepository = new RuleRepository();
        this.nodeList = document.getElementsByTagName("Rule");
        loadXmlDocument(xmlPath);
        addRulesToRepository();        
    }

    public RuleRepository getRulesRepository() {        
        return this.ruleRepository;
    }

    private addRulesToRepository() {

        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);

            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) tempNode;

                eElement.getAttribute("id"); // id pytania np dog
                eElement.getElementsByTagName("Question").item(0).getTextContent(); // tekstowa reprezentacja pytania

        
                // get node name and value
                System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
                System.out.println("Node Value =" + tempNode.getTextContent());
        
                if (tempNode.hasAttributes()) {
        
                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();
        
                    for (int i = 0; i < nodeMap.getLength(); i++) {
        
                        Node node = nodeMap.item(i);
                        System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : " + node.getNodeValue());
        
                    }
        
                }
        
                if (tempNode.hasChildNodes()) {
        
                    // loop again if has child nodes
                    printNote(tempNode.getChildNodes());
        
                }
        
                System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
        
            }
        
            }
        
          }
        
        
        if (document.hasChildNodes()) {
            document.getChildNodes();
        }
    }
    
}
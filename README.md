# DESIGN DESCRIPTION

The Main class starts the application. Firsts it creates an ESProvider (Expert System Provider) instance. This instance expects a FactParser and a RuleParser instance as constructor parameters.

These parsers are to be used to interpret the corresponding XML files (Rules.xml and Facts.xml).

In the constructor the getRuleRepository method is called and the returned RuleRepository instance is stored as an instance field.

The RuleParser adds the questions with their corresponding id to the RuleRepository instance. This is stored in a Map inside the RuleRepository (as a field instance). The RuleRepository constructor initializes the QuestionIterator inner class that implements the Iterator interface. With this we can iterate through the questions later.

Every Question has an Answer and every Answer can have more than one Value. The Answer class has the responsibility to evaluate the answers based a given user input matched against an input pattern.

If the value is SingleValue then the user input only needs to be compared against the input pattern (with equals). If the Value is MultipleValue then we need check the input against a range (e.g. the input pattern could contain more than one elements). If the input cannot be matched successfully against any input patterns an exception is thrown.

Next the collectAnswers method is called and it initializes a Map instance field which stores the question identifiers mapped against their respective answers. The collectAnswers method iterates through the questions and asks the user each questions. Repeating the questions until a correct answer can be determined.

The possible answers for every question are defined in the Rules.xml file. Call the getEvaluateAnswer method with the given user input and if there is no exception thrown store the returned value by question id (mapping each question with the user's answer: true or false).

The RuleRepository contains an inner class (QuestionIterator) that implements the Iterator (Links to an external site.)Links to an external site. interface.

In the ESProvider's constructor we store the FactRepository instance that returned by calling the getFactRepository method of the FactParser. The parsed Facts (parsed by the FactParser) are added to the FactRepository.

If we call the evaluate method of the ESProvider then it iterates through the Facts and checks for possible matches. If it finds one then the answer it returns will be the description of the Fact otherwise null. If the return value is null then an answer couldn't be found by the expert system (maybe it needs more rules, or facts, etc.).

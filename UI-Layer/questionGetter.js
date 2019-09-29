$(document).ready(function(){
    console.log("hello world");
    var testQuestion = [{"id": "testId", 
                        "description": "This is a test question",
                        "type": "text"}];
    var questions = document.getElementById("questions");
    for(var x in testQuestion){
        var itemDescription = document.createElement("p");
        itemDescription.id = testQuestion.id;
        itemDescription.innerText = testQuestion.description;
        $(itemDescription).append(questions);
    }
});
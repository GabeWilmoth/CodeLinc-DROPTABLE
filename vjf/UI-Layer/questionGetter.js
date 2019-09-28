$(document).ready(function(){
    var testQuestion = [{
                            "wide" : "6", 
                            "id": "branchID", 
                            "description": "What branch of the military were you in?",
                            "type": "select",
                            "option": "Army",
                            "option": "Navy",
                            "option": "Air Force",
                            "option": "Marines"
                        },
                        {
                            "wide":"6",
                            "id":"oldJob",
                            "description": "What job did you have in the military?",
                            "type": "text",
                        }];
    var questions = document.getElementById("questions");

    //For each question...
    for(var x in testQuestion){
        var tq = testQuestion[x];
        
        //Create a row.
        var rows = document.createElement("div");
        $(rows).addClass("row");

        //Create columns with specific width.
        var columnsDesc = document.createElement("div");
        $(columnsDesc).addClass("col-sm-" + tq.wide);
        var columnsResp = document.createElement("div");
        $(columnsResp).addClass(" col-sm-" + tq.wide);

        //Create a description.
        var itemDescription = document.createElement("p");
        itemDescription.id = tq.id;
        itemDescription.innerText = tq.description;

        $(columnsDesc).empty().append(itemDescription);
        $(rows).append(columnsDesc);

        //Create a response.
        var response = document.createElement("input");
        response.type = tq.type;
        response.id = tq.id + 'response';

        $(columnsResp).empty().append(response);
        $(rows).append(columnsResp);

        if($(tq).has("object"))
            console.log(tq.id);
        
        //Add to the questions list
        $(questions).append(rows);
    }
});
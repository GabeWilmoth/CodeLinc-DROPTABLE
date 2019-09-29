// @author Tyler Wallschleger
$(document).ready(function(){
    var testQuestion = [{
                            "id": "branchID", 
                            "description": "What branch of the military were you in?",
                            "type": "select",
                            "options": ["Army", "Navy", "Air Force", "Marine"]
                        },
                        {
                            "id":"oldJob",
                            "description": "What job did you have in the military?",
                            "type": "text"
                        },
                        {
                            "id": "jobDescription",
                            "description": "Describe this job: ",
                            "type": "text"
                        }
                    ];
    var questions = document.getElementById("questions");

    //For each question...
    for(var x in testQuestion){
        var tqx = testQuestion[x];
        tq = new Question(tqx.id, tqx.description, tqx.type, tqx.options)
        //Create a row.
        var rows = document.createElement("div");
        $(rows).addClass("row");

        //Create columns with specific width.
        var columnsDesc = document.createElement("div");
        $(columnsDesc).addClass("col-sm-" + tq.wide);
        var columnsResp = document.createElement("div");
        $(columnsResp).addClass("col-sm-" + tq.wide);

        //Create a description.
        var itemDescription = document.createElement("p");
        itemDescription.id = tq.getId();
        itemDescription.innerText = tq.getDescription();

        $(columnsDesc).empty().append(itemDescription);
        $(rows).append(columnsDesc);

        //Create a response.
        var type = tq.getType() === "select" ? "select" : "input";
        var response = document.createElement(type);
        if(type === "input")
            response.type = tq.getType();
        response.id = tq.id + 'response';

        $(columnsResp).empty().append(response);
        $(rows).append(columnsResp);

        var opts = tq.getOptions();
        console.log(opts);
        for(var x in opts){
            var optio = document.createElement("option");
            optio.text = opts[x];
            $(response).append(optio);
        }
        
        //Add to the questions list
        $(questions).append(rows);
    }
});

class Question {
    constructor(id, description, type, options){
        this.id = id;
        this.desciption = description;
        this.type = type;
        this.options = options;
        if(options){
            for(var x in options){
                var opt = document.createElement("option");
                opt.innerText = options[x];
            }
        }
        this.wide = 6;
    }

    getId(){
        return this.id;
    }

    setId(id){
        this.id = id;
    }

    getDescription(){
        return this.desciption;
    }

    setDescription(desciption){
        this.desciption = description;
    }

    getType(){
        return this.type;
    }

    setType(type){
        this.type = type;
    }

    getOptions(){
        return this.options;
    }

    setOptions(options){
        this.options = options;
        for(var x in options){
            var opt = document.createElement("option");
            option.innerText = options[x];
        }
    }
}

function createResume(){
    var infos = getInfo();
    
}

function getJobs(){
    var infos = getInfo();
    console.log(infos);
    $.ajax({type: "POST", url: "localhost::8080/getJobTitle",data: infos}).done(function(){
        console.log("YAY");
    });
}

function getInfo(){
    var infos = document.querySelectorAll("[id*=response]");
    return infos;
}

class JobTitleRequest{
    constructor(branch, oldJob){
        this.branch = branch;
        this.oldJob = oldJob;
    }
}

class JobTitleResponse{
    constructor(newJob){
        this.newJob = newJob;
    }
}
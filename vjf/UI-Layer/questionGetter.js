// @author Tyler Wallschleger

var jobsList = [["Army","Infantry","Police Officer"],
["Army","Combat Engineer","Electrician"],
["Army","Military Police","Police Officer"],
["Army","Signal Corps","Satcom Operator"],
["Army","Air Defense","Meteorologist"],
["Navy","Air Traffic Controller","Air Traffic Controller"],
["Navy","Builders","Construction Worker"],
["Navy","Aviation Ordinance","Repair Worker"],
["Navy","Information System Technician","IT"],
["Navy","Navy Diver","Commercial Driver"],
["Air Force","In-Flight Refueling","Aircraft Cargo Supervisor"],
["Air Force","Air Traffic Controller","Air Traffic Controller"],
["Air Force","Aircrew Equipment","Mechanic"],
["Air Force","Cyberspace Defense","Computer Systems Manager"],
["Air Force","Weather","Meteorologist"],
["Marines","Infantry","Police Officer"],
["Marines","Combat Engineer","Electrician"],
["Marines","Aviation Ordinance","Avionics Technician"],
["Marines","Motor Transport","Commercial Driver"],
["Marines","Ground Ordnance Maintenance","Emergency Management Director"]];
$(document).ready(function(){
    var testQuestion = [{
                            "id": "branchID", 
                            "description": "What branch of the military were you in?",
                            "type": "select",
                            "options": ["Select", "Army", "Navy", "Air Force", "Marines"],
                            "vis": true
                        },
                        {
                            "id":"oldJob",
                            "description": "What job did you have in the military?",
                            "type": "select",
                            "options": [],
                            "vis": true
                        },
                        {
                            "id": "jobDescription",
                            "description": "Describe this job: ",
                            "type": "text",
                            "vis": false
                        },
                        {
                            "id": "firstName",
                            "description": "Enter your first name: ",
                            "type": "text",
                            "vis": false
                        },
                        {
                            "id": "lastName",
                            "description": "Enter your last name: ",
                            "type": "text",
                            "vis": false
                        },
                        {
                            "id": "email",
                            "description": "Enter your email: ",
                            "type": "text",
                            "vis": false
                        },
                        {
                            "id":"phoneNumber",
                            "description": "Enter your phone number: ",
                            "type": "text",
                            "vis": false
                        },
                        {
                            "id": "address",
                            "description": "Enter your address: ",
                            "type": "text",
                            "vis": false
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

        //Place options for first dropdown.
        var opts = tq.getOptions();
        for(var x in opts){
            var optio = document.createElement("option");
            optio.text = opts[x];
            $(response).append(optio);
        }
        
        //Add to the questions list.
        $(questions).append(rows);
        $(rows).css("display", tqx.vis ? "block": "none");
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
    console.log("getResume");
    $(".row").css("display", "block");
}

function getJobs(){
    var infos = getInfo();
    console.log(infos);
    $.ajax({type: "POST", url: "localhost::8080/getJobTitle",data: infos}).done(function(){
        console.log("YAY");
    });
}

function getInfo(){
    if(document.getElementById("branchIDresponse").selectedIndex == 0)
        return false;
    $("#jobs").css("display", "none");
    $("#resume").css("display", "none");
    var infos = document.querySelectorAll("[id*=response]");
    return infos;
}

function createJobsCSV(branch){
    $("#oldJobresponse").empty();
    for(var jo in jobsList){
        if(jobsList[jo][0] == branch){
            var optio = document.createElement("option");
            optio.text = jobsList[jo][1];
            $("#oldJobresponse").append(optio);
        }
    }
}

$(function(){
    $("#branchIDresponse").change(function(){
        var branch = $("#branchIDresponse").val();
        createJobsCSV(branch);
    });
});

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
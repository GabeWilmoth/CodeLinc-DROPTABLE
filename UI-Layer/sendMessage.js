function sendMe(){
    console.log($("#myText").val());
    if($("#myText").val().trim() != ""){
        var x = document.createElement("div");
        var y = document.createElement("p");
        $(x).addClass("myMessage");
        y.innerHTML = $("#myText").val();
        console.log(x);
        console.log(y);
        $(x).append(y);
        $($("#messages")).append(x);
    }
}
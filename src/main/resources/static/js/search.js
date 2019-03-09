
function showAllTags(){
    let tags = document.getElementsByClassName("tag");

    for (let i = 0; i < tags.length; i++){
        let tag = tags[i].innerHTML;
        tags[i].style.display = "flex";
    }

    document.getElementById("showAllTagsLink").style.display = "none";
}

let blacklist = ["suicidal thoughts", "self harm"];

window.onload = function(){
    let tags = document.getElementsByClassName("tag");
    let censorshipRequired = false;

    for (let i = 0; i < tags.length; i++){
        let tag = tags[i].innerHTML;
        if (blacklist.includes(tag)){
            tags[i].style.display = "none";
            censorshipRequired = true;
        }
    }

    if (censorshipRequired == false){
        document.getElementById("showAllTagsLink").style.display = "none";
    }
}
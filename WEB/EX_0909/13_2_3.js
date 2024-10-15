document.addEventListener("DOMContentLoaded",function(e){
    /*1. 수정버튼 누르면 이름입력칸 나오게하기*/
    let nameEditButton = document.querySelector("#nameEditButton");
    let editNameField = document.querySelector("#editNameField");

    /*2. 수정된 이름 적용 하기*/
    let okButton = document.querySelector("#okButton");
    let newName = document.querySelector("#newName");
    let nameHere = document.querySelector("#nameHere");

    /*1*/
    nameEditButton.addEventListener("click",function(e){
        editNameField.style.display="block";
        nameEditButton.style.display="none";
    })

    /*2*/
    okButton.addEventListener("click",function(e){
        nameHere.textContent=newName.value;
        editName.style.display="none";
        nameEditButton.style.display="inline";
    })

    
})
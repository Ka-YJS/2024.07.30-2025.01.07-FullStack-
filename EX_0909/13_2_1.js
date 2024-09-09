document.addEventListener("DOMContentLoaded",function(e){
    let input = document.querySelector("#input");
    input.addEventListener("click",function(e){
        console.log(e.target.getAttribute("type"));/*여기서 type은 button임*/

        /*요소의 속성 제어하기 : button -> text*/
        e.target.setAttribute("type","text");

         if(e.target.getAttribute("type")==="button"){
            e.target.setAttribute("type","text"); /*속성값 토글*/
      
        }
    })
        input.addEventListener("change",function(e){
            e.target.setAttribute("type","button");
        /*값을 입력하면 text로 변했다가 바깥쪽을 클릭하면 다시 button으로 변함*/    
        
        })
})

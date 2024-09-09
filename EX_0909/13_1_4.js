/*문제)button을 눌렀을 때 img태그의 이미지를 변경하기
profile -> hl 1 -> hl 2 -> profile*/
/*-이미지가 나오는 원리 : <img src="이미지경로">
  -버튼을 눌렀을 때 : ("click")
  -img태그의 정보를 변수에 저장함
  -변수에서  src의 값을 setAttribute()를 통해서 변경함*/

document.addEventListener("DOMContentLoaded",function(e){
    let button = document.querySelector("input");

    let img = document.querySelector("img");
    let img1 = "image/hl 1.jpg"
    let img2 = "image/hl 2.jpg"
    let img3 = "image/profile.jpg"

    button.addEventListener("click",function(e){//:img태그의 src를 수정해야 함
        let src=img.getAttribute("src")//img태그의 src속성의 값을 변수에 저장
        
        if(src===img1){
            img.setAttribute("src",img2)
        }else if(src===img2){
            img.setAttribute("src",img3)
        }else{
            img.setAttribute("src",img1)
        }
    })
})
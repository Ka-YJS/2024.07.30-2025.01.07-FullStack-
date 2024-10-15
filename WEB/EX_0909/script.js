document.addEventListener("DOMContentLoaded",function(e){
        //프로필편집//
    let configID = document.querySelector("#id i");
    let idText = document.querySelector("#id span");

    configID.addEventListener("click",function(e){
        idText.textContent=prompt('새로운 아이디를 입력하세요')
    })

    let profileEditButton = document.querySelector("#profile_info_button")

    let uesrInfo=document.querySelector("#userInfo");
    let summary=document.querySelector("#summary");
    let profileDetail=document.querySelector("#profileDetail");
    let changing = false;

    //프로필 편집 버튼을 눌렀을 때
    profileEditButton.addEventListener("click",function(e){
        if(changing){
            //input태그에 들어있는 값을 변수에 저장
            let _userInfo = uesrInfo.querySelector("input").value;
            let _summary = summary.querySelector("input").value;
            let _profileDetail = profileDetail.querySelector("input").value;

            uesrInfo.innerHTML=_userInfo
            summary.innerHTML=_summary
            /*innerHTML : 태그에 html코드를 삽입하는 도구*/

            //url의 경우 http로 시작하면 a태그를 달아줌 -> http가 아닐 경우 그냥 넣음
            if(_profileDetail.startsWith("http")){
                _profileDetail = "<a href="+_profileDetail+">"+_profileDetail+"</a>"
            }

            profileDetail.innerHTML = _profileDetail;

            //버튼의 글자를 프로필 편집으로 바꿈
            e.target.textContent="프로필편집";
            changing=false;
            /*처음엔 false가 작동에서 if(changing){}문은 작동x, 
            밑에까지 진행한 뒤에 changing=true가 되면 if문실행*/ 
        }else{
            //각각의 태그에 들어있는 내용을 변수에 저장함
            let _userInfo = uesrInfo.textContent;
            let _summary = summary.textContent;
            let _profileDetail = profileDetail.textContent;
        }
        
        //<input value="half_bottle"></input>
        uesrInfo.innerHTML = "<input value="+_userInfo+"></input>"
        summary.innerHTML = "<input value="+_summary+"></input>"
        profileDetail.innerHTML = "<input value="+_profileDetail+"></input>"

        //버튼의 글자를 "프로필 편집 완료"로 수정
        e.target.textContent="프로필 편집 완료"
        changing=true

    })

        //프로필 사진변경//
    let profile_pic = document.querySelector("#profile_pic .circle_pic")

    profile_pic.addEventListener("mouseover",function(e){
        e.target.style.filter="grayscale(50%)";//grayiscale : 흑백화시킴 -> 이건 50%만 흑백화
        /*filter : 사진에 필터를 씌위는 css속성으로 사진의 색조를 조절하는 도구임*/
    })

    profile_pic.addEventListener("click",function(e){
        profile_pic.setAttribute("src",prompt("이미지url을 입력 : "));
    })

    
})
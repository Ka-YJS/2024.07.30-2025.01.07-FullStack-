 //document 객체를 대상으로 하는 이벤트리스너를 추가함 -> 이벤트 종류는 DOMContentLoaded
    document.addEventListener("DOMContentLoded",
        //HTML코드가 로딩된 다음 처리 할 작업 :         
        function(e){
            //input태그를 찾아 button 변수에 저장
            let button = document.querySelector("input");
                //button변수에 이벤트 리스너 추가 + 이벤트 종류는 "input"
                button.addEventListener("input",
                    function(e){
                        console.log(e.target.value);
                    });
    })

/*<p>태그에서 인라인 이벤트 모델로 호출할 함수를 정의함
->함수의 이름은 hi, alert()를 띄워 "hi"라는 글자를 출력하기*/
    function hi(){
        alert("hi");
    }
document.addEventListener("DOMContentLoaded",function(e){
    /*DOMContentLoaded : 브라우저가 HTML을 전부 읽고 DOM 트리를 완성하는 즉시 발생*/ 
    let keydown = document.querySelector("#keydown")
    /*keydown : 변수에 키가 눌렸을 때 메서드를 실행한다*/
    keydown.addEventListener("keydown",function(e){/*addEventListener : 명령입력 */
        /*input태그 안에 담겨있는 값을 console에 출력*/
        console.log(e.key);
        /*1. e.target.value->e.key : key를 누르면 어떤 키보드를 눌렀는지 출력*/
        /*2. q를 눌렀을 때 "This is Q"라는 문구를 가진 경고창 띄우기 -> if문 활용*/
        if(e.key==='q'){
            alert("This is Q")
        }   
    })
    
    //change 이벤트 만들고, e.target.value 콘솔에 출력하기
    let change = document.querySelector("#change")
    change.addEventListener("change",function(e){
        console.log(e.target.value);
    })/*change의 경우 내용이 변경되고 포커스가 벗어나면 적용됨*/

    //input 이벤트 만들고, e.target.value 콘솔에 출력하기
    let input = document.querySelector("#input")
    input.addEventListener("input",function(e){
        console.log(e.target.value);
    })

})
//var
var v1 = 100;
var v1 = "Hello";
console.log(v1);//100이 아닌 Hello가 출력됨

function a(){var variable =1;}
//console.log(variable); : 출력할 수 없음 -> 지역변수 취급이라 밖에서 사용 불가능

//let
let i1;
let i2;

//재대입 가능
i1 = 100;
i1 = 'abc';
i1 = false;
//but. 다시 le i1;을 하려고하면 오류 -> 재선언은 불가능

//const
//const c; : 선언만 하는 것이 불가능, 초기화만 가능함 -> 재대입 불가능
const c = 100;//자바에서 상수와 비슷함

//--------------------------------------

if(true){var variable=1;}
console.log(variable);//1을 출력함

function a(){let l3=100;}
//console.log(l3); -> 출력x
if(true){let l3=100;}
//console.log(l3); -> 이 경우도 출력안됨, 지역변수취급받음

//--------------------------------------

console.log(vari);
var vari;//출력값 : undifined

//--------------------------------------

console.log(b);
//ReferenceError: Cannot access 'b' before initialization -> b초기화전까지는 출력할 수 없음
let b; //여기서 초기화 단계 실행, b에 undefined를 암묵적으로 할당
console.lob(b); //undifined

//--------------------------------------

//const c; // SyntaxError: Missing initializer in const declaration
console.log('const : '+c1);//초기화가 아래에서 진행되어 여기c1에는 아무 값도 들어가있지 않음
const c1 = 1;//초기화가 된 시점

//ReferenceError가 아닌 SyntaxError임. 문법적으로 옳지 않다는 뜻임

console.log(c); //ReferenceError: Cannot access 'c' before initialization
//const c = 1;
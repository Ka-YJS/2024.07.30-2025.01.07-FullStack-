//산술연산자
let l1 = 10;
let l2 = 7;

console.log(l1+l2);
console.log(l1-l2);
console.log(l1*l2);
console.log(l1/l2);
console.log(l1%l2);

//---------------------------------------------

//대입연산자
let A = 3;
let B = A;

console.log('B : '+B);

A += B	//A = A + B
A *= B	//A = A * B
A /= B	//A = A / B
A %= B

//---------------------------------------------

var a = 5;
var b = ++a;
console.log('b:'+b);
var b = a++;
console.log('b:'+b);//6
console.log('a:'+a);//7

//---------------------------------------------

var a = 10;
var b = 7;

console.log(a>b);//true
console.log(10=='10');//java에선 false값이지만 여기서는 true가 나옴
console.log(10==='10');//값과 데이터타입까지 일치해야 true나옴 -> 출력값 : false
console.log("!= : "+(10!='10'));//false
console.log("!== : "+(10!=='10'));//true
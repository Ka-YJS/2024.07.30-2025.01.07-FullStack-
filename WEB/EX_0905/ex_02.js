console.log();

//String()
console.log(String(3));
console.log(typeof(String(3)));
console.log(String(3)+1);

//Number()
console.log(Number(3)+1);
console.log(Number(false));//출력값 : 0
console.log(Number('abc'));//출력값 : NaN(Not a Number)

//Boolean()
console.log(Boolean(0));//출력값 : false
console.log(Boolean(NaN));//출력값 : false
console.log(Boolean(1));//출력값 : true
console.log(Boolean(3));//출력값 : true -> 1보다 크면 true
console.log(Boolean("a"));//출력값 : true
console.log(Boolean("x"));//출력값 : true
console.log(Boolean("false"));//출력값 : true -> 생긴건 false지만 문자열이므로 true

//인덱싱과 슬라이싱
console.log("abcd"[2]);//출력값 : c
console.log("abcdefgh".slice(3,5));//출력값 : de -> 뒤에 번호는 5가 아닌 5-1=4이므로 de출력함

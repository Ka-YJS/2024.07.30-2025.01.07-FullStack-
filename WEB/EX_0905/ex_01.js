console.log(typeof(32));
console.log('abc'+'def');

//1. 문자열 길이
console.log('text'.length);

//2. 문자열이 특정 문자로 시작하는지를 검사
console.log('text'.startsWith('te'));
console.log('text'.startsWith('xt'));

//3. 문자열이 특정 문자로 끝나는지를 검사
console.log('text'.endsWith('te'));
console.log('text'.endsWith('xt'));

//4. 특정문자의 index위치 찾기
console.log('text'.indexOf('x'));
console.log('text'.indexOf('a'));//:없는 값을 입력하면 -1를 반환

//5. 특정 문자열의 반복
console.log('abc'.repeat(3));

//6. 문자열을 다른 문자열로 대체
console.log('hello world'.replace('hello','bye'));

//7. 문자열을 특정문자를 기준으로 잘라서 저장
console.log('abcabcdabcde'.split('a'));//출력값 : [ '', 'bc', 'bcd', 'bcde' ]

//8. 대문자/소문자로 바꾸기
console.log('abc'.toUpperCase());
console.log('ABC'.toLowerCase());

//Boolean
console.log(true+1);//출력값 : 2
console.log(false+1);//출력값 : 1

//undefined
let i;//:선언만 함
console.log(i);
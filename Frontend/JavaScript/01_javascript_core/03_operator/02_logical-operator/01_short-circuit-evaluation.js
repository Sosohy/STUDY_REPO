/* 01. short-circuit-evaluation(논리 연산자) */

/* 표현식을 평가하는 도중 평가 결과가 확정된 경우 나머지 평가 과정을 생략하는 것 */

/* 1. OR의 경우 */

// 'apple', 'banana'은 비어있지 않은 문자열 -> Truthy -> true||true인 셈이다. 
console.log('apple' || 'banana');   // apple -> 첫번째 true가 판단 근거니까 apple이 나옴
console.log('' || 'banana')         // banana
console.log('apple' || false)       // apple 
console.log('-----------');

/* AND의 경우 */
console.log('apple' && 'banana');   // banana
console.log(false && 'banana');     // false
console.log('apple' && false);      // false
console.log('-----------');

var num = 1;

/*
if(num%2 == 0) {
    console.log('짝수');
}else{
    console.log('홀수');
}
*/

/* 단축 평가를 활용하여 같은 결과를 얻을 수 있다. */
num % 2 == 0 && console.log('짝수');
num % 2 == 0 || console.log('홀수');
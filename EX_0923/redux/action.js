//액션(Action): 상태를 변경하는 이벤트

//'INCREMENT'라는 타입의 액션을 반환하는 함수
export const increment = () => ({
    type: 'INCREMENT', // 액션의 타입을 'INCREMENT'로 정의. 
    // 이 액션은 리듀서에서 상태를 증가시키기 위한 신호로 사용됨
  }); 
  
  //'DECREMENT'라는 타입의 액션을 반환하는 함수
  export const decrement = () => ({
    type: 'DECREMENT', // 액션의 타입을 'DECREMENT'로 정의. 
    //이 액션은 리듀서에서 상태를 감소시키기 위한 신호로 사용됨
  });
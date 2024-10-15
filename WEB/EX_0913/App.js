import React from 'react';
import logo from './logo.svg';
import './App.css';
import Sol1 from './Sol1';
import Sol2 from './Sol2';
import Sol3 from './Sol3';
import MyComponent from './UseEffectSpace';

function App() {

  return (
    <div className="App">
      <Sol3 />
       {/*3. : div안쪽 내용 다 지우고 <??? />작성해주기 
              ->??? : Sol1, Sol2, Sol3
        + <React.StricMode> : 이 태그는 애플리케이션의 잠재적인 문제를 알아내기 위한 도구로,
                            위에 나오는 <div>안에 넣어주고 Sol3을 실행시키면 "랜더링 완료"가 2번씩 실행됨*/}
    </div>
  );
}

export default App;

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
              ->??? : Sol1, Sol2, Sol3*/}
    </div>
  );
}

export default App;

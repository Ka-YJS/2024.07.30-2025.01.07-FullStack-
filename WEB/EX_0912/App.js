import logo from './logo.svg';
import Todo from './Todo'; // Todo 컴포넌트 import
//import Count from './count';//:props에 값을 넣으면서 주석처리함
import React,{useState} from 'react';
import { Container, List, Paper} from "@mui/material";
import './App.css';
import AddTodo from './AddTodo'

// 컴포넌트 : 페이지에 렌더링할 React 엘리먼트를 반환하는 작고 재사용 가능한 코드조각
function App() {    
  // JSX문법 : 자바스크립트 코드 안에 HTML코드가 들어가는것
  // Babel : JSX로 작성된 자바스크립트를 순수 자바스크립트로 만들어주는 라이브러리
  const[items,setitems] = useState([]
    // [{id:"0", title:"Hello world 1", done:true},
    //  {id:"1", title:"Hello world 2", done:false}//:useState값을 배열[]로 묶음
    // ] -> 추가와 삭제기능을 만들었으므로 값을 비워서 빈 리스트로 초기화 함
  )

  //내용추가하기 : 전체 데이터를 App.js에서 관리하기때문에 관련 함수를 여기에 작성해야함
  const addItem = (item) => {
    item.id = "ID-" + items.length;//key를 위한 id
    item.done = false;//done초기화
    setitems([...items, item])//... : 스프레드 연산자
    console.log("items : ", items);
  };

  //내용 삭제하기 : 전체 데이터를 App.js에서 관리하기때문에 관련 함수를 여기에 작성해야함
  const deleteItem = (item) => {//삭제할 아이템 찾기
    const newItems = items.filter(e => e.id !== item.id);
    //삭제할 아이템을 제외한 아이템을 다시 배열에 저장함
    setitems([...newItems]);
  }
  /*생각해보기)App.js에서 Todo에 delete 어떻게 연결할지 생각해보기*/

  let todoItems = items.length > 0 && (
    <Paper style={{margin:16}}>
      <List>
      {items.map((item) =>(
        <Todo item={item} key={item.id} deleteItem={deleteItem}/>
      ))}
      </List>
    </Paper>
  );
  //: map()안에 함수가 들어가있는 형태임
  /*map() : 반복문 안에 들어있는 내용을 하나씩 꺼내서 처리함
    key : 요소의 리스트를 만들 때, React에서 컴포넌트를 렌더링했을 때 어떤 아이템이 변경되었는지
          빠르게 감지하기 위해 사용함. 만약 key가 설정되지않았다면 가상DOM을 순차적으로 
          비교하면서 감지하기때문에 KEY가 없을때보다 속도가 느림.*/
  /*실행순서
  1 items.map((item)의 내부 item실행
  2 Todo item={item} key={item.id} 값이 적용됨
  3 2번의 값이 item으로 들어옴*/        


  return (
    <div className="App">
      <Container maxWidth="md">
        <AddTodo addItem = {addItem}/>
      {/* props를 컴포넌트에 전달하기
      이름={useState값} */}
      <div className="TodoList">{todoItems}</div>
      </Container>
    </div>
  );
}


// 해당 파일에서는 하나의 컴포넌트만은 내보낸다.
// export default 구문을 사용해 내보낸 컴포넌트는 중괄호({})를 사용하지 않고
// 불러올 수 있으며, 이를 또한 원하는 이름으로 바꿔서 불러올 수 있다.
export default App;

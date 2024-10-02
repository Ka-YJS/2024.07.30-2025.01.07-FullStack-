import React,{useState} from "react"
import { ListItem,ListItemText,InputBase,Checkbox,
        ListItemSecondaryAction, IconButton} from "@mui/material";
import DeleteOutlined from "@mui/icons-material/DeleteOutlined";

/*<<함수생성방법>>
1. function 함수명(){}
2. let 함수명 = function(){}
   위를 람다식으로 바꾸면
   let 함수명 = () => {}
*화살표 함수 규칙
-매개변수가 1개면 소괄호 생략가능
-명령이 한줄이면서 return이 있다면, 중괄호와 return 둘 다 생략 가능
*/ 

const Todo = (props) => {
    const[item,setitem] = useState(props.item)
    // item : 상태를 추적할 객체, setitem : 업데이트함
    //props에 값이 들어오면 props.item을 지나 앞에 item로 값이 들어감 -> 입력된값적용
    const deleteItem = props.deleteItem;
    const [readOnly, setReadOnly] = useState(true);
    const editItem = props.editItem;

    //editEventHandler 작성
    const editEventHandler = (e) => {
        // item.title = e.target.value;
        // editItem();
        setitem({...item,title:e.target.value});
    }

    //checkboxEventHandler 작성
    const checkboxEventHandler = (e) => {
        item.done = e.target.checked;
        editItem(item);//App.js의 editItem의 매개변수에 전달됨
    }

    //deleteEventHandler 작성
    const deleteEventHandler = () => {
        deleteItem(item);//여기서 item은 삭제하려고하는 값으로 todo에 전달
    }

    //turnOffReadOnly 함수 작성 -> 내용쪽을 클릭했을 때 수정 가능 한 상태로 만들기
    const turnOffReadOnly = () => {
        setReadOnly(false);
    }
    //turnOnReadOnly 함수 작성
    const turnOnReadOnly = (e) => {
        // if(e.key==='Enter'){
        //     setReadOnly(true);
        // }
        if(e.key === 'Enter' && readOnly === false){
            setReadOnly(true);
            editItem(item);
         }
    }

    return(
        <ListItem>
            <Checkbox checked={item.done} onChange={checkboxEventHandler}/>
            <ListItemText>
                <InputBase 
                    inputProps={{"aria-label":"naked", readOnly : readOnly}}
                    onClick={turnOffReadOnly} onKeyDown={turnOnReadOnly} onChange={editEventHandler}
                    type="text" id={item.id} name={item.id} value={item.title}
                    multiline={true} fullWidth={true}/>
            </ListItemText>
            <ListItemSecondaryAction>
                <IconButton aria-label="Delete Todo"
                onClick={deleteEventHandler}>
                    <DeleteOutlined />                    
                </IconButton>
            </ListItemSecondaryAction>
        </ListItem>
        )
}

export default Todo;

/*실습1)Todo컴포넌트를 하나 더 추가하고, item을 하나 더 만들어서 넘기기
    -id : "1"
    -title : "Hello world 2"
    -done : false
  실습2)Todo를 두개 연속으로 늘어놓는 대신, 배열과 반복문을 이용하자 */ 
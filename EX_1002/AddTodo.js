import React, {useState} from "react";
import {Button, Grid, TextField} from "@mui/material";

const AddTodo = (props) => {
    const [item, setItem] = useState({title : " "});
    const addItem = props.addItem;//:새로운 객체를 배열에 추가해주는 메서드

    //onButtonCllick 함수 작성 -> 더하기버튼 누르면 호출됨
    const onButtonCllick = () => {
        addItem(item);
        setItem({title : ""});//입력하면 title에 값이 들어감
    }

    //onInputChange함수 작성 -> 입력이 감지될 때마다 실행되는 함수
    const onInputChange = (e) => {
        setItem({title : e.target.value});
        console.log(item);
    }//값을 입력하면 개발자도구中console부분에서 글자가 입력됨

    //enterKeyEventHandler 함수작성
    const enterKeyEventHandler = (e) => {
        if(e.key==='Enter'){
            onButtonCllick();
        }
    }

    return(
        <Grid container sytle={{marginTop:20}}>
            <Grid xs={11} md={11} item style={{paddingRight:16}}>
                <TextField placeholder="Add Todo Here" fullWidth
                onChange={onInputChange} onKeyDown={enterKeyEventHandler}
                value={item.title} />
            </Grid>
            <Grid xs={1} md={1} item>
                <Button fullWidth style={{height : '100%'}} color="secondary"
                variant="outlined" onClick={onButtonCllick}>
                    +
                </Button>
            </Grid>
        </Grid>
    )
}

export default AddTodo;
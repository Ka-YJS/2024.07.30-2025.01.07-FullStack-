import React,{useState} from "react";
import styled,{ThemeProvider} from "styled-components";
import { theme } from "./Theme";
import { Dimensions, StatusBar } from "react-native";
import Input from "./components/Input";
import IconButton from "./components/IconButton";
import { images } from "./Image";
import Task from "./components/Task";
import AsyncStorage from "@react-native-async-storage/async-storage";
import AppLoading from "expo-app-loading";

const Container = styled.SafeAreaView`
    flex : 1;
    background-color: ${({theme}) => theme.background};
    align-items : center;
    justify-content : flex-start;
    `

const Title = styled.Text`
    font-size : 40px;
    font-weight : 600;
    color : ${({theme}) => theme.main};
    align-self : flex-start;
    margin : 20px;
`

const List = styled.ScrollView`
    flex : 1;
    width : ${({width}) => width -40}px;
`


export default function App(){

    //로딩상태를 관리할 state
    const[isReady, setIsReady] = useState(false);

    const[newTask, setNewTask] = useState('');

    const [tasks,setTasks] = useState({});

    const width = Dimensions.get('window').width;

    const _saveTasks = async tasks => {
        try {
            //AsyncStorage : 저장공간임
            //JSON.stringify() : JS객체를 JSON형식으로 변환
            await AsyncStorage.setItem('tasks',JSON.stringify(tasks));
            setTasks(tasks);
        } catch (e) {
            console.log(e);
        }
    }

    const _loadTask = async tasks => {
        const loadedTasks = await AsyncStorage.getItem('tasks');
        //JSON.parse() : JSON형식을 JS객체로 변환
        setTasks(JSON.parse(loadedTasks || '{}'));
    }


    //TODO 추가
    const _addTask = () => {
        //Id는 현재 날짜를 문자열로 만들어서 넣기
        const ID = Date.now().toString();
        //'ID' : {id:'xx', text:'xxx', completed:false}
        //[ID] : 객체의 키로 사용할 값을 동적으로 설정
        const newTaskObject 
            = {[ID]:{id:ID, text:newTask, completed:false}}
            setNewTask('');
            _saveTasks({...tasks, ...newTaskObject});
    }

    //TODO 삭제
    const _deleteTask = id => {
        //tasks를 복사하여 새로운 객체를 만듦
        const currentTask = Object.assign({}, tasks);
        //currentTask객체에서 특정 작업을 삭제
        delete currentTask[id];
        //업데이트된 객체를 설정하여 state에 삭제된 작업을 반영함
        _saveTasks(currentTask);
    }

    //TODO 완료
    const _toggleTask = id => {
        //task에 있는 모든 todo를 복사에서 currentTask에 대입함
        const currentTask = Object.assign({}, tasks);
        //클릭한 todo의 completed속성을 true->false, false->true로 바꿈
        currentTask[id]['completed'] = !currentTask[id]['completed'];
        //tasks상태에 반영시킴
        _saveTasks(currentTask);
    }

    const _handleTextChange = text =>{
        setNewTask(text);
    }

    //수정완료된 TODO를 Task에 저장하기
    const _updateTask = item => {
        //객체복사
        const currentTask = Object.assign({}, tasks);
        //수정된 내용 저장
        currentTask[item.id] = item;
        _saveTasks(currentTask);
    }

    //입력취소
    const _onBlur = () => {
        setNewTask('');
    }

    return isReady ?(
        <ThemeProvider theme={theme}>
            <Container>
                <Title>TODO LIST</Title>
                    <StatusBar
                        barStyle = "light-content"
                        backgroundColor={theme.background} />
                    <Input placeholder="+Add Task"
                        value={newTask}
                        onChangeText={_handleTextChange}
                        onSubmitEditing={_addTask}/>
                    <List width={width}>
                        {Object.values(tasks)
                        .reverse()
                        .map(item => (
                            <Task key={item.id} item={item}
                                deleteTask={_deleteTask}
                                toggleTask={_toggleTask}
                                updateTask={_updateTask}/>
                        ))}
                    </List>
            </Container>
        </ThemeProvider>
    ) : (
        <AppLoading
            startAsync={_loadTask}
            onFinish={() => setIsReady(true)}
            onError={console.error} />
    )
}
import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Button } from 'react-native';
import MyButton from './components/MyComponent';
import Counter from './components/Counter';
import ToggleText from './components/Toggle';
import Total from './components/Total';
import ItemLists from './components/ItemLists';
import EventButton from './components/EventButton';
import EventInput from './components/EventTextInput';

const App = () => {

    let arr = [1,2,3,4,5,6,7,8,9,10]

    const fruits = ['사과','바나나','당근','키위','복숭아','딸기']

    return(
        <View
            style={{
                flex:1,
                backgroundColor:'#fff',
                alignItems: 'center',
                justifyContent: 'center'
            }}
        >
            <Text style={{fontSize:30, marginBottom:10}}>Button Component</Text>
            {/* <Button title="button" onpress={()=> alert('Click!!')}/> */}
            {/* <MyButton title="button" onpress={()=> alert('props')}/> */}
            {/* 부모컴포넌트에서 자식 컴포넌트를 사용하면서 속성으로 props를 전달하는
             방법 외에 값을 입력해서 전달하는 방법도 있음 */}
            {/* <MyButton title="button" onpress={()=> alert('Children')}/>
            <MyButton  onPress={()=> alert('default')}/> */}
            {/* <Counter title="button" onpress/> */}
            <ToggleText />
            <Total arr={arr} />
            <ItemLists item={fruits} />
            <EventButton />
            <EventInput />
        </View>
    )
}

export default App;
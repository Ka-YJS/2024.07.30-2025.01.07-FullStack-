//MainScreen 컴포넌트를 name = "Main"으로 주고 화면띄우기
import React from "react";
import { createStackNavigator } from "@react-navigation/stack";
import MainScreen from "../screens/MainScreen";
import WriteScreen from "../screens/WriteScreen";
import { Pressable, View, Text, StyleSheet } from "react-native";
//헤더를 게시판 백그라운드색깔과 일치, 헤더를 가운데 정렬, 헤더타이틀 흰색
import {AntDesign} from '@expo/vector-icons'

const Stack = createStackNavigator();
const BoardStack = () => {

    

    return(
        <Stack.Navigator
            screenOptions={{
                headerStyle : {
                    backgroundColor : '#1e1e1e'
                },
                headerTitleStyle : {
                    color : 'white'
                },
                headerTitleAlign : 'center',
            }}>
            <Stack.Screen name="Main" component={MainScreen}
                options={{
                    title : '게시글목록',
                }}/>
            <Stack.Screen name="Write" component={WriteScreen}
                options={({navigation}) => ({
                    title : '글쓰기',
                    headerLeft : () => (
                        <Pressable onPress={() => navigation.goBack()} style = {{marginLeft : 20}}>
                            <AntDesign name = "close" size={24} color={'white'}/>
                        </Pressable>
                    ),
                })}/>
        </Stack.Navigator>
    )


}


export default BoardStack;
import React from "react";
import { createStackNavigator } from "@react-navigation/stack";
import Home from "../screens/Home";
import List from "../screens/List";
import Item from "../screens/Item";
import {MaterialCommunityIcons} from '@expo/vector-icons';
import { Platform } from "react-native";
/*vector-icons
-Expo프로젝트에서 기본으로 제공하는 라이브러리
-많이 사용되는 아이콘이 있음*/

const Stack = createStackNavigator();//네비게이션생성

/*생성된 스택 네비게이션에는 화면을 구성하는 Screen컴포넌트와
Screen컴포넌트를 관리하는 Navigator컴포넌트가 있음*/
const StackNavigation = () => {
    return(
        <Stack.Navigator initialRouteName="Home"
            screenOptions={{cardStyle:{backgroundColor:'#ffffff'},
            headerStyle : {
                height : 110,
                backgroundColor : '#95a5a6',
                borderBottomWidth : 5,
                borderBottomColor : '#334495e',
            },
            headerTitleStyle : {color : '#ffffff', fontSize : 24},
            headerTitleAlign : 'center',
            headerTitle : ({style}) => (
                <MaterialCommunityIcons name="react" style={style} />
            )
            }}>

            <Stack.Screen name="Home" component={Home} 
                options={{headerShown : false}}/>
                {/* options={{headerMode : 'none'}} -> 위에 대신 이것도 가능*/}
            <Stack.Screen name="List" component={List} 
                options={{headerTitle:'List Screen',
                          headerBackTitleVisible : true,
                          headerBackTitle : 'Prev',
                          headerTitleStyle : {fontSize : 24},
                          headerTintColor : '#e74c3c',
                          headerBackImage : ({tintColor}) => {
                            const style = {
                                marginRight : 5,
                                marginLift : Platform.OS === 'ios' ? 11 : 0,
                            }
                            return(
                                <MaterialCommunityIcons
                                    name="keyboard-backspace"
                                    size={30}
                                    color={tintColor}
                                    style={style} />
                            )
                          }//headerBackImage
                }}/>
            <Stack.Screen name="Detail" component={Item} />

        </Stack.Navigator>
    )
}
export default StackNavigation;
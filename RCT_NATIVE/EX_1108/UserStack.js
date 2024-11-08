import React from "react";
import { createStackNavigator } from "@react-navigation/stack";
import {MaterialCommunityIcons} from '@expo/vector-icons';
import { Platform } from "react-native";
import { HomeScreen,UserListScreen,UserProfileScreen } from "../screens/UsersScreen";

//1. 스택생성 : 스택으로부터 Navigator, Screen컴포넌트를 사용할 수 있음
const UserStack = createStackNavigator();



const UserStackNavigator = () => {
    return(
        <UserStack.Navigator>
            <UserStack.Screen name="UserHome" component={HomeScreen}/>
            <UserStack.Screen name="UserList" component={UserListScreen}/>
            <UserStack.Screen name="UserProfile" component={UserProfileScreen}/>
        </UserStack.Navigator>
    )
}
export default UserStackNavigator;
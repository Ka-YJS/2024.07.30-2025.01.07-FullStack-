import React from "react";
import { Mail,Meet,Settings } from "../screens/TabScreens";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import {MaterialCommunityIcons} from "@expo/vector-icons"

//이름, 크기, 색깔만 주면 아이콘 컴포넌트를 만들어주는 함수
const TabIcon = ({name, size, color}) => {
  return <MaterialCommunityIcons name={name} size={size} color={color}/>
}//screenOptions_TabIcon를 주거나 스크린마다 options을 넣어서 할당해줄 수 있음


//1. Tab네비게이션 생성
const Tab = createBottomTabNavigator();

const TabNavigator = () => {
    return(
        <Tab.Navigator initialRouteName="Mail"
          screenOptions={({route}) => ({
            tabBarIcon : props => {
              let name='';
              if(route.name === 'Mail') name='email';
              else if(route.name === 'Meet') name='video';
              else name='cogs'
              return TabIcon({...props, name})
            },
            tabBarLabelPosition : 'beside-icon', //전체에만 적용가능
            tabBarShowLabel : false, //false를 주면 글자안보임
            tabBarStyle : {
              backgroundColor : 'white',//#54b7f9
              borderTopColor : '#ffffff',
              borderTopWidth : 2,
            },
            tabBarActiveTintColor : '#54b7f9',
            tabBarInactiveTintColor : '#0b92e9'
          })}>
            <Tab.Screen name="Mail" component={Mail}
              options={{
                tabBarLabel:'Inbox',
                tabBarIcon : props => TabIcon({
                  ...props, name : props.focused ? 'email' : 'email-outline'})
              }}
              // options={{
              //   tabBarIcon : props => TabIcon({...props, name : 'email'})
              // }} 
              />
            <Tab.Screen name="Meet" component={Meet}
              options={{
                tabBarLabel:'video',
                tabBarIcon : props => TabIcon({
                  ...props, name : props.focused ? 'video' : 'video-outline'})
              }}
              // options={{
              //   tabBarIcon : props => TabIcon({...props, name:'video'})
              // }}
              />
            <Tab.Screen name="Settings" component={Settings}
              options={{
                tabBarLabel:'Inbox',
                tabBarIcon : props => TabIcon({
                  ...props, name : props.focused ? 'cog' : 'cog-outline'})
              }}
              // options={{
              //   tabBarIcon : props => TabIcon({...props, name:'cat'}),
              // }}
              />
        </Tab.Navigator>
    )
}

export default TabNavigator
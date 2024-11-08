import React from "react";
import { HomeScreen, CartScreen, ProfileScreen } from "../screens/ShopScreens";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import {MaterialCommunityIcons} from "@expo/vector-icons"

const TabIcon = ({name, size, color}) => {
  return <MaterialCommunityIcons name={name} size={size} color={color}/>
}


const Shop = createBottomTabNavigator();

const ShopNavigator = () => {
    return(
        <Shop.Navigator initialRouteName="HomeScreen"
          screenOptions={({route}) => ({
            tabBarIcon : props => {
              let name='';
              let size=24;
              if(route.name === 'HomeScreen') name='home';
              else if(route.name === 'CartScreen') name='cart';
              else name='person'
              return TabIcon({...props, name})
            },
            tabBarLabelPosition : 'below-icon',
            tabBarShowLabel : true,
            tabBarStyle : {
              backgroundColor : 'white',
              borderTopColor : '#ffffff',
              borderTopWidth : 2,
              
            },
            tabBarActiveTintColor : 'blue',
            tabBarInactiveTintColor : 'gray'
          })}>
            <Shop.Screen name="HomeScreen" component={HomeScreen}
              options={{
                tabBarLabel:'Home',
                tabBarIcon : props => TabIcon({
                  ...props, name : props.focused ? 'home' : 'home-outline'})
              }}/>
            <Shop.Screen name="CartScreen" component={CartScreen}
              options={{
                tabBarLabel:'Cart',
                tabBarIcon : props => TabIcon({
                  ...props, name : props.focused ? 'cart' : 'cart-outline'})
              }}
              />
            <Shop.Screen name="ProfileScreen" component={ProfileScreen}
              options={{
                tabBarLabel:'Profile',
                tabBarIcon : props => TabIcon({
                  ...props, name : props.focused ? 'card-account-phone' : 'card-account-phone-outline'})
              }}/>
        </Shop.Navigator>
    )
}

export default ShopNavigator
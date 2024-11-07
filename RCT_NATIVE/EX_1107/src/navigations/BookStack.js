import React from "react";
import { createStackNavigator } from "@react-navigation/stack";
import BookDetailScreen from "../screens/BookDetailScreen"
import BookListScreen from "../screens/BookListScreen"
import BookMainScreen from "../screens/BookMainScreen"
import {MaterialCommunityIcons} from '@expo/vector-icons';
import { Platform } from "react-native";

const Stack = createStackNavigator();

const BookStack = () => {
    return(
        <Stack.Navigator initialRouteName="BookMainScreen"
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
                <MaterialCommunityIcons name="book-multiple" style={style} />
            )
            }}>

            <Stack.Screen name="BookMainScreen" component={BookMainScreen} 
                options={{headerShown : false}}/>
            <Stack.Screen name="BookListScreen" component={BookListScreen} 
                options={{headerTitle:'List Screen',
                          headerBackTitleVisible : true,
                          headerBackTitle : 'Prev',
                          headerTitleStyle : {fontSize : 24},
                          headerTintColor : 'black',
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
            <Stack.Screen name="Detail" component={BookDetailScreen} />

        </Stack.Navigator>
    )
}
export default BookStack;
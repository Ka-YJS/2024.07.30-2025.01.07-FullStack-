/*이벤트 : 사용자의 행동에 따라 상호작용하는 모든 것으로,
많은 종류의 이벤트가 존재하고, 컴포넌트의 역할에 따라 제공되는 이벤트도 약간씩의 차이가 있음
*/

import React,{useState} from "react";
import { Pressable, View,Text } from "react-native";

const EventButton = () => {

    const _onPressIn = () => console.log('Press In!!!\n');
    const _onPressOut = () => console.log('Press Out!!!\n');
    const _onPress = () => console.log('Press!!!\n');
    const _onLongPress = () => console.log('Long Press!!!\n');


    return(
        <Pressable
            style={{
                backgroundColor: '#f1c40f',
                padding: 16,
                margin: 10,
                borderRadius: 8
            }}
        delayLongPress={3000}//3초
        onPress={_onPress}
        onPressIn={_onPressIn}
        onPressOut={_onPressOut}
        onLongPress={_onLongPress}
        >
            <Text style={{color:'white',fontSize:24}}>Press</Text>

        </Pressable>
    )


}


export default EventButton;

/*
클릭했을 때 :
-onPressIn > onPressOut > onPress 또는
 onPressIn > onLongPress > onPressOut
-onLongPress는 길게 눌러야 출력됨*/
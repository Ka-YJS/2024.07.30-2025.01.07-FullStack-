import React from "react";
import { createDrawerNavigator, DrawerContent, DrawerContentScrollView, DrawerItemList } from "@react-navigation/drawer";
import HomeScreen from "../screens/HomeScreen";
import ProfileScreen from "../screens/ProfileScreen";
import {MaterialCommunityIcons} from '@expo/vector-icons';
import { StyleSheet, View, Text, TouchableOpacity } from "react-native";

const Drawer = createDrawerNavigator();

/*props로 전달되는 내용
-navigation
-state : drawer의 현재상태에 대한 정보가 담긴 객체, 어떤 스크린이 포함되어 있는지,
현재 활성화된 스크린을 확인하거나 특정 스크린에 상태에 따라 UI를 변경할 때 사용함
-description : 각 스크린에 대한 설정정보들이 담겨있는 객체,
각 항목에 대한 옵션/아이콘/라벨 등을 포함함
-drawer항목들*/

const CustomerDrawerContent = (props) => {
    return(
        /*DrawerContentScrollView : Drawer내용을 스크롤할 수있는 컴포넌트로
        기본드로어 항목을 감싸고 추가 컨텐츠를 넣을 수 있음*/
        <DrawerContentScrollView {...props} contentContainerStyle={styles.DrawerContent}>
            {/* 커스텀드로어의 헤더영역 */}
            <View style={styles.header}>
                <Text style={styles.headerText}>My Custom Drawer</Text>
            </View>
            {/* 기본드로어메뉴항목 표시 : 드로어에 설정된 스크린 목록을 보여줌 */}
            {/* DrawerItemList : Drawer.Screen으로 추가된 목록을 표시해주는 컴포넌트 */}
            <DrawerItemList {...props}/>
            {/* 위에 <DrawerItemList {...props}/>의 내용은 아래와같이 보면됨
                <DrawerItemList 
                state={props.state}
                descriptors={props.descriptors}
                navigation={navigation}/> */}

            {/* 커스텀버튼 */}
            <TouchableOpacity
                style={styles.customButton}
                onPress={() => alert("Custom Button Pressed")}>
                    <MaterialCommunityIcons name="star" size={24} color="white"/>
                    <Text style={styles.customButtonText}>CustomButton</Text>
                </TouchableOpacity>
        </DrawerContentScrollView>
    )
}

const DrawerNavigation = () => {
    return(
        <Drawer.Navigator
        drawerContent={(props) => <CustomerDrawerContent {...props}/>}
            screenOptions={({navigation})=>({
                drawerStyle:{
                    backgroundColor: '#e6e6e6',//배경색
                    width:240,//drawer너비
                    borderWidth:5, //drawer테두리두께
                    borderColor:'#3498db'},//drawer테두리색상
                drawerLabelStyle:{fontSize: 18,},//drawer글씨스타일
                drawerActiveTintColor : '#4CAF50',//선택된메뉴색상
                drawerInactiveTintColor : '#757575',//선택안된메뉴색상
                headerLeft:() => null,//헤더왼쪽
                drawerPosition : "right",//서랍나오는위치 
                headerTitle:"Drawer Test",//헤더제목
                headerTitleAlign:'center',//헤더제목위치
                headerStyle:{//헤더스타일
                    backgroundColor:'#4CAF50'
                },
                headerTitleStyle:{
                    fontSize:24,//폰트크기
                    fontWeight:'bold',//폰트두께
                    color:'#fff',//폰트색상
                },
                headerRight: ()=>(//헤더오른쪽
                    <TouchableOpacity 
                        onPress={() => navigation.toggleDrawer()}
                        style={{marginRight: 15}}
                    >
                        <MaterialCommunityIcons name="menu" size={28} color="black"/>
                    </TouchableOpacity>
                ),
                drawerType:'slide',//서랍이 열리면서 뒤화면도 밀림

            })}>
            <Drawer.Screen name="Home" component={HomeScreen}
                //메뉴에 아이콘넣기
                options={{
                    drawerIcon:({color, size}) => (
                        <MaterialCommunityIcons name="home" color={color} size={size}/>
                    )
                }}/>
            <Drawer.Screen name="Profile" component={ProfileScreen}
                options={{
                    drawerIcon:({color, size}) => (
                        <MaterialCommunityIcons name="account" color={color} size={size}/>
                    )
                }}/>
        </Drawer.Navigator>
    )
}

const styles = StyleSheet.create({
    drawerContent: {
        flex:1,
    },
    header: {
        padding:20,
        backgroundColor:'#4CAF50',
        alignItems:'center',
    },
    headerText: {
        color:'white',
        fontSize:20,
        fontWeight:'bold',
    },
    customButton: {
        flexDirection:'row',
        alignItems:'center',
        padding:15,
        margin:10,
        backgroundColor:'#4CAF50',
        borderRadius:8,
    },
    customButtonText: {
        color:'white',
        marginLeft:10,
        fontSize:16,

    }
})

export default DrawerNavigation
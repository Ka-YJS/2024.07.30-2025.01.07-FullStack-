import React, { useLayoutEffect } from 'react';
import styled from 'styled-components/native';
import { MaterialCommunityIcons } from '@expo/vector-icons';

const Container = styled.View`
  flex: 1;
  justify-content: center;
  align-items: center;
`;
const StyledText = styled.Text`
  font-size: 30px;
  margin-bottom: 10px;
`;

const BookDetailScreen = ({navigation, route}) => {

    useLayoutEffect(() => {
        navigation.setOptions({
            headerBackTitleVisible : false,
            headerBackTintColor : '#ffffff',
            headerLeft : ({onPress, tintColor}) => {
              return(
                <MaterialCommunityIcons
                name="keyboard-backspace"
                size={30}
                style={{marginLeft:11}}
                color={tintColor}
                onPress={onPress}/>
              )
          },//headerLeft
          headerRight : ({tintColor}) => (
            <MaterialCommunityIcons
              name="home-variant"
              size={30}
              style={{marginRight:11}}
              color={tintColor}
              onPress={() => navigation.popToTop()} />
          )//headerRight
        })//setOptions
    },[])//useLayoutEffect

  return (
    <Container>
      <StyledText>Book</StyledText>
      <StyledText>ID : {route.params.id}</StyledText>
      <StyledText>도서 제목 : {route.params.title}</StyledText>
      <StyledText>상세 정보 : {route.params.description}</StyledText>
    </Container>
  );
};

export default BookDetailScreen;
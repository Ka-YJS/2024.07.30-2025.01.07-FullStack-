import React from 'react';
import { Button } from 'react-native';
import styled from 'styled-components';

const Container = styled.SafeAreaView`
  flex:1;
  align-items: center;
  align-items : center;
  `;
const StyledText = styled.Text`
  font-size: 30px;
  margin-bottom: 10px;
`;

const BookMainScreen = ({ navigation }) => {
  return (
    <Container>
      <StyledText>Home</StyledText>
      <Button title="도서목록보기"
      onPress = {() => navigation.navigate('BookListScreen')}/>
    </Container>
  );
};

export default BookMainScreen;
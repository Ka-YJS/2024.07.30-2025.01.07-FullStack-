import React from 'react';
import { Button } from 'react-native';
import styled from 'styled-components';

const Container = styled.View`
  flex: 1;
  justify-content: center;
  align-items: center;
`;
const StyledText = styled.Text`
  font-size: 30px;
  margin-bottom: 30px;
`;

const book = [
  {id:'1', title: '홍길동전', description: '이것은 홍길동전의 설명입니다.'},
  {id:'2', title: '콩쥐팥쥐', description: '이것은 콩쥐팥쥐의 설명입니다.'},
  {id:'3', title: '신데렐라', description: '이것은 신데렐라의 설명입니다.'},
  {id:'4', title: '우투리전', description: '이것은 우투리전의 설명입니다.'},
  {id:'5', title: '운수좋은날', description: '이것은 운수좋은날의 설명입니다.'},
];

const BookListScreen = ({navigation}) => {

  const _onPress = item => {
    navigation.navigate('Detail', {id : item.id, title: item.title, description : item.description })
  };

  return (
    <Container>
      <StyledText>List</StyledText>
      {book.map(item => (
        <Button
          key={item._id}
          title={item.title}
          onPress={() => _onPress(item)}
        />
      ))}
    </Container>
  );
};

export default BookListScreen;
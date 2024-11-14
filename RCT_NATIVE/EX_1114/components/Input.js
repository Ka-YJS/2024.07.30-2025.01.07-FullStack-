import React, { useState, forwardRef } from 'react';
import styled from 'styled-components/native';
import PropTypes from 'prop-types';


//스타일 컴포넌트 만들기

//모든요소를 감싸는 컴포넌트
const Container = styled.View`
  flex-direction: column;
  width: 100%;
  margin: 10px 0;
`;
//TextInput안에 쓰이는 글씨
const Label = styled.Text`
  font-size: 14px;
  font-weight: 600;
  margin-bottom: 6px;
  color: ${({ theme, isFocused }) => (isFocused ? theme.text : theme.label)};
`;

//TextInput 컴포넌튼
const StyledTextInput = styled.TextInput.attrs(({ theme }) => ({
  placeholderTextColor: theme.inputPlaceholder,
}))`
  background-color: ${({theme}) => theme.background};
  color: ${({ theme }) => theme.text};
  padding: 20px 10px;
  font-size: 16px;
  border: 1px solid
    ${({ theme, isFocused }) => (isFocused ? theme.text : theme.inputBorder)};
  border-radius: 4px;
`;

/*forwardRef : React에서 특정 컴포넌트가 받은 ref를 자식 컴포넌트의 특정DOM요소나
React Native컴포넌트로 전달할 수 있도록 하는 기능
->forwardRef((props,ref)=>{});
const input2 = ({label, value, onChangeText}) => {
  label, value
  }
const input3 = ({label, value, onChangeText, ref}) => {
  label, value
  } -> 껍데기만 넘김
but. forwardRef를 사용하면 기능도 함께 넘김
*/

const Input = forwardRef(
    ({
        label,
        value,
        onChangeText,
        onSubmitEditing,
        onBlur,
        placeholder,
        isPassword,
        returnKeyType,
        maxLength,
      }, ref) => {
    const [isFocused, setIsFocused] = useState(false);
    return (
      <Container>
        <Label isFocused={isFocused}>{label}</Label>
        <StyledTextInput
          ref={ref}//login에서 정의된 useRef전달
          isFocused={isFocused}//해당input이 포커스가 된 상태냐
          value={value}//호출한쪽에서 넘어온값
          onChangeText={onChangeText}//호출한쪽에서넘어온함수
          onFocus={() => setIsFocused(true)}//input태그에 포커스가 잡혔을 때 실행
          onBlur={() => {//포커스가 해제됐을 때 실행되는 함수
            setIsFocused(false);
            onBlur();//PropType에 디폴트로 설정한값실행
          }}
          placeholder={placeholder}
          secureTextEntry={isPassword}//비밀번호숨김
          returnKeyType={returnKeyType}//키보드에서 완료버튼이 어떤것으로 보일것인지
          maxLength={maxLength}//input태그에 최대 몇글자까지 할 것인지
          autoCapitalize="none"//첫번째 입력글자 대문자
          autoCorrect={false}
          textContentType="none"//iOS only, 옵션에 따라 뜨는 키보드가 달라짐
          underlineColorAndroid="transparent"//Android only
          //컴포넌트의 밑줄색상을 설정할 때 사용
        />
      </Container>
    );
  }
)

Input.defaultProps = {
  onBlur: () => {},
};

Input.propTypes = {
  label: PropTypes.string.isRequired,
  value: PropTypes.string.isRequired,
  onChangeText: PropTypes.func,
  onSubmitEditing: PropTypes.func,
  onBlur: PropTypes.func,
  placeholder: PropTypes.string,
  isPassword: PropTypes.bool,
  returnKeyType: PropTypes.oneOf(['done', 'next']),
  //done 또는 next 중에 하나만 들어오라는 의미
  maxLength: PropTypes.number,
};

export default Input;
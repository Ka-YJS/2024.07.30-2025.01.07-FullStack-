import React from 'react';
import styled from 'styled-components/native';
import PropTypes from 'prop-types';

//이미지를 어떻게 보여줄지에대한 컴포넌트라고 볼 수 있음

const Container = styled.View`
  align-self: center;
  margin-bottom: 30px;
`;
const StyledImage = styled.Image`
  background-color: ${({ theme }) => theme.imageBackground};
  width: 100px;
  height: 100px;
`;

const Image = ({ url, imageStyle}) => {
    return (
      <Container>
        <StyledImage source={{uri:url }} style={imageStyle} />      
      </Container>
    );
  };
  
  
  Image.propTypes = {
    uri: PropTypes.string,
    //uri에 들어오는 값은 string이어야 함
    imageStyle: PropTypes.object,
  };
  
  export default Image;
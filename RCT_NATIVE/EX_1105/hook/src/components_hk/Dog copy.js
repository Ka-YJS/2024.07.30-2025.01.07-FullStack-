import React from "react";
import styled from "styled-components";
import { useFetch } from "../hooks/UseFetch";

const StyledImage = styled.Image`
    background-color : #7f8c8d;
    width : 300px;
    height : 300px;
`;

const ErrorMessage = styled.Text`
    font-size : 18px;
    color : #e74c3c;
`;

//요청할 URL -> 랜덤강아지이미지
const URL = 'https://dog.ceo/api/breeds/image/random';

const Dog = () => {
    const {data, error} = useFetch(URL);

    return(
        <>
            <StyledImage source={data?.message ? { uri : data.message} : null} />
            <ErrorMessage>{error ?.message} </ErrorMessage>
        </>
    )
}

export default Dog;
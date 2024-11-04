import React, { useState } from "react";
import styled from "styled-components";
import Counter from "./components_hk/Counter";
import Form from "./components_hk/Form";
import Button from "./components_hk/Button";
import Timer from "./components_hk/Timer";
import Length from "./components_hk/Length";

const Container = styled.View`
    flex : 1;
    background-color : #fff;
    justify-content : center;
    align-items : center;
`

const App = () => {

    const [isVisible, setIsVisible] = useState(true);

    return(
        <Container>
            {/* <Counter /> */}
            {/* <Form /> */}
            {/* -버튼을 누르면 Form컴포넌트를 보였다가 숨겼다가 할 수 있음 
                -버튼의 타이틀은 hide 또는 show로 바꾸기*/}
            {/* <Button 
                title={isVisible ? 'Hide' : 'Show'}
                onPress={() => setIsVisible(prev => !prev)} />
            {isVisible && <Form />} */}
            {/* <Timer /> */}
            <Length />
        </Container>
    )
}

export default App;
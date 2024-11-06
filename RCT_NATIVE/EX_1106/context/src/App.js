import React from 'react';
import styled from 'styled-components';
import User from './components/User';
import UserContext,{UserProvider} from './contexts/User';
import Input from './components/Input';
import ThemeProvider from './theme/ThemeContext';
import ThemedComponent from './theme/ThemedComponent';
import { CartProvider } from './contexts/Cart';
import CartScreen from './contexts/CartScreen';
import {UserProvider2} from './context/UserContext2';
import HomeScreen from './context/HomeScreen';


const Container = styled.View`
    flex : 1;
    background-color : #ffffff;
    justify-content : center;
    align-items : center;
`

const App = () => {
    return (
        <UserProvider2>
            <Container> 
                {/* <User />
                <Input /> */}
                {/* <ThemedComponent /> */}
                <HomeScreen />
            </Container>

        </UserProvider2>
    )
}

export default App;
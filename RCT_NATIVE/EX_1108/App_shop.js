import React from 'react';
import styled from 'styled-components';
import { NavigationContainer } from '@react-navigation/native';
import ShopNavigator from './navigations/ShopStack';

const Container = styled.View`
    flex : 1;
    background-color : #ffffff;
    justify-content : center;
    align-items : center;
`

const App = () => {
  return (
    <NavigationContainer>
        <ShopNavigator />
    </NavigationContainer>
  );
};

export default App;
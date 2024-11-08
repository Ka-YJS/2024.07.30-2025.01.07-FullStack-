import React from 'react';
import styled from 'styled-components';
import { NavigationContainer } from '@react-navigation/native';
import TabNavigator from './navigations/Tab';

const Container = styled.View`
    flex : 1;
    background-color : #ffffff;
    justify-content : center;
    align-items : center;
`

const App = () => {
  return (
    <NavigationContainer>
        <TabNavigator />
    </NavigationContainer>
  );
};

export default App;
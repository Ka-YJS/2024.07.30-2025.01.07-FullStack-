import React from 'react'
import {ScrollView, Text, View} from 'react-native'
import { textStyles, viewStyles } from './styles'
import { header, Contents, Footer, Header } from './components/Layout'
import FlexDirectionTest from './components/FlexDirectionTest'
import JustifyContents from './components/justifyContent'
import AlignItems from './components/AlignItems'
import ShadowBox from './components/ShadowBox'
import styled from 'styled-components'
import { Styled } from './components/StyledComponent'
import Button from './components/Button'
import SignUp from './Signup'

const Container = styled.View`
    flex: 1;
    background-color: #ffffff;
    align-items: center;
    justify-contents: center;
    `

export default function App(){
    return(
            <SignUp />

    )
}
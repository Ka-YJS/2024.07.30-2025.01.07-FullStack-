import React, { useState, useEffect } from 'react';
import { StatusBar, Image } from 'react-native';
import { Asset } from 'expo-asset';
//이미지, 오디오, 동영상 등 다양한 리소스를 관리하고 미리 로드할 수 있도록 도와줌
import * as Font from 'expo-font';
//사용자정의글꼴을 미리 로드하고 사용할 수 있음
import * as SplashScreen from 'expo-splash-screen'; //expo-splash-screen을 불러옴
import { ThemeProvider } from 'styled-components/native';
import { theme } from './Theme';
import Navigation from './navigations/Index';
import { images } from './utils/Images';


//스플래시 화면이 자동으로 숨겨지지 않도록 설정하여 초기화 작업이 완료될 때까지 유지함
SplashScreen.preventAutoHideAsync();

const cacheImages = images => {
    //이미지 캐싱 함수: 문자열로 전달된 URL 이미지와 로컬 파일 이미지에 따라 각각 적절한 캐싱 방식으로 처리
    return images.map(image => {
        if (typeof image === 'string') {
            return Image.prefetch(image); //URL로 제공된 이미지의 경우, Image.prefetch로 캐싱
        } else {
            return Asset.fromModule(image).downloadAsync(); //로컬 파일의 경우, expo-asset에서 제공하는 다운로드 방식으로 캐싱
        }
    });
};

const cacheFonts = fonts => {
    //폰트 캐싱 함수 : 폰트 배열을 받아 각 폰트를 로드
    return fonts.map(font => Font.loadAsync(font));
};

const App = () => {

    const [isReady, setIsReady] = useState(false);
    //초기화 여부를 추적하는 상태 변수

    useEffect(() => {
        //useEffect에서 비동기 함수 호출하여 리소스를 로드
        const prepareResources = async () => {
            try {
                await _loadAssets(); //리소스를 로드하는 비동기 함수 호출
            } catch (error) {
                console.log(error); //오류 발생 시 경고 메시지 출력
            } finally {
                setIsReady(true); //로딩이 완료되면 isReady를 true로 설정
                await SplashScreen.hideAsync(); //스플래시 화면 숨김
            }
        };

        prepareResources(); //준비 함수(비동기함수) 호출
    }, []); //빈 의존성 배열을 전달하여 컴포넌트가 마운트될 때 한 번만 실행

    const _loadAssets = async () => {
        //이미지와 폰트를 캐싱하여 리소스를 로드
        const imageAssets = cacheImages([
            require('../assets/splash.png'),
            ...Object.values(images),
            //스프레드연산자를 사용하여 안에있는 내용물을 배열로 받음
        ]);
        //로컬 스플래시 이미지 캐싱
        const fontAssets = cacheFonts([]);
        //추가적인 폰트가 있다면 이 배열에 추가 가능

        await Promise.all([...imageAssets, ...fontAssets]);
        //모든 비동기 작업이 완료될 때까지 기다림
    };

    if (!isReady) {
        return null; //로딩이 완료되지 않은 경우 화면을 빈 상태로 유지
    }

    return(
        //로딩 완료 시 앱의 실제 UI를 렌더링
        <ThemeProvider theme={theme}>
        {/* ThemeProvider내에 있는 애들은 theme를 전부 쓸 수 있음 */}
            {/* dark-content : 글자와 아이콘이 어두운 색상으로 나옴 */}
            <StatusBar barStyle='dark-content' />
            <Navigation />
        </ThemeProvider>
    )
}

export default App;
import * as firebase from 'firebase'
import config from '../../firebase.json'

/*
-initializeApp()메서드
-firebase는 전달된 설정을 기반으로 객체를 생성함
->이후 app을 통해서 firebase의 인증, 데이터베이스, 스토리지 등의 서비스를 이용할 것임*/

const app = firebase.initializeApp(config);
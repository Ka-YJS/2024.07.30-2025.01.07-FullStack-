import {initializeApp} from 'firebase/app'
import { getAuth,signInWithEmailAndPassword,
    createUserWithEmailAndPassword, updateProfile, signOut } from 'firebase/auth';
import { getStorage, uploadBytes, ref, getDownloadURL } from 'firebase/storage';
import config from '../../firebase.json'

//initializeApp()메서드
//firebase는 전달된 설정을 기반으로 객체를 생성한다.
//이후 app을 통해서 firebase의 인증, 데이터베이스, 스토리지등의 서비스를 이용할 것이다.
const app = initializeApp(config);

const auth = getAuth(app);

const uploadImage = async uri => {
    //만약 URI가 이미 HTTPS로 시작하는 웹 URL이면 업로드하지않고 그대로 반환
    if(uri.startsWith('https')){
        return URL;
    }
    //로컬파일 URI인 경우, fetch를 통해 이미지데이터를 불러오고 blob형태로 반환
    const response = await fetch(uri);
    const blob = await response.blob();

    //현재 로그인된 사용자의 ID(UID)를 가져옴
    const{uid} = auth.currentUser;

    //Firebase의 Storage인스턴스를 가져오고, 저장할 파일의 참조를 생성함
    const storage = getStorage(app);
    const storageRef = ref(storage, `/profile/${uid}/photo.png`);

    //지정한 참조에 blob데이터를 image/png형식으로 업로드
    await uploadBytes(storageRef, blob, {
        contentType : 'image/png',
    }
)
    //업로드된 파일의 다운로드URL을 가져와 반환함
    return await getDownloadURL(storageRef);
}


//signInWithEmailAndPassword
//이메일과 비밀번호를 이용해 인증받는 함수
export const login = async({email, password}) => {
    const {user} = await signInWithEmailAndPassword(auth,email, password);

    return user;
}

//회원가입함수
export const signup = async({name, email, password, photoUrl}) => {
    //이메일과 비번으로 사용자추가
    const {user} = await createUserWithEmailAndPassword(auth, email, password);
    
    //주어진 photoUrl에서 uri를 반환하여 저장
    const PhotoUrl = await uploadImage(photoUrl);
    
    //Firebase의 스토리지에 업로드
    await updateProfile(auth.currentUser, {displayName:name, photoUrl:PhotoUrl,});

    return user;
}

export const logout = async () => {
    await signOut();
    return {};
}
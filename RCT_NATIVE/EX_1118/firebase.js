import {initializeApp} from 'firebase/app'
import { 
    getAuth,
    signInWithEmailAndPassword,
    createUserWithEmailAndPassword,
    updateProfile, 
    signOut} from 'firebase/auth';
import { 
    getStorage,
    uploadBytes,
    ref, 
    getDownloadURL} from 'firebase/storage';

import { initializeFirestore, collection, doc, setDoc } from 'firebase/firestore';

import config from '../../firebase.json'

//initializeApp()메서드
//firebase는 전달된 설정을 기반으로 객체를 생성한다.
//이후 app을 통해서 firebase의 인증, 데이터베이스, 스토리지등의 서비스를 이용할 것이다.
const app = initializeApp(config);

const auth = getAuth(app);

const uploadImage = async uri => {
    //만약 URI가 이미 HTTPS로 시작하는 웹 URL이면, 업로드하지않고 그대로 반환
    if(uri.startsWith('https')){
        return URL;
    }
    //로컬파일 URI인 경우, fecth를 통해 이미지 데이터를 불러오고 blob형태로 변환
    const response = await fetch(uri);
    const blob = await response.blob();

    //현재 로그인된 사용자의 ID(uid)를 가져온다.
    const {uid} = auth.currentUser;

    //Firebase의 Storage인스턴스를 가져오고, 저장할 파일의 참조를 생성
    const storage = getStorage(app);
    const storageRef = ref(storage, `/profile/${uid}/photo.png`);

    //지정한 참조에 blob데이터를 image/png 형식으로 업로드
    await uploadBytes(storageRef, blob, {
        contentType: 'image/png',
    });

    //업로드된 파일의 다운로드URL을 가져와 반환
    return await getDownloadURL(storageRef)

}


//signInWithEmailAndPassword
//이메일과 비밀번호를 이용해 인증받는 함수
export const login = async({email, password}) => {
    const {user} = await signInWithEmailAndPassword(auth,email, password);

    return user;
}

//회원가입 함수
export const signup = async({name,email,password,photoUrl}) => {
    //이메일과 비밀번호로 사용자 추가
    const {user} = await createUserWithEmailAndPassword(auth, email,password);

    //주어진 photoUrl에서 uri을 반환하여 저장
    const PhotoUrl = await uploadImage(photoUrl);

    //Firbase의 스토리지에 업로드
    await updateProfile(auth.currentUser, {displayName:name,photoURL:PhotoUrl});

    return user;
}

//로그아웃
export const logout = async () => {
    await signOut(auth);
    return {};

}

//현재 로그인한 유저의 정보를 불러오는 함수
export const getCurrentUser = () => {
    const {uid,displayName,email,photoURL} = auth.currentUser;
    return {uid,displayName,email,photoURL};
}

//다른 사진을 업로드할 수 있게 수정해주는 함수
//auth.currentUser -> 현재 로그인한 user의 정보
export const updateUserInfo = async photo => {
    const photoUrl = await uploadImage(photo);
    await updateProfile(auth.currentUser,{photoUrl});
    return photoUrl;
}

export const db = initializeFirestore(app, {
    experimentalForceLongPolling: true,
    useFetchStreams: false,
    cacheSizeBytes: -1, // 오프라인 캐시 비활성화
  });
  
//채널을 생성하는 함수
export const createChannel = async ({ title, description }) => {
    const channelCollection = collection(db, 'channels');
    const newChannelRef = doc(channelCollection);
    const id = newChannelRef.id;
    const newChannel = {
        id,
        title,
        description,
        createdAt: Date.now(),
    };
    await setDoc(newChannelRef, newChannel);
    return id;
};

export const createMessage = async ({channelId, text}) => {
    //특정채널의 메세지 컬렉션 안에 새로운 메세지문서의 레퍼런스를 생성
    
    const docRef = doc(db, `channels/${channelId}/messages`);
    const  id = docRef.id;
    const newMessage = {
        id, text, createdAt : Date.now(),
    }

 /*   생성된 문서 레퍼런스에 메세지 데이터를 저장
    -> 기존 메세지 객체의 모든속성을 복사하고 createAt필드를 현재시간으로 추가*/
    await setDoc(docRef, newMessage);
}
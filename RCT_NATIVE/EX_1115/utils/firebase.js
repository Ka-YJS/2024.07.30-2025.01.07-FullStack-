import {initializeApp} from 'firebase/app'
import { getAuth,signInWithEmailAndPassword,
    createUserWithEmailAndPassword, updateProfile, signOut } from 'firebase/auth';
import { getStorage, uploadBytes, ref, getDownloadURL } from 'firebase/storage';
import config from '../../firebase.json'
import { getFirestore, collection, doc, setDoc } from 'firebase/firestore';

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

//로그아웃
export const logout = async () => {
    await signOut();
    return {};
}

//현재로그인한 유저정보 불러옴
export const getCurrentUser = () => {
    const {uid, displayName, email, photoURL} = auth.currentUser
    return {uid, displayName, email, photoURL};
}

//다른사진을 업로드할 수 있게 수정
export const updateUserInfo = async photo => {
    const photoUrl = await uploadImage(photo);
    await updateProfile(auth.currentUser, {photoUrl});
    //auth.currentUser : 현재 로그인한 user정보
    return photoUrl;
}

const db = getFirestore(app);

//새로운 채널을 생성하는 함수
export const createChannel = async({title, description}) => {
    
    /*FireStore에서 'channels' 컬렉션을 참조
    -collection(db, 'channels') : 
    ->데이터베이스객체 db와 컬렉션이름으로 사용할 channels를 입력받아 
    특정컬렉션을 가르킴*/
    const channelCollection = collection(db, 'channels');
    
    /*새문서참조생성(랜덤ID가 자동으로 할당됨)
    -doc(channelCollection) : 컬렉션에서 새로운 문서를 위한 참조를 생성함
    -이렇게 생성된 참조는 아직 데이터베이스에 저장되지않은 상태임*/
    const newChannelRef = doc(channelCollection);
    
    //새문서의 ID를 추출함
    const id = newChannelRef.id;

    //새 채널데이터를 객체로 구성
    const newChannel = {
        id, //새로 생성된 문서의 고유 ID
        title, //채널제목
        description, //채널설명
        createdAt : Date.now(), //생성시간(현재타임스탬프)
    };

    /*FireStore에 새 문서를 생성하고 데이터를 저장
    setDoc(newChannelRef, newChannel);
    newChannelRef가 가리키는 경로에 newChannel객체를 저장함*/
    await setDoc(newChannelRef, newChannel);
    //생성된문서의 ID를 반환
    return id;
}
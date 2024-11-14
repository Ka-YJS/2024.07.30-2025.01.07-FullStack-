//올바른 이메일 형식인지 확인하는 함수
export const validateEmail = email => {
    const regex = /^[0-9?A-z0-9?]+(\.)?[0-9?A-z0-9?]+@[0-9?A-z]+\.[A-z]{2}.?[A-z]{0,3}$/

    return regex.test(email);
    //정규식 조건에 맞으면 true, 아니면 false

};

//문자열에서 공백을 모두 제거하는 함수
export const removeWhitespace = text => {
    const regex = /\s/g;//공백을 찾음
    //g를 안쓰면 최초의 공백만 찾고 멈춤, 문자열의 모든 공백을 찾으려면 /g까지 써줘야 함

    return text.replace(regex, '')
}
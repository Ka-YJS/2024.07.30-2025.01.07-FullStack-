import React from "react";
import { Navigate } from "react-router-dom";

const SocialLogin = (props) => {
  const getUrlParameter = (name) => {
    //쿼리 파라미터에서 값을 추출 해 주는 함수
    let search = window.location.search;
    //window.location.search : URL에서 쿼리스트링을 가져오는 속성
    let params = new URLSearchParams(search);
    return params.get(name);
  };

  const token = getUrlParameter("token");
  //토큰이 위에함수 name값으로 들어감

  console.log("토큰 파싱: " + token);

  if (token) {
    console.log("로컬스토리지에 토큰 저장" + token);
    localStorage.setItem("ACCESS_TOKEN", token);
    return (
      <Navigate to={{
      //<Navigate/> : 페이지를 리다이렉트할 때 사용하는 컴포넌트  
          pathname: "/", state: { from: props.location },
        }}
      />
    );
  } else { //토큰이 없을 때
    return (
      <Navigate
        to={{
          pathname: "/login", state: { from: props.location },
        }}
      />
    );
  }
};

export default SocialLogin;
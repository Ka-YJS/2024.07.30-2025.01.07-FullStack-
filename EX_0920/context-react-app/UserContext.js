import React, {children, createContext, useState} from "react";

//새로운 Context생성하기, 전역변수느낌
export const UserContext = createContext();
/*createContext : 하위컨포넌트로 데이터를 전달하는 함수
  UserContext : createContext()함수를 실행하고 번환된 객체를 담는 변수
            ->이 객체는 제공(provide)하거나, 소비(consum)할 수 있는 기능을 제공함*/

/*Context의 Provider역할을 함
 ->이 컴포넌트를 사용하면 하위 컴포넌트에서 UserContext()를 사용할 수 없음*/

 /*형식 : export const 컴포넌트명 = ({매개변수명}) => { const ~~ return ~~}*/
export const UserProvider = ({children}) => {
    const [user, SetUser] = useState({name : 'John Doe', age : 30});

    return(
        /*UserContext.Provider : Provider는 Context에서 제공하는 특수한 컴포넌트로,
                                하위 컴포넌트들의 전역상태를 전달하는 역할을 함*/
        <UserContext.Provider value = {{user,SetUser}}>
            UserContext.Provider : 
            {children}
        {/* : UserProvider컴포넌트가 감싸고 있는 모든 하위 컴포넌트를 의미함 */}
        </UserContext.Provider>
    )
}

export default UserProvider;
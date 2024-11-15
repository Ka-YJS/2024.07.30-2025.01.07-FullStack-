import React,{useState,createContext } from "react";

const ProgressContext = createContext({
    inProgress : false,
    spinner : () => {},
})

const ProgressProvider = ({children}) => {
    //로딩중이냐 아니냐를 판별하는 state
    const [inProgress, setInProgress] = useState(false);
    //시작할때 true, 끝나면 false로 바꿈
    const spinner = {
        start : () => setInProgress(true),
        stop : () => setInProgress(false),
    };
    const value = {inProgress, spinner};
    return(
        <ProgressContext.Provider value={value}>
            {children}
        </ProgressContext.Provider>
    )
}

export {ProgressContext, ProgressProvider};
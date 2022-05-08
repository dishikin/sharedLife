// package com.example.test.demo.Action;

// import com.example.test.demo.Logic.BusinessException;
// import com.example.test.demo.Logic.SystemException;
// import com.example.test.demo.Logic.CheckPassLogic;

// public class CheckPassAction {
    
//     public CheckPassAction(){

//     }

//     public Boolean execute(String userName, String password){
//         Boolean check = null;

//         try{
//             CheckPassLogic cpa = new CheckPassLogic();
//             check = cpa.checkPass(userName, password);
//         }catch(BusinessException e){
//             e.printStackTrace();
//         }catch(SystemException e){
//             e.printStackTrace();
//             page = "systemErrorPage";
//         }
//         return check;
//     }
// }

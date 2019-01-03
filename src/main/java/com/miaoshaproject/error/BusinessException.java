package com.miaoshaproject.error;

/**
 * @author 1639489689@qq.com
 * @date 2018/12/17 0017 下午 10:32
 */
public class BusinessException extends RuntimeException{

//    private CommonError commonError;
//    //直接接收EmBusinessError的传参用于构造业务的异常
//    public BusinessException(CommonError commonError){
//        super();
//        this.commonError = commonError;
//    }
//
//    //接收自定义errMsg的方式构造业务异常
//    public BusinessException(CommonError commonError,String errMsg){
//        super();
//        this.commonError = commonError;
//        this.commonError.setErrMsg(errMsg);
//    }
//
//    @Override
//    public int getErrCode() {
//        return this.commonError.getErrCode();
//    }
//
//    @Override
//    public String getErrMsg() {
//        return this.commonError.getErrMsg();
//    }
//
//    @Override
//    public CommonError setErrMsg(String errMsg) {
//        this.commonError.setErrMsg(errMsg);
//        return this;
//    }

    private Integer errCode;
    public BusinessException(EmBusinessError emBusinessError) {
        super(emBusinessError.getErrMsg());
        this.errCode=emBusinessError.getErrCode();
    }

    //接收自定义errMsg的方式构造业务异常
    public BusinessException(EmBusinessError emBusinessError,String errMsg){
        super(errMsg);
        this.errCode=emBusinessError.getErrCode();
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }
}

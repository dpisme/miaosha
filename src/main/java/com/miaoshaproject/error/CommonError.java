package com.miaoshaproject.error;

/**
 * @author 1639489689@qq.com
 * @date 2018/12/16 0016 下午 5:50
 */
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}
